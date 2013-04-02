package eecs349.finalProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class MainWindow extends JDialog
{
  
  private JFrame window;
  
  public MainWindow() {
    
    window = new JFrame("MGoSports");
    window.setLayout(new BorderLayout());
    
    createTitleNorth();
    createListWest();
    
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
    list.setLayout(new BoxLayout(list, BoxLayout.PAGE_AXIS));
    list.setSize(150, 300);
    JPanel favor = new JPanel();
    favor.setPreferredSize(new Dimension(150, 1));
   
    JLabel fav = new JLabel("Favorite", JLabel.CENTER);
    favor.setBackground(Color.YELLOW);
    favor.setOpaque(true);
    favor.add(fav);


    
    fav.setFont(new Font("Arial", 1, 14));
    //fav.setBackground(Color.YELLOW);
    //fav.setOpaque(true);

   
    JLabel football = new JLabel("Football", JLabel.CENTER);
    JLabel hockey = new JLabel("Hockey", JLabel.CENTER);
    
    list.add(favor);
    list.add(football);
    list.add(hockey);
    setSize(700,500);
    
    
    window.add(list, BorderLayout.WEST);
    
  }
  
  
  
}

