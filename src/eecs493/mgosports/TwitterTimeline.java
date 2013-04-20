package eecs493.mgosports;

import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterAdapter;
import twitter4j.TwitterException;
import twitter4j.TwitterMethod;
import twitter4j.User;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class TwitterTimeline extends JPanel
{
    private static final Color Blue = new Color(58, 94, 140);
    private static final Color Maize = new Color(246, 213, 101);
    
    private JPanel timeline;
    private JPanel loadMore;
    
    private Font heading = new Font("Serif", Font.BOLD, 16);
    private Font detail = new Font("Serif", Font.PLAIN, 12);
    private Font body = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
    
    private int pageNumber = 1;             // the current page displayed
    private String username;
    public static int pageSize;             // the number of tweets per page
    private int textWidth = 140;            // we know a tweet is at most 140 characters
    
    
    public TwitterTimeline(String u, boolean isFullSize)
    {
        this.setPreferredSize(new Dimension(350, isFullSize ? 460 : 290));
        pageSize = isFullSize ? 10 : 5;
        username = u;
        System.out.println("twitter timeline created");
        
        User user = twitterUISetup.getUser(username);
        
        if (user != null)
        {
            // Initialize the header
            JPanel header = new JPanel();
            header.setLayout(new GridBagLayout());
            GridBagConstraints constraints = new GridBagConstraints();
            
            try
            {
                JLabel image = new JLabel(new ImageIcon(new URL(user.getProfileImageURL())));
                constraints.gridheight = 3;
                constraints.fill = GridBagConstraints.VERTICAL;
                constraints.gridx = 0;
                constraints.gridy = 0;
                //constraints.insets = new Insets(2, 10, 2, 0);
                constraints.anchor = GridBagConstraints.FIRST_LINE_START;
                header.add(image, constraints);
                
                header.setPreferredSize(new Dimension(this.getPreferredSize().width,
                        image.getIcon().getIconHeight()));
            }
            catch (MalformedURLException e)
            {
                twitterUISetup.showErrorMessage("Error loading profile image: " + e.getMessage());
            }
            
            JLabel name = new JLabel(user.getName());
            name.setFont(heading);
            constraints.gridheight = 1;
            constraints.gridx = 1;
            constraints.gridy = 0;
            constraints.insets = new Insets(0,10,0,30);
            constraints.anchor = GridBagConstraints.FIRST_LINE_START;
            header.add(name, constraints);
            
            JLabel screenname = new JLabel("@" + user.getScreenName());
            screenname.setFont(detail);
            screenname.setForeground(Blue);
            constraints.gridx = 1;
            constraints.gridy = 1;
            constraints.anchor = GridBagConstraints.LINE_START;
            header.add(screenname, constraints);
            
            boolean isFollowing = twitterUISetup.isFollowingUser(username);
            final JButton follow = new JButton(isFollowing ? "Following" : "Follow   ");
            follow.setEnabled(!isFollowing);
            follow.setIcon(new ImageIcon("img/twitterBlueBird_16.png"));
            follow.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    boolean isFollowing = twitterUISetup.followUser(username);
                    follow.setText(isFollowing ? "Following" : "Follow   ");
                    follow.setEnabled(!isFollowing);
                }
    
                @Override
                public void mouseEntered(MouseEvent arg0) {
                    // TODO Auto-generated method stub
                    
                }
    
                @Override
                public void mouseExited(MouseEvent arg0) {
                    // TODO Auto-generated method stub
                    
                }
    
                @Override
                public void mousePressed(MouseEvent arg0) {
                    // TODO Auto-generated method stub
                    
                }
    
                @Override
                public void mouseReleased(MouseEvent arg0) {
                    // TODO Auto-generated method stub
                    
                }
            });
            constraints.gridx = 2;
            constraints.gridy = 0;
            constraints.anchor = GridBagConstraints.FIRST_LINE_END;
            constraints.insets = new Insets(0,0,0,0);
            header.add(follow, constraints);
            
            this.add(header);
            
            // Initialize the twitter feed
            timeline = new JPanel();
            timeline.setLayout(new BoxLayout(timeline, BoxLayout.PAGE_AXIS));
            SetTextWidth();
            GetNextTweets();
            JScrollPane scrollArea = new JScrollPane(timeline,
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrollArea.setPreferredSize(new Dimension(this.getPreferredSize().width,
                    this.getPreferredSize().height - header.getPreferredSize().height - 10));
            this.add(scrollArea);
        }
        else
        {
            System.out.println("'" + username + "' not found");
            JLabel notFound = new JLabel("Sorry, this user was not found on twitter.");
            this.add(notFound);
        }
    }
    
    // Calculate approx. max width of characters in a tweet
    private void SetTextWidth()
    {
        textWidth = 35;
        
        /*int charWidth = getFontMetrics(detail).stringWidth("W");
        
        // width of panel, less max width of date
        int idealWidth = this.getPreferredSize().width - (charWidth * 6); 
        
        charWidth = getFontMetrics(body).stringWidth("W");
        textWidth = idealWidth / charWidth;
        
        System.out.println("textWidth: " + textWidth);*/
    }
    
    private void GetNextTweets()
    {
        AsyncTwitterFactory factory = new AsyncTwitterFactory(twitterUISetup.config);
        AsyncTwitter twitter = factory.getInstance();
        twitter.addListener(new TwitterAdapter() {
            @Override
            public void gotUserTimeline(ResponseList<Status> statuses)
            {
                OnGotUserTimeline(statuses);
            }
            
            @Override
            public void onException(TwitterException e, TwitterMethod method)
            {
                System.out.println("Exception caught from twitter method '" +
                        method.toString() + "'");
                e.printStackTrace();
                twitterUISetup.showErrorMessage("Failed to get timeline: " + e.getMessage());
            }
        });
        
        twitter.getUserTimeline(username, new Paging(pageNumber++, pageSize));
    }
    
    public void OnGotUserTimeline(ResponseList<Status> statuses)
    {
        System.out.println("got timeline. " + username + " size: " + statuses.size());
        
        if (loadMore == null)
        {
            loadMore = new JPanel();
            loadMore.setBackground(Blue);
            loadMore.setSize(timeline.getWidth(), 20);
            final JLabel loadText = new JLabel("Load more");
            loadText.setFont(body);
            loadText.setForeground(Maize);
            loadMore.add(loadText);
            
            loadMore.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    e.getComponent().getParent().setCursor(
                            Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    timeline.remove(loadMore);
                    timeline.updateUI();
                    GetNextTweets();
                }
                
                @Override
                public void mouseEntered(MouseEvent e)
                {
                    loadText.setForeground(Color.GRAY);
                }
                
                @Override
                public void mouseExited(MouseEvent e)
                {
                    loadText.setForeground(Maize);
                }
            });
        }
        else
        {
            timeline.setCursor(Cursor.getDefaultCursor());
        }
        
        System.out.println(statuses.size());
        for (Status s : statuses)
        {
            String displayDate = GetDisplayDate(s.getCreatedAt());
            
            JPanel tweet = new JPanel();
            tweet.setLayout(new GridBagLayout());
            tweet.setBackground(Color.WHITE);
            GridBagConstraints constraints = new GridBagConstraints();
            JLabel text = new JLabel(FormatMultilineText(s.getText()));
            JLabel time = new JLabel(displayDate);
            
            text.setFont(body);
            constraints.gridheight = 3;
            constraints.gridwidth = 2;
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.anchor = GridBagConstraints.FIRST_LINE_START;
            constraints.weightx = 1;
            constraints.weighty = 1;
            constraints.insets = new Insets(2, 10, 2, 5);
            tweet.add(text, constraints);
            
            time.setFont(detail);
            time.setForeground(Blue);
            constraints.gridheight = 1;
            constraints.gridwidth = 1;
            constraints.gridx = 2;
            constraints.gridy = 0;
            constraints.anchor = GridBagConstraints.FIRST_LINE_END;
            constraints.weightx = 0;
            constraints.weighty = 0;
            constraints.insets = new Insets(2, 5, 2, 10);
            tweet.add(time, constraints);
            
            tweet.setBorder(BorderFactory.createLineBorder(Blue));
            
            timeline.add(tweet);
        }
        
        timeline.add(loadMore);
        timeline.updateUI();
    }
    
    private String GetDisplayDate(Date dateCreated)
    {
        Calendar created = Calendar.getInstance();
        created.setTime(dateCreated);
        
        Calendar now = Calendar.getInstance();
        String displayDate;

        int difYear = now.get(Calendar.YEAR) - created.get(Calendar.YEAR);
        int difMonth = now.get(Calendar.MONTH) - created.get(Calendar.MONTH);
        int difDay = now.get(Calendar.DATE) - created.get(Calendar.DATE);
        int difHour = now.get(Calendar.HOUR_OF_DAY) - created.get(Calendar.HOUR_OF_DAY);
        int difMin = now.get(Calendar.MINUTE) - created.get(Calendar.MINUTE);
        if (difYear > 0 || difMonth > 0 || difDay > 0)
        {
            displayDate = created.get(Calendar.DATE) + " " +
                    (new DateFormatSymbols()).getMonths()[created.get(Calendar.MONTH)].substring(0, 3);
        }
        else if (difHour > 0)
            displayDate = difHour + "h";
        else
            displayDate = difMin + "m";
        
        return displayDate;
    }
    
    private String FormatMultilineText(String text)
    {
        StringBuilder formattedText = new StringBuilder("<html><pre>");
        
        int startIndex = 0;
        while (startIndex < text.length())
        {
            formattedText.append("\n");
            int stopIndex = startIndex + textWidth;
            if (stopIndex > text.length())
            {
                formattedText.append(text.substring(startIndex, text.length()).trim());
                break;
            }
            else
            {
                String textSegment = text.substring(startIndex, startIndex + textWidth).trim();
                
                int lastSpace = textSegment.lastIndexOf(' ');
                if (lastSpace > 0)
                {
                    formattedText.append(textSegment.substring(0, lastSpace));
                    startIndex += lastSpace + 1;
                }
                else
                {
                    formattedText.append(text.substring(startIndex, --stopIndex));
                    formattedText.append('-');
                    startIndex = stopIndex + 1;
                }
            }
        }
        
        formattedText.append("</pre></html>");
        
        return formattedText.toString();
    }
}
