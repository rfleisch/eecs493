package eecs493.mgosports;

import twitter4j.Status;
import twitter4j.User;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ImageIcon;

public class TwitterTimeline extends JPanel
{
    private JPanel timeline;
    
    private int pageNumber = 1;             // the current page displayed
    private String username;
    
    public TwitterTimeline()
    {
        username = "umich";
        System.out.println("twitter timeline created");
        
        // Initialize the header
        JPanel header = new JPanel();
        User user = twitterUISetup.getUser(username);
        
        
        try
        {
            JLabel image = new JLabel(new ImageIcon(new URL(user.getProfileImageURL())));
            this.add(image);
        }
        catch (MalformedURLException e)
        {
            twitterUISetup.showErrorMessage("Error loading profile image: " + e.getMessage());
        }
        JLabel name = new JLabel(user.getName());
        JLabel username = new JLabel(user.getScreenName());
        
        
        this.add(name);
        this.add(username);
        
        
        // Initialize the twitter feed
        timeline = new JPanel();
        timeline.setLayout(new BoxLayout(timeline, BoxLayout.PAGE_AXIS));
        GetNextTweets();
        JScrollPane scrollArea = new JScrollPane(timeline,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollArea.setPreferredSize(new Dimension(300, 375));
        this.add(scrollArea);
    }
    
    private void GetNextTweets()
    {
        // remove the "load more" component, when present
        if (pageNumber > 1)
            timeline.remove(timeline.getComponentCount());
        
        List<Status> statuses = twitterUISetup.getTimeline(username, pageNumber++);
        for (Status s : statuses)
        {
            String displayDate = GetDisplayDate(s.getCreatedAt());
            
            JPanel tweet = new JPanel();
            JLabel text = new JLabel(s.getText());
            JLabel time = new JLabel(displayDate);
            
            tweet.add(text);
            tweet.add(time);
            
            timeline.add(tweet);
        }
        
        // add the "load more" card
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
        int difHour = now.get(Calendar.HOUR) - created.get(Calendar.HOUR);
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
}
