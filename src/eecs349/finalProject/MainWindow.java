package eecs349.finalProject;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
    JLabel title = new JLabel("MGoSports", JLabel.CENTER);
    title.setBackground(Color.BLUE);
    title.setOpaque(true);
    title.setFont(new Font("Impact", 1, 32));

    
    
    title.setAlignmentY(CENTER_ALIGNMENT);
    
    window.add(title, BorderLayout.NORTH);
    
  }
  
  private void createListWest() {
    JPanel list = new JPanel();
    list.setBackground(Color.BLUE);
    list.setOpaque(true);
    list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
    //list.setSize(150, 300);
    JPanel favorPanel = new JPanel();
    //Image star = ((ImageIcon)ImageStore.applet_loadedImages.get("yellowStar.png")).getImage();
    
     //resizeImage(star,10,10);
    ImageIcon star = new ImageIcon("smallStarYellow.png");
    JPanel spacePan = new JPanel();
    
    JLabel starLabel = new JLabel(star);
    //starLabel.setPreferredSize(new Dimension(10, 10));
   
   
    JLabel fav = new JLabel("Favorite", JLabel.CENTER);
    fav.setFont(new Font("Arial", 1, 14));
    fav.setHorizontalAlignment(4);

    
    favorPanel.setLayout(new GridBagLayout());
    //favorPanel.setPreferredSize(new Dimension(150, 1));
    favorPanel.setBackground(Color.YELLOW);
    favorPanel.setOpaque(true);
    favorPanel.add(starLabel);
    favorPanel.add(fav);

   
    JLabel football = new JLabel("Football", JLabel.CENTER);
    football.setHorizontalAlignment(4);
    JLabel hockey = new JLabel("Hockey", JLabel.CENTER);
    hockey.setHorizontalAlignment(4);
    
    list.add(favorPanel);
    list.add(football);
    list.add(hockey);
    
    window.add(list, BorderLayout.WEST);
    
  }
  
  public void createCenter() {
    twitterUISetup twitter = new twitterUISetup();
    
    window.add(twitter, BorderLayout.CENTER);
    
  }
  
  
}

