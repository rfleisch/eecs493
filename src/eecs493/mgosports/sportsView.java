package eecs493.mgosports;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class sportsView extends JPanel
{
  
  private JLabel title;
  private JTextField twitterTextBox;
  private String sport;
  private JPanel schedule;
  private JPanel roster;
  private JPanel tweets;
  private ArrayList<hockeyPlayerPic> hockeyRoster;
  private JLayeredPane layer = new JLayeredPane();
  
  public sportsView(String sport_) {
    sport = sport_;
    setLayout(new BorderLayout(0,0));
    setBackground(Color.YELLOW);
    hockeyRoster = new hockeyRoster().getRoster();

    
    JPanel spacingW = new JPanel();
    spacingW.setPreferredSize(new Dimension(50,400));
    spacingW.setBackground(Color.YELLOW);
    JPanel spacingE = new JPanel();
    spacingE.setPreferredSize(new Dimension(50,400));
    spacingE.setBackground(Color.YELLOW);
    
    
    tweetSetup();
    this.add(spacingW, BorderLayout.WEST);
    this.add(spacingE, BorderLayout.EAST);
    tabsSetup();
    scheduleTabSetup();
    rosterTabSetup();
    tweetsTabSetup();
    
    
    
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
    tabbedPane.setPreferredSize(new Dimension(300, 400));
    tabbedPane.setBackground(Color.YELLOW);
    //ImageIcon icon = createImageIcon("images/middle.gif");

    schedule = new JPanel();
    schedule.setPreferredSize(new Dimension(300, 400));
    schedule.setBackground(Color.YELLOW);
    tabbedPane.addTab("Schedule", schedule);
    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

    roster = new JPanel();
    roster.setPreferredSize(new Dimension(300, 400));
    roster.setBackground(Color.YELLOW);
    tabbedPane.addTab("Roster", roster);
    tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
    
    tweets = new JPanel();
    tweets.setPreferredSize(new Dimension(300, 400));
    tweets.setBackground(Color.YELLOW);
    tabbedPane.addTab("Tweets", tweets);
    tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
    

    this.add(tabbedPane, BorderLayout.CENTER);
  }
  
  public void scheduleTabSetup() {
    
    String[] columns = {"Date", "Opponent", "Location", "Time"};

    Object[][] data = {
        {"Tue., Oct. 9", "vs. Windsor ex", "Yost Ice Arena", "W 7-3"},
        {"Thu., Oct 11", "vs Rochester Institute of Technology", "Yost Ice Arena", "L 5-4 (OT)" },
        {"Fri., Oct. 12", "vs Rochester Institute of Technology",  "Yost Ice Arena", "W 7-2"}
    };

    JTable table = new JTable(data, columns);
    
    JScrollPane scrollPane = new JScrollPane(table);
    table.setFillsViewportHeight(true);
    
    schedule.add(scrollPane, BorderLayout.CENTER);
    
  }
  
  public void rosterTabSetup() {
    
    
    String[] columns = {"Number", "Name", "Pos", "DOB", "Hometown"};

    Object[][] data = {
        {"1", "Steve Racine", "G", "08/28/1991", "Williamsville, N.Y."},
        {"2", "Mike Chiasson", "D", "03/28/1991", "Henderson, Nev." },
        {"4", "Kevin Clare",  "D", "03/13/1992", "New Rochelle, N.Y."}
    };

    final JTable tableRoster = new JTable(data, columns);

    
    JScrollPane scrollPane = new JScrollPane(tableRoster);
    tableRoster.setFillsViewportHeight(true);
    
    roster.add(scrollPane, BorderLayout.CENTER);
    
    tableRoster.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
          System.out.println("row clicked");
        
        Object nameObject = tableRoster.getValueAt(tableRoster.getSelectedRow(), 1);
        ImageIcon facePic = hockeyRoster.get(tableRoster.getSelectedRow()).getPicture();
        JLabel face = new JLabel(facePic);
        

        
        /*
        JInternalFrame frame = new JInternalFrame(nameObject.toString(), true, true, true, true);
        frame.setPreferredSize(new Dimension(100, 100));
        frame.add(face);
        frame.moveToFront();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(frame);
        frame.pack();
        frame.setVisible(true);
      */
        
        JDialog popup = new JDialog();
        JPanel facePan = new JPanel();
        facePan.add(face);
        popup.add(facePan);
        popup.pack();
        popup.setVisible(true);
        popup.setLocation(200, 200);
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
        
        
        
        
        
        
      }
  });
    
    
  }
  
  public void tweetsTabSetup() {
    
  }

}
