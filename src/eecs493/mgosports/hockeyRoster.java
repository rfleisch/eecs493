package eecs493.mgosports;

import java.util.ArrayList;

public class hockeyRoster
{
  private ArrayList<hockeyPlayer> roster;
  
  public hockeyRoster() {
    hockeyPlayer racine = new hockeyPlayer("Steve Racine", "1", "G", "08/28/1991");
    hockeyPlayer chiasson = new hockeyPlayer("Mike Chiasson", "3", "R", "03/28/1991");
    
    roster.add(racine);
    roster.add(chiasson);
  }

  public  ArrayList<hockeyPlayer> getRoster() {
    return roster;
  }

}
