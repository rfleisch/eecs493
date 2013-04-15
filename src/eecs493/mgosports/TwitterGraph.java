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
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Dimension;

import javax.swing.JPanel;

public class TwitterGraph extends JPanel
{
  /**
   * 
   */
  private static final long serialVersionUID = 3721139679703987701L;
  private BufferedImage graph;
  int[] dailyCount;
  
  public TwitterGraph()
  {
    dailyCount = new int[31];
    for (int i = 0; i < 31; ++i)
      dailyCount[i] = 0;
    buildUI();
  }

  @Override
  public Dimension getPreferredSize()
  {
    return graph == null ? super.getPreferredSize() : new Dimension(graph.getWidth(), graph.getHeight());
  }
  
  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    if (graph !=  null)
    {
      int x = (getWidth() - graph.getWidth()) / 2;
      int y = (getHeight() - graph.getHeight()) / 2;
      g.drawImage(graph, x, y, this);
    }
  }
  
  private void buildUI()
  {
    setBackground(Color.YELLOW);
    updateGraph();
  }
  
  private void updateGraph()
  {
    graph = Graph.getGraph(dailyCount);
    setSize(graph.getWidth(), graph.getHeight());
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
        dailyCount[i] = 0;
      for (Status status : statuses)
      {
        // Break if the tweet was outside of last month
        if (status.getCreatedAt().compareTo(counter.getTime()) < 0)
          break;
        
        // Find amount of time between today and the tweet
        int diffInDays = (int)( (today.getTime() - status.getCreatedAt().getTime()) 
            / (1000 * 60 * 60 * 24) );
        
        // Increase the count in dailyCount
        ++dailyCount[diffInDays];
      }
      
      // Update the graph
      updateGraph();
      
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
