package eecs493.mgosports;

import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.*;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.List;


public class twitterUISetup extends JPanel
{
	private final static String consumerKey = "S9qyKL0weuc9S65CME2dNA";
	private final static String consumerSecret = "9QSTAcdzWYhN5dh7nknrIpPuSX7HU9RPcpoHH9pBhZE";
		
	public static Configuration config = null;
	private static Properties prop = new Properties();
    
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
                
                String at = prop.getProperty("oauth.accessToken");
                String ats = prop.getProperty("oauth.accessTokenSecret");
                if (!(null ==  at|| null == ats))
                {
                    config = new ConfigurationBuilder()
                        .setOAuthConsumerKey(consumerKey)
                        .setOAuthConsumerSecret(consumerSecret)
                        .setOAuthAccessToken(at)
                        .setOAuthAccessTokenSecret(ats)
                        .setDebugEnabled(true)
                        .build();
                }
            }
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            showErrorMessage("An error occurred loading twitter properties: " + ioe.getMessage());
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
        if (config == null)
            loadProperties();
        
        return config != null;
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
            showErrorMessage("An error occured getting the consumer keys: " + ioe.getMessage());
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
                catch (IOException ignore) { }
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
  
            while (null == accessToken)
            {
                try
                {
                    Desktop.getDesktop().browse(new URI(requestToken.getAuthorizationURL()));
                }
                catch (Exception e)
                {
                    System.out.println("An error occurred launching the browser." + 
                            "Please ppen the following URL and grant access to your account:" +
                            requestToken.getAuthorizationURL());
                }
                String pin = getInput("Grant access to your Twitter account and enter the PIN:");
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
                        showErrorMessage("Unable to get the access token.");
                    }
                    else
                    {
                        te.printStackTrace();
                        showErrorMessage("An error occured getting twitter access tokens: " + te.getMessage());
                    }
                    return false;
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
                
                if (!(null ==  accessToken.getToken() || null == accessToken.getTokenSecret()))
                {
                    config = new ConfigurationBuilder()
                        .setOAuthConsumerKey(consumerKey)
                        .setOAuthConsumerSecret(consumerSecret)
                        .setOAuthAccessToken(accessToken.getToken())
                        .setOAuthAccessTokenSecret(accessToken.getTokenSecret())
                        .setDebugEnabled(true)
                        .build();
                }
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
            return true;
        }
        catch (TwitterException te)
        {
            te.printStackTrace();
            showErrorMessage("Failed to get accessToken: " + te.getMessage());
            return false;
        }
    }

    public static Twitter getTwitter()
    {
        new TwitterFactory(config);
        return TwitterFactory.getSingleton();
    }
    
    // returns true if the tweet was successfully sent
    public static boolean tweet(String text)
    {
        if (!isAuthorized())
            return false;
        
        text = text.trim();
        String mGoSports = " #MGoSports";
        String mgs = " #MGS";
        
        if (text.length() + mGoSports.length() <= 140)
            text = text + mGoSports;
        else if (text.length() + mgs.length() <= 140)
            text = text + mgs;
        else if (text.length() > 140)
        {
            showErrorMessage("Tweet exceeds maximum length of 140 characters.");
            return false;
        }
        
        try
        {
            Status status = getTwitter().updateStatus(text);
            
            System.out.println("Status updated to: '" + status.getText() + "'");
            
            return true;
        }
        catch (TwitterException te)
        {
            te.printStackTrace();
            showErrorMessage("An error occurred sending the tweet: " + te.getMessage());
            return false;
        }
    }
    
    public static User getUser(String user)
    {
        if (!isAuthorized())
            return null;
        
        try
        {
            return getTwitter().showUser(user);            
        }
        catch (TwitterException te)
        {
            if (34 == te.getErrorCode())
            {
                System.out.println("User not found");
                return null;
            }
            te.printStackTrace();
            showErrorMessage("Failed to get user: " + te.getMessage());
            return null;
        }
    }
    
    public static boolean isFollowingUser(String user)
    {
        if (!isAuthorized())
            return false;
        
        try
        {
            Twitter twitter = getTwitter();
            return twitter.showFriendship(twitter.getId(),
                    twitter.showUser(user).getId()).isSourceFollowingTarget();
        }
        catch (TwitterException te)
        {
            te.printStackTrace();
            showErrorMessage("Error getting friendship status: " + te.getMessage());
            return false;
        }
    }
    
    public static boolean followUser(String user)
    {
        if (!isAuthorized())
            return false;
        
        try
        {
            User following = getTwitter().createFriendship(user);
            
            return following.getStatusesCount() != 0;
        }
        catch (TwitterException te)
        {
            te.printStackTrace();
            showErrorMessage("Failed to follow user: " + te.getMessage());
            return false;
        }
    }
    
    public static void showErrorMessage(String text, String title)
    {
        JOptionPane.showMessageDialog(null, text, title, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void showErrorMessage(String text)
    {
        JOptionPane.showMessageDialog(null, text, "Twitter error", JOptionPane.ERROR_MESSAGE);
    }
    
    private static String getInput(String prompt)
    {
        return JOptionPane.showInputDialog(prompt);
    }
    
    public static String getScreenName()
    {
    	String name = "";
    	if (isAuthorized())
    	{
    		try
	    	{
	    		name = getTwitter().getScreenName();
	    	}
	    	catch (TwitterException e)
	    	{
	    		e.getStackTrace();
	    	}
    	}
    	return name;
    }
}
