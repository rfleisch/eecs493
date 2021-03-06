package eecs493.mgosports;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TwitterTweeter extends JPanel
{
  
  private final JTextField twitterTextBox = new JTextField(35);
  private Color blue = new Color(0,0,128);
  private Color yellow = new Color(255,215,0);
  
  public TwitterTweeter(final String sport)
  {
    //JPanel tweetPanel = new JPanel();
    setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
    setBackground(yellow);
    setOpaque(true);
    setPreferredSize(new Dimension(590, 50));
    twitterTextBox.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent arg0)
        {
            System.out.println("select");
            
            if (Color.GRAY == twitterTextBox.getForeground())
            {
                twitterTextBox.setText("");
                twitterTextBox.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(FocusEvent arg0)
        {
            System.out.println("deselect");
            if (twitterTextBox.getText().trim().isEmpty())
                setTweetDescription(sport);
        }
        
    });
    
    setTweetDescription(sport);
    ImageIcon bird = new ImageIcon("medBlueBird.png");
    JLabel twitterLogo = new JLabel(bird);
    
    JButton btnTweet = new JButton("Tweet");
    btnTweet.setPreferredSize(new Dimension(65,30));
    btnTweet.addMouseListener(new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if (twitterUISetup.tweet(twitterTextBox.getText()))
            {
                JOptionPane.showMessageDialog(null, "Twitter status updated successfully!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                setTweetDescription(sport);
            }
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
    
    add(twitterLogo);
    add(twitterTextBox);
    add(btnTweet); 
  }
  
  public void setTweetDescription(String title_)
  {  
      twitterTextBox.setForeground(Color.GRAY);
    if(title_.compareTo("hockey") == 0)
    {
      twitterTextBox.setText("Tweet about Michigan Hockey!");
    }
    else if (title_.compareTo("football") == 0)
    {
      twitterTextBox.setText("Tweet about Michigan Football!");
    }
    else if (title_.compareTo("basketball") == 0)
    {
      twitterTextBox.setText("Tweet about Michigan Basketball!");
    }    
  }

}
