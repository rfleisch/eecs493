package eecs493.mgosports;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class tweetpanelwidget extends JPanel
{
  
  private JTextField twitterTextBox;
  
  public tweetpanelwidget(String sport) {
    //JPanel tweetPanel = new JPanel();
    setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
    setBackground(Color.YELLOW);
    setOpaque(true);
    setPreferredSize(new Dimension(590, 50));
    
    twitterTextBox = new JTextField( 35);
    setTweetText(sport);
    ImageIcon bird = new ImageIcon("medBlueBird.png");
    JLabel twitterLogo = new JLabel(bird);
    
    JButton btnTweet = new JButton("Tweet");
    btnTweet.setPreferredSize(new Dimension(65,30));
    
    add(twitterLogo);
    add(twitterTextBox);
    add(btnTweet); 
  }
  
  public void setTweetText(String title_) {  
    if(title_.compareTo("hockey") == 0) {
      twitterTextBox.setText("Tweet about Michigan Hockey!");
    } else if (title_.compareTo("football") == 0) {
      twitterTextBox.setText("Tweet about Michigan Football!");
    } else if (title_.compareTo("basketball") == 0) {
      twitterTextBox.setText("Tweet about Michigan Basketball!");
    }    
  }

}
