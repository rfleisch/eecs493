package eecs493.mgosports;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class sportsView extends JPanel
{
  
  private JLabel title;
  private JTextField twitterTextBox;
  private String sport;
  
  public sportsView(String sport_) {
    sport = sport_;
    setLayout(new BorderLayout(0,0));
    setBackground(Color.YELLOW);
    
    tweetSetup();
    tabsSetup();
    
  }
  
  public void tweetSetup() {
    JPanel tweetPanel = new JPanel();
    tweetPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
    tweetPanel.setBackground(Color.YELLOW);
    tweetPanel.setOpaque(true);
    tweetPanel.setPreferredSize(new Dimension(590, 50));
    
    twitterTextBox = new JTextField( 35);
    setTweetText(sport);
    ImageIcon bird = new ImageIcon("medBlueBird.png");
    JLabel twitterLogo = new JLabel(bird);
    
    JButton btnTweet = new JButton("Tweet");
    btnTweet.setPreferredSize(new Dimension(65,30));
    
    tweetPanel.add(twitterLogo);
    tweetPanel.add(twitterTextBox);
    tweetPanel.add(btnTweet);
    
    this.add(tweetPanel, BorderLayout.NORTH);
  }
  
  
  
  public void setTweetText(String title_) {  
    if(title_.compareTo("hockey") == 0) {
      twitterTextBox.setText("Tweet about Michigan Hockey");
    } else if (title_.compareTo("football") == 0) {
      twitterTextBox.setText("Tweet about Michigan Football");
    } else if (title_.compareTo("basketball") == 0) {
      twitterTextBox.setText("Tweet about Michigan Basketball");
    }		 
  }
  
  public void tabsSetup() {
    JTabbedPane tabbedPane = new JTabbedPane();
    tabbedPane.setPreferredSize(new Dimension(500, 400));
    //ImageIcon icon = createImageIcon("images/middle.gif");

    JPanel schedule = new JPanel();
    schedule.setPreferredSize(new Dimension(500, 400));
    schedule.setBackground(Color.GREEN);
    tabbedPane.addTab("Schedule", schedule);
    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

    JPanel roster = new JPanel();
    roster.setPreferredSize(new Dimension(500, 400));
    roster.setBackground(Color.RED);
    tabbedPane.addTab("Roster", roster);
    tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
    
    JPanel tweets = new JPanel();
    tweets.setPreferredSize(new Dimension(500, 400));
    tweets.setBackground(Color.ORANGE);
    tabbedPane.addTab("Tweets", tweets);
    tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
    
    this.add(tabbedPane, BorderLayout.CENTER);
  }

}
