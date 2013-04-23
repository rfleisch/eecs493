package eecs493.mgosports;

import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterAdapter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Paging;
import twitter4j.TwitterMethod;

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
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

public class TwitterGraph extends JPanel
{
  /**
   * 
   */
  private static final long serialVersionUID = 3721139679703987701L;
  private static final Color YELLOW = new Color(255,215,0);
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
	  String username = twitterUISetup.getScreenName();
	  this.setBackground(YELLOW);
	  JPanel mainFrame = new JPanel();
	  mainFrame.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	  mainFrame.setBackground(YELLOW);
	  mainFrame.setLayout(new BorderLayout());
	  JLabel userLabel = new JLabel();
	  Font font = new Font("Arial", Font.BOLD, 30);
	  userLabel.setFont(font);
	  
	  chartPanel = Chart.createChartPanel(dailyCount);
	  userLabel.setText("My Profile");
	  
	  mainFrame.add(userLabel, BorderLayout.NORTH);
	  
	  JPanel userDataPanel = new JPanel(new BorderLayout());
	  
	  userDataPanel.add(chartPanel, BorderLayout.EAST);
	  JPanel tweets = new JPanel();
	  tweets.setPreferredSize(new Dimension(350, 470));
	  TwitterTimeline timeline = new TwitterTimeline(username, true);
	  tweets.add(timeline);
	  userDataPanel.add(tweets, BorderLayout.WEST);
	  userLabel.setText((twitterUISetup.isAuthorized()) ? "My Profile" : "Please Sign in to Twitter!");
	  mainFrame.add(userDataPanel, BorderLayout.SOUTH);
	  this.add(mainFrame, BorderLayout.CENTER);
	  this.loadGraphDataByUser();
  }
  
  private void loadGraphByUser(ResponseList<Status> statuses)
  {
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
      JFreeChart chart = chartPanel.getChart();
      CategoryPlot plot = chart.getCategoryPlot();
	  CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
		    	"", "", dailyCount
	  );
      plot.setDataset(dataset);
  }
  
  private void loadGraphDataByUser()
  {
	  if (twitterUISetup.isAuthorized())
	  {
		  String username = twitterUISetup.getScreenName();
	      AsyncTwitterFactory factory = new AsyncTwitterFactory(twitterUISetup.config);
	      AsyncTwitter twitter = factory.getInstance();
	      twitter.addListener(new TwitterAdapter() {
	          @Override
	          public void gotUserTimeline(ResponseList<Status> statuses)
	          {
	        	  loadGraphByUser(statuses);
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
	      
	      twitter.getUserTimeline(username, new Paging(1, 200));
	  }
  }
  
}
