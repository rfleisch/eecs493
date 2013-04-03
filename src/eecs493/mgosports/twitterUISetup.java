package eecs493.mgosports;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class twitterUISetup extends JPanel
{
  //private JFrame window;

  public twitterUISetup() {
    
    //set the layout of the main area
    setLayout(new BorderLayout(10,10));
    setBackground(Color.YELLOW);
    
    JPanel textPanel = new JPanel();
    textPanel.setBackground(Color.YELLOW);
    textPanel.setOpaque(true);
    textPanel.setPreferredSize(new Dimension(400, 50));
    
    JTextField text = new JTextField(40);
    //text.setPreferredSize(new Dimension(40, 10))''
    JLabel tweetLabel = new JLabel("Tweet");
    textPanel.add(tweetLabel);
    textPanel.add(text);
    
    JPanel btnPanel = new JPanel();
    btnPanel.setBackground(Color.YELLOW);
    btnPanel.setOpaque(true);
    btnPanel.setPreferredSize(new Dimension(80, 80));
    
    JButton btn = new JButton("Tweet");
    btn.setPreferredSize(new Dimension(70,20));
    btnPanel.add(btn);
    
    
    add(textPanel, BorderLayout.NORTH);
    add(btnPanel, BorderLayout.EAST);    
    //pack();
    setVisible(true);
    
   
  };
  
  
  
  
  
  

}
