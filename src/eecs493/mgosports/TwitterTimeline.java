package eecs493.mgosports;

import twitter4j.Status;
import twitter4j.User;

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
            JLabel label = new JLabel(s.getText());
            label.setVisible(true);
            timeline.add(label);
        }
        
        
    }
}
