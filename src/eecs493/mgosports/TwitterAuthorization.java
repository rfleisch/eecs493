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
        
        final boolean isAuthorized = twitterUISetup.isAuthorized();
        final ImageIcon blueBird = new ImageIcon("img/twitterBlueBird_48.png");
        final ImageIcon grayBird = new ImageIcon("img/twitterGrayBird_48.png");
        final JLabel bird = new JLabel(isAuthorized ? blueBird : grayBird);
        
        final JLabel login = new JLabel(isAuthorized ? "Logged in" : "Login");
        login.setForeground(isAuthorized ? Color.GRAY : Color.WHITE);
        login.setFont(new Font("Arial", Font.BOLD, 12));
        
        panel.add(bird);
        panel.add(login);        
        
        panel.addMouseListener(
            new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    if (!isAuthorized)
                    {
                        JOptionPane.showMessageDialog(null,
                                "Click OK to continue to a web browser to authorize Twitter",
                                "Warning",
                                JOptionPane.OK_CANCEL_OPTION);
                        
                        boolean success = twitterUISetup.authorize();
                        
                        bird.setIcon(success ? blueBird : grayBird);
                        
                        login.setText(success ? "Logged in" : "Login");
                        login.setForeground(success ? Color.GRAY : Color.WHITE);
                        login.setFont(new Font("Arial", Font.BOLD, 12));
                    }
                }
            }
        );
        
        return panel;
    }
}
