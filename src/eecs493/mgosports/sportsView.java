package eecs493.mgosports;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class sportsView extends JPanel
{
  
  private JLabel title;
  private JTextField twitterTextBox;
  private String sport;
  private JPanel schedule;
  private JPanel roster;
  private JPanel tweets;
  private ArrayList<hockeyPlayerPic> hockeyRoster;
  private ArrayList<footballPlayerPic> footballRoster;
  private ArrayList<basketballPlayerPic> basketballRoster;
  private JLayeredPane layer = new JLayeredPane();
  private player person;
  private JPanel playerProfile;
   
  protected String twitterName;
  
  public sportsView(String sport_, String username) {
    sport = sport_;
    playerProfile = new JPanel();
    playerProfile.setPreferredSize(new Dimension(350,100));
    playerProfile.setBackground(Color.YELLOW);
    setLayout(new BorderLayout(10,0));
    this.setPreferredSize(new Dimension(850, 550));
    setBackground(Color.YELLOW);
    hockeyRoster = new hockeyRoster().getRoster();
    footballRoster = new footballRoster().getRoster();
    basketballRoster = new basketballRoster().getRoster();
    
    twitterName = username;
    
    JPanel spacingW = new JPanel();
    spacingW.setPreferredSize(new Dimension(10,400));
    spacingW.setBackground(Color.ORANGE);

    
    
    tweetSetup();
    //this.add(spacingW, BorderLayout.CENTER);
    tabsSetup();
    this.add(playerProfile, BorderLayout.EAST);
    //setupPlayerProfile();
    //scheduleTabSetup();
    //rosterTabSetup();
    tweetsTabSetup();
    //this.add(spacingW, BorderLayout.CENTER);
    
    
    
  }
  
  public void tweetSetup() {
    TwitterTweeter tweetPanel = new TwitterTweeter(sport);
    this.add(tweetPanel, BorderLayout.NORTH);
  }
  
  
  
  public void tabsSetup() {
    JTabbedPane tabbedPane = new JTabbedPane();
    tabbedPane.setPreferredSize(new Dimension(450, 470));
    tabbedPane.setBackground(Color.YELLOW);

    schedule = new JPanel();
    schedule.setPreferredSize(new Dimension(400, 470));
    schedule.setBackground(Color.YELLOW);
    tabbedPane.addTab("Schedule", schedule);
    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

    roster = new JPanel();
    roster.setPreferredSize(new Dimension(300, 470));
    roster.setBackground(Color.YELLOW);
    tabbedPane.addTab("Roster", roster);
    tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
    
    tweets = new JPanel();
    tweets.setPreferredSize(new Dimension(300, 470));
    tweets.setBackground(Color.YELLOW);
    TwitterTimeline timeline = new TwitterTimeline(twitterName);
    tweets.add(timeline);
    
    tabbedPane.addTab("Tweets", tweets);
    tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
    
    tabbedPane.addChangeListener(new ChangeListener() {

      @Override
      public void stateChanged(ChangeEvent e)
      {
        System.out.println(" now clicked");
        playerProfile.removeAll();
        playerProfile.updateUI();
        
      }
      
    });
    
    this.add(tabbedPane, BorderLayout.CENTER);
  }
  
  public void scheduleTabSetup(String[] columns, Object[][] data) {
    

    JTable table = new JTable(data, columns);
    table.setPreferredSize(new Dimension(300, 470));
    
    JScrollPane scrollPane = new JScrollPane(table);
    table.setFillsViewportHeight(true);
    
    schedule.add(scrollPane, BorderLayout.WEST);
    
  }
  
  public void rosterTabSetup(String[] columns, Object[][] data) {
    
    final JTable tableRoster = new JTable(data, columns);

  
    JScrollPane scrollPane = new JScrollPane(tableRoster);
    tableRoster.setFillsViewportHeight(true);
    
    roster.add(scrollPane, BorderLayout.CENTER);
    
    tableRoster.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
          System.out.println("row clicked");
        
        ///Object nameObject = tableRoster.getValueAt(tableRoster.getSelectedRow(), 1);
        ImageIcon facePic = null;
        if(sport.compareTo("hockey") == 0 ) {
           facePic = hockeyRoster.get(tableRoster.getSelectedRow()).getPicture();
           person = hockeyRoster.get(tableRoster.getSelectedRow());

        } else if (sport.compareTo("football") == 0  ) {
          facePic = footballRoster.get(tableRoster.getSelectedRow()).getPicture();
          person = footballRoster.get(tableRoster.getSelectedRow());
          
        } else if (sport.compareTo("basketball") == 0 ) {
          facePic = basketballRoster.get(tableRoster.getSelectedRow()).getPicture();
          person = basketballRoster.get(tableRoster.getSelectedRow());
          
        }
        JLabel face = new JLabel(facePic);
        setupPlayerProfile();
        updateUI();
        
        
        /*JDialog popup = new JDialog();
        JPanel facePan = new JPanel();
        facePan.add(face);
        popup.add(facePan);
        popup.pack();
        popup.setVisible(true);
        popup.setLocation(200, 200);
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        */
     
      }
  });
    
    
  }
  
  public void setupPlayerProfile() {
    playerProfile.removeAll();
    this.remove(playerProfile);
    playerProfile = new JPanel();
    playerProfile.setLayout(new BorderLayout(10,10));
    playerProfile.setPreferredSize(new Dimension(350,100));
    playerProfile.setBackground(Color.YELLOW);
    
    JPanel spacingN = new JPanel();
    JLabel profileLabel = new JLabel("Player Profile");
    profileLabel.setFont(new Font("Times Roman", Font.BOLD, 18));
    profileLabel.setAlignmentX(CENTER_ALIGNMENT);
    spacingN.setPreferredSize(new Dimension(350,35));
    spacingN.setBackground(Color.YELLOW);
    spacingN.add(profileLabel);
    
    JPanel spacingS = new JPanel();
    spacingS.setPreferredSize(new Dimension(350,300));
    spacingS.setBackground(Color.YELLOW);
    
    JLabel name = new JLabel("Name: " + person.getName());
    JLabel number = new JLabel("Number: " + person.getNum());
    JLabel position = new JLabel("Position: " + person.getPos());
    JPanel info = new JPanel();
    info.setLayout(new BoxLayout(info, BoxLayout.PAGE_AXIS));
    info.setBackground(Color.YELLOW);
    info.add(name);
    info.add(number);
    info.add(position);
    
    info.setAlignmentX(LEFT_ALIGNMENT);
    name.setFont(new Font("Times Roman", Font.BOLD, 14));
    number.setFont(new Font("Times Roman", Font.BOLD, 14));
    position.setFont(new Font("Times Roman", Font.BOLD, 14));

    playerProfile.add(info, BorderLayout.CENTER);
    playerProfile.add(spacingN, BorderLayout.NORTH);
    

    JLabel face = new JLabel(person.getPicture());
    face.setAlignmentX(TOP_ALIGNMENT);
    
    playerProfile.add(face, BorderLayout.WEST);
    playerProfile.add(spacingS, BorderLayout.SOUTH);
    
    this.add(playerProfile, BorderLayout.EAST);
    
  }
  
  public void tweetsTabSetup() {
    
  }

}
