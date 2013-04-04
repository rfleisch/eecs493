package eecs493.mgosports;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class MainWindow extends JDialog
{
  
  private JFrame window;
  private JLabel fav;
  private JLabel starLabelFoot;
  private JLabel starLabelHock;
  private JLabel starLabelBask;
  private JLabel hockey;
  private JLabel football;
  private JLabel basketball;
  private ImageIcon clearStar = new ImageIcon("img/clearStar.png");
  private ImageIcon yellowStar = new ImageIcon("img/yellowStar.png");
  private JPanel favPanel;
  private JPanel footPanel;
  private JPanel hockeyPanel;
  private JPanel basketPanel;
  private boolean favBask;
  private boolean favHock;
  private boolean favFoot;
  private String selectedTab;
  private twitterUISetup twitter;
  //private sportsView sv;
  private hockeyview hv;
  private basketballview bv;

  
  
  
  public MainWindow() {
    favBask = false;
    favHock = false;
    favFoot = false;
    selectedTab = "favorite";

    
    window = new JFrame("MGoSports");
    window.setLayout(new BorderLayout());
    
    createTitleNorth();
    createTabPanelWest();
    createCenter();
    
    //window.setBackground(new Color(0,0,139));
    
    window.pack();
    window.setSize(700,500);
    window.setVisible(true);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  }
  
  private void createTitleNorth() {
    JPanel titlePanel = new JPanel();
    titlePanel.setLayout(new BorderLayout(10,10));
    titlePanel.setPreferredSize(new Dimension(700, 100));
    titlePanel.setBackground(Color.BLUE);
    
    ImageIcon Mlogo = new ImageIcon("img/mgosportslogo.png");
    
    Image img = Mlogo.getImage();
    Image newimg = img.getScaledInstance(500, 80,  java.awt.Image.SCALE_SMOOTH);  
    ImageIcon newIcon = new ImageIcon(newimg);  
    
     
    JLabel title = new JLabel(newIcon);
    title.setBackground(Color.BLUE);
    title.setOpaque(true);
    titlePanel.add(title, BorderLayout.WEST);
    title.setPreferredSize(new Dimension( 520, 100));
    
    
    JPanel twitterPanel = TwitterAuthorization.GetPanel();
    titlePanel.add(twitterPanel, BorderLayout.EAST);    
    titlePanel.setAlignmentX(LEFT_ALIGNMENT);
    window.add(titlePanel, BorderLayout.NORTH);  
  }
  
  private void createTabPanelWest() {
    JPanel list = new JPanel();
    list.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    list.setBackground(Color.BLUE);
    list.setOpaque(true);
    list.setPreferredSize(new Dimension(110, 90));
    list.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
    
    
    //Favorite Tab
    favPanel = new JPanel();
    favPanel.setBackground(Color.YELLOW);
    favPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    favPanel.setPreferredSize(new Dimension(110, 30));
    
    //ImageIcon star = new ImageIcon("img/yellowStar.png");
    //starLabelFav = new JLabel(yellowStar);
    //favPanel.add(starLabelFav);
    
    fav = new JLabel("Favorite", JLabel.CENTER);
    fav.setFont(new Font("Arial", Font.BOLD, 14));
    fav.setHorizontalAlignment(4);
    favPanel.add(fav);
    

    //Football Tab
    footPanel = new JPanel();
    footPanel.setBackground(Color.BLUE);
    footPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    footPanel.setPreferredSize(new Dimension(110, 30));
    
    //ImageIcon starFoot = new ImageIcon("img/clearStar.png");
    starLabelFoot = new JLabel(clearStar);
    footPanel.add(starLabelFoot);
    
    football = new JLabel("Football", JLabel.CENTER);
    football.setFont(new Font("Arial", Font.BOLD, 14));
    football.setHorizontalAlignment(4);
    footPanel.add(football);
    
    //Hockey Tab
    hockeyPanel = new JPanel();
    hockeyPanel.setBackground(Color.BLUE);
    hockeyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    hockeyPanel.setPreferredSize(new Dimension(110,30));
    
    //ImageIcon starHock = new ImageIcon("img/clearStar.png");
    starLabelHock = new JLabel(clearStar);
    hockeyPanel.add(starLabelHock);
    
    hockey = new JLabel("Hockey", JLabel.CENTER);
    hockey.setFont(new Font("Arial", Font.BOLD, 14));
    hockey.setHorizontalAlignment(4);
    hockeyPanel.add(hockey);
    
    //Basketball Tab
    basketPanel = new JPanel();
    basketPanel.setBackground(Color.BLUE);
    basketPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    basketPanel.setPreferredSize(new Dimension(110,30));
    
    //ImageIcon starBask = new ImageIcon("img/clearStar.png");
    starLabelBask = new JLabel(clearStar);
    basketPanel.add(starLabelBask);
    
    basketball = new JLabel("Basketball", JLabel.CENTER);
    basketball.setFont(new Font("Arial", Font.BOLD, 14));
    basketball.setHorizontalAlignment(4);
    basketPanel.add(basketball);
    
    favPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
          System.out.println("favorite label");
          favPanel.setBackground(Color.YELLOW);
          footPanel.setBackground(Color.BLUE);
          hockeyPanel.setBackground(Color.BLUE);
          basketPanel.setBackground(Color.BLUE);
          
          
          if(selectedTab.compareTo("hockey") == 0) {
            hv.removeAll();
            window.remove(hv);
          } else if ( selectedTab.compareTo("basketball") == 0 ) {
            bv.removeAll();
            window.remove(bv);
          } else if ( selectedTab.compareTo("football") == 0 ) {
            
          }
          
          twitter = new twitterUISetup();
          window.add(twitter, BorderLayout.CENTER);
          
          favPanel.updateUI();
          footPanel.updateUI();
          hockeyPanel.updateUI();
          basketPanel.updateUI();
          selectedTab = "favorite";
      }
  });
    
    footPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
          System.out.println("favorite label");
          favPanel.setBackground(Color.BLUE);
          footPanel.setBackground(Color.YELLOW);
          hockeyPanel.setBackground(Color.BLUE);
          basketPanel.setBackground(Color.BLUE);
          
          if(selectedTab.compareTo("hockey") == 0) {
            hv.removeAll();
            window.remove(hv);
          } else if ( selectedTab.compareTo("basketball") == 0 ) {
            bv.removeAll();
            window.remove(bv);
          } else if ( selectedTab.compareTo("favorite") == 0 ) {
            
          }
          
          
          
          selectedTab = "football";
          favPanel.updateUI();
          footPanel.updateUI();
          hockeyPanel.updateUI();
          basketPanel.updateUI();
      }
  });
    
    hockeyPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
          System.out.println("hockey label");
          favPanel.setBackground(Color.BLUE);
          footPanel.setBackground(Color.BLUE);
          hockeyPanel.setBackground(Color.YELLOW);
          basketPanel.setBackground(Color.BLUE);
          
          if(selectedTab.compareTo("favorite") == 0) {
            twitter.removeAll();
            window.remove(twitter);
          } else if ( selectedTab.compareTo("basketball") == 0 ) {
            bv.removeAll();
            window.remove(bv);
          } else if ( selectedTab.compareTo("football") == 0 ) {
            
          }
          
          
          hv = new hockeyview(); 
          window.add(hv, BorderLayout.CENTER);
          
          selectedTab = "hockey";
          favPanel.updateUI();
          footPanel.updateUI();
          hockeyPanel.updateUI();
          basketPanel.updateUI();
          
      }
  });
    
    basketPanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
          System.out.println("favorite label");
          favPanel.setBackground(Color.BLUE);
          footPanel.setBackground(Color.BLUE);
          hockeyPanel.setBackground(Color.BLUE);
          basketPanel.setBackground(Color.YELLOW);
          
          if(selectedTab.compareTo("hockey") == 0) {
            hv.removeAll();
            window.remove(hv);
          } else if ( selectedTab.compareTo("favorite") == 0 ) {
            twitter.removeAll();
            window.remove(twitter);
          } else if ( selectedTab.compareTo("football") == 0 ) {
            
          }
          
          
          bv = new basketballview(); 
          window.add(bv, BorderLayout.CENTER);
          
          selectedTab = "basketball";
          favPanel.updateUI();
          footPanel.updateUI();
          hockeyPanel.updateUI();
          basketPanel.updateUI();
      }
  });
    
    
    
    
    
    
    starLabelFoot.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
          System.out.println("Football");
          if(favFoot) {
            System.out.println("to clear from yellow");
            starLabelFoot.setIcon(clearStar);
            favFoot = false;
            
          } else {
            System.out.println("to yellow from clear");
            starLabelFoot.setIcon(yellowStar);
            favFoot = true;
          }
          starLabelFoot.updateUI();          
      }
  });
    
    
    
    
    starLabelHock.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
          System.out.println("hockey");
          if(favHock) {
            System.out.println("to clear from yellow");
            starLabelHock.setIcon(clearStar);
            favHock = false;
            
          } else {
            System.out.println("to yellow from clear");
            starLabelHock.setIcon(yellowStar);
            favHock = true;
          }
          starLabelHock.updateUI();          
      }
  });
    
    starLabelBask.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
          System.out.println("basket");
          if(favBask) {
            System.out.println("to clear from yellow");
            starLabelBask.setIcon(clearStar);
            favBask = false;
            
          } else {
            System.out.println("to yellow from clear");
            starLabelBask.setIcon(yellowStar);
            favBask = true;
          }
           starLabelBask.updateUI();          
      }
  });
    
    
    list.add(favPanel);
    list.add(footPanel);
    list.add(hockeyPanel);
    list.add(basketPanel);
    
    window.add(list, BorderLayout.WEST);
    
  }
  
  public void createCenter() {
   twitter = new twitterUISetup();
    window.add(twitter, BorderLayout.CENTER);
    
  }
 
}


