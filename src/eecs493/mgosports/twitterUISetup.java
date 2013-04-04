package eecs493.mgosports;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

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
	private final static String consumerKey = "S9qyKL0weuc9S65CME2dNA";
	private final static String consumerSecret = "9QSTAcdzWYhN5dh7nknrIpPuSX7HU9RPcpoHH9pBhZE";
	
	private static Properties prop = new Properties();

    public twitterUISetup()
    {
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

        //authorize();
        //tweet("This is another test tweet sent from the #MGoSports app developed by @BrianRoskamp, @rfleischCity, @k_seks, and @mmmmpizzza for @umich.");
    };
    
    private static void loadProperties()
    {
        File propFile = new File("twitter4j.properties");
        InputStream is = null;
        try
        {
            if (propFile.exists())
            {
                is = new FileInputStream(propFile);
                prop.load(is);
            }
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            System.exit(-1);
        }
        finally
        {
            if (is != null)
            {
                try
                {
                    is.close();
                }
                catch (IOException ignore)
                {
                }
            }
        }
    }
  
    // returns true if authorized to use twitter
    public static boolean isAuthorized()
    {
        loadProperties();
        return !(null == prop.getProperty("oauth.accessToken") ||
            null == prop.getProperty("oauth.accessTokenSecret"));
    }
  
    // Adapted from Twitter4J examples
    // returns true if authorization was successful
    public static boolean authorize()
    {
        if (isAuthorized())
            return true;
        
        File file = new File("twitter4j.properties");
        OutputStream os = null;
        try
        {
            String consumerKeyProp = prop.getProperty("oauth.consumerKey");
            String consumerSecretProp = prop.getProperty("oauth.consumerSecret");
            
            if (null == prop.getProperty("oauth.consumerKey") ||
                null == prop.getProperty("oauth.consumerSecret"))
            {
                prop.setProperty("oauth.consumerKey", consumerKey);
                prop.setProperty("oauth.consumerSecret", consumerSecret);
                os = new FileOutputStream("twitter4j.properties");
                prop.store(os, "twitter4j.properties");
            }
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            System.exit(-1);
        }
        finally
        {
            if (os != null)
            {
                try
                {
                    os.close();
                }
                catch (IOException ignore)
                {
                }
            }
        }
        
        try
        {
            Twitter twitter = new TwitterFactory().getInstance();
            RequestToken requestToken = twitter.getOAuthRequestToken();
            System.out.println("Got request token.");
            System.out.println("Request token: " + requestToken.getToken());
            System.out.println("Request token secret: " + requestToken.getTokenSecret());
            AccessToken accessToken = null;
  
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (null == accessToken)
            {
                System.out.println("Open the following URL and grant access to your account:");
                System.out.println(requestToken.getAuthorizationURL());
                try
                {
                    Desktop.getDesktop().browse(new URI(requestToken.getAuthorizationURL()));
                }
                catch (UnsupportedOperationException ignore)
                {
                }
                catch (IOException ignore)
                {
                }
                catch (URISyntaxException e)
                {
                    throw new AssertionError(e);
                }
                System.out.print("Enter the PIN(if available) and hit enter after you granted access.[PIN]:");
                String pin = br.readLine();
                try
                {
                    if (pin.length() > 0)
                    {
                        accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                    }
                    else
                    {
                        accessToken = twitter.getOAuthAccessToken(requestToken);
                    }
                }
                catch (TwitterException te)
                {
                    if (401 == te.getStatusCode())
                    {
                        System.out.println("Unable to get the access token.");
                    }
                    else
                    {
                        te.printStackTrace();
                    }
                }
            }
            System.out.println("Got access token.");
            System.out.println("Access token: " + accessToken.getToken());
            System.out.println("Access token secret: " + accessToken.getTokenSecret());
  
            try
            {
                prop.setProperty("oauth.accessToken", accessToken.getToken());
                prop.setProperty("oauth.accessTokenSecret", accessToken.getTokenSecret());
                os = new FileOutputStream(file);
                prop.store(os, "twitter4j.properties");
                os.close();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                return false;
            }
            finally
            {
                if (os != null)
                {
                    try
                    {
                        os.close();
                    }
                    catch (IOException ignore)
                    {
                    }
                }
            }
            System.out.println("Successfully stored access token to " + file.getAbsolutePath() + ".");
        }
        catch (TwitterException te)
        {
            te.printStackTrace();
            System.out.println("Failed to get accessToken: " + te.getMessage());
            return false;
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            System.out.println("Failed to read the system input.");
            return false;
        }
        return true;
    }

    // returns true if the tweet was successfully sent
    public static boolean tweet(String text)
    {
        if (!isAuthorized())
        {
            // Not authorized -> unable to send tweet
            return false;
        }
        
        if (text.length() > 140)
        {
            System.out.println("Tweet exceeds max. length of 140 characters.");
            return false;
        }
        
        try
        {
            Twitter twitter = new TwitterFactory().getInstance();
            Status status = twitter.updateStatus(text);
            
            System.out.println("Status updated to: '" + status.getText() + "'");
            
            return true;
        }
        catch (TwitterException te)
        {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            return false;
        }
    }
}
