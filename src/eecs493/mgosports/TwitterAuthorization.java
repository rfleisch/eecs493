package eecs493.mgosports;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TwitterAuthorization
{
    public static JPanel GetPanel()
    {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(60, 100));
        panel.setBackground(Color.BLUE);
        
        ImageIcon birdIcon = new ImageIcon(twitterUISetup.isAuthorized() ?
                "img/twitterBlueBird_48.png" : "img/twitterGrayBird_48.png");
        JLabel bird = new JLabel(birdIcon);
        
        JLabel login = new JLabel("Login");
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Arial", Font.BOLD, 12));
        login.setVisible(!twitterUISetup.isAuthorized());
        
        panel.add(bird);
        panel.add(login);        
        
        panel.addMouseListener(
            new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    JOptionPane.showMessageDialog(null, "Click OK to continue to a web browser to authorize Twitter", "Warning",
                            JOptionPane.OK_CANCEL_OPTION);
    
                    twitterUISetup.authorize();
                }
            }
        );
        
        return panel;
    }
}
