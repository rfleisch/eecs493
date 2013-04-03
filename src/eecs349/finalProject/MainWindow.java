package eecs349.finalProject;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainWindow extends JDialog
{
  
  private JFrame window;
  
  public MainWindow() {
    
    window = new JFrame("MGoSports");
    window.setLayout(new BorderLayout());
    
    createTitleNorth();
    createListWest();
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
    
    ImageIcon Mlogo = new ImageIcon("mgosportslogo.png");
    
    Image img = Mlogo.getImage();
    Image newimg = img.getScaledInstance(500, 80,  java.awt.Image.SCALE_SMOOTH);  
    ImageIcon newIcon = new ImageIcon(newimg);  
    
     
    JLabel title = new JLabel(newIcon);
    title.setBackground(Color.BLUE);
    title.setOpaque(true);
    titlePanel.add(title, BorderLayout.WEST);
    title.setPreferredSize(new Dimension( 520, 100));
    
    
    JPanel twitterPanel = new JPanel();
    twitterPanel.setPreferredSize(new Dimension(60, 100));
    twitterPanel.setBackground(Color.BLUE);
    
    ImageIcon birdIcon = new ImageIcon("twitterBlueBird.png");
    JLabel bird = new JLabel(birdIcon);
    
    JLabel login = new JLabel("Login");
    login.setForeground(Color.WHITE);
    login.setFont(new Font("Arial", Font.BOLD, 12));
    
    twitterPanel.add(bird);
    twitterPanel.add(login);
    
    titlePanel.add(twitterPanel, BorderLayout.EAST);    
    titlePanel.setAlignmentX(LEFT_ALIGNMENT);
    
    window.add(titlePanel, BorderLayout.NORTH);
    
  }
  
  private void createListWest() {
    JPanel list = new JPanel();
    list.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    list.setBackground(Color.BLUE);
    list.setOpaque(true);
    list.setPreferredSize(new Dimension(100, 90));
    list.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
    
    
    //Favorite Tab
    JPanel favPanel = new JPanel();
    favPanel.setBackground(Color.YELLOW);
    favPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    favPanel.setPreferredSize(new Dimension(100, 30));
    
    ImageIcon star = new ImageIcon("yellowStar.png");
    JLabel starLabel = new JLabel(star);
    favPanel.add(starLabel);
    
    JLabel fav = new JLabel("Favorite", JLabel.CENTER);
    fav.setHorizontalAlignment(4);
    favPanel.add(fav);
    

    //Football Tab
    JPanel footPanel = new JPanel();
    footPanel.setBackground(Color.BLUE);
    footPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    footPanel.setPreferredSize(new Dimension(100, 30));
    
    ImageIcon starFoot = new ImageIcon("clearStar.png");
    JLabel starLabelFoot = new JLabel(starFoot);
    footPanel.add(starLabelFoot);
    
    JLabel football = new JLabel("Football", JLabel.CENTER);
    football.setHorizontalAlignment(4);
    footPanel.add(football);
    
    //Hockey Tab
    JPanel hockeyPanel = new JPanel();
    hockeyPanel.setBackground(Color.BLUE);
    hockeyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    hockeyPanel.setPreferredSize(new Dimension(100,30));
    
    ImageIcon starHock = new ImageIcon("clearStar.png");
    JLabel starLabelHock = new JLabel(starHock);
    hockeyPanel.add(starLabelHock);
    
    JLabel hockey = new JLabel("Hockey", JLabel.CENTER);
    hockey.setHorizontalAlignment(4);
    hockeyPanel.add(hockey);
    
    //Basketball Tab
    JPanel basketPanel = new JPanel();
    basketPanel.setBackground(Color.BLUE);
    basketPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    basketPanel.setPreferredSize(new Dimension(100,30));
    
    ImageIcon starBask = new ImageIcon("clearStar.png");
    JLabel starLabelBask = new JLabel(starBask);
    basketPanel.add(starLabelBask);
    
    JLabel basket = new JLabel("Basketball", JLabel.CENTER);
    basket.setHorizontalAlignment(4);
    basketPanel.add(basket);
    
    
    list.add(favPanel);
    list.add(footPanel);
    list.add(hockeyPanel);
    list.add(basketPanel);
    
    window.add(list, BorderLayout.WEST);
    
  }
  
  public void createCenter() {
    twitterUISetup twitter = new twitterUISetup();
    
    window.add(twitter, BorderLayout.CENTER);
    
  }
  
  
}

