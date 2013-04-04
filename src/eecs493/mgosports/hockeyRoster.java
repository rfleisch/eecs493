package eecs493.mgosports;

import java.util.ArrayList;

public class hockeyRoster
{
  private ArrayList<hockeyPlayerPic> roster = new ArrayList<hockeyPlayerPic>();
  
  public hockeyRoster() {
    hockeyPlayerPic racine = new hockeyPlayerPic("steveRacine.jpeg");
    hockeyPlayerPic chiasson = new hockeyPlayerPic( "chiasson.jpeg");
    
    roster.add(racine);
    roster.add(chiasson);
  }

  public  ArrayList<hockeyPlayerPic> getRoster() {
    return roster;
  }

}
