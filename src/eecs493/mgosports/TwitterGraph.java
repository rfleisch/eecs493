package eecs493.mgosports;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Paging;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class TwitterGraph extends JPanel
{
  /**
   * 
   */
  private static final long serialVersionUID = 3721139679703987701L;
  private ChartPanel chartPanel;
  double[][] dailyCount;
  
  public TwitterGraph()
  {
    dailyCount = new double[1][31];
    for (int i = 0; i < 31; ++i)
      dailyCount[0][i] = 0.0;
    buildUI();
  }

  private void buildUI()
  {
	  //GridLayout mainLayout = new GridLayout(1,1);
	  //this.setLayout(mainLayout);
	  this.setBackground(new Color(255,215,0));
	  JPanel mainFrame = new JPanel();
	  mainFrame.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	  mainFrame.setBackground(Color.WHITE);
	  mainFrame.setLayout(new BorderLayout());
	  JLabel userLabel = new JLabel();
	  Font font = new Font("Arial", Font.BOLD, 30);
	  userLabel.setFont(font);
	  
	  if (twitterUISetup.isAuthorized())
	  {
		  try
		  {
			  Twitter twitter = twitterUISetup.getTwitter();
			  String username = twitter.getScreenName();
			  userLabel.setText("My Profile");
			  
			  mainFrame.add(userLabel, BorderLayout.NORTH);
			  
			  JPanel userDataPanel = new JPanel(new BorderLayout());
			  
			  this.getGraphByUser(username);
			  userDataPanel.add(chartPanel, BorderLayout.EAST);
			  JPanel tweets = new JPanel();
			  tweets.setPreferredSize(new Dimension(350, 470));
			  TwitterTimeline timeline = new TwitterTimeline(username, true);
			  tweets.add(timeline);
			  userDataPanel.add(tweets, BorderLayout.WEST);
			  mainFrame.add(userDataPanel, BorderLayout.SOUTH);
		  }
		  catch (TwitterException e)
		  {
			  e.getStackTrace();
		  }
	  }
	  else
	  {
		  userLabel.setText("Please Sign in to Twitter");
		  mainFrame.add(userLabel, BorderLayout.NORTH);
	  }
	  this.add(mainFrame, BorderLayout.CENTER);
  }
  
  public void getGraphByUser(String username)
  {
    try
    {
      Twitter twitter = TwitterFactory.getSingleton();
      
      // Get the first 200 Tweets from User (limits me to 200)
      List<Status> statuses = twitter.getUserTimeline(username, new Paging(1, 200));
      
      // Set a calendar date for the last month
      Calendar counter = Calendar.getInstance();
      counter.add(Calendar.MONTH, -1);
      Date today = new Date();
      
      // Reset the count
      for (int i = 0; i < 31; ++i)
        dailyCount[0][i] = 0.0;
      for (Status status : statuses)
      {
        // Break if the tweet was outside of last month
        if (status.getCreatedAt().compareTo(counter.getTime()) < 0)
          break;
        
        // Find amount of time between today and the tweet
        int diffInDays = (int)( (today.getTime() - status.getCreatedAt().getTime()) 
            / (1000 * 60 * 60 * 24) );
        
        // Increase the count in dailyCount
        dailyCount[0][diffInDays] += 1.0;
      }
      
      // Update the graph
      chartPanel = Chart.createChartPanel(dailyCount);
    }
    catch(TwitterException e)
    {
      e.printStackTrace();
      //showErrorMessage("There was an error loading the graph data: " + e.getMessage());      
    }    
  }
  
  public void getGraphByHashtag(String hashtag)
  {
    try
    {
      Twitter twitter = TwitterFactory.getSingleton();
      Query query = new Query("#" + hashtag);
      QueryResult result = twitter.search(query);
      for (Status status : result.getTweets()) {
          System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
      }
    }
    catch(TwitterException e)
    {
      e.printStackTrace();
      //showErrorMessage("There was an error loading the graph data: " + e.getMessage());      
    }
  }
  
}
