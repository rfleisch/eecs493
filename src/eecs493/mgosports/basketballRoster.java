package eecs493.mgosports;

import java.util.ArrayList;

public class basketballRoster
{
  
  private ArrayList<basketballPlayerPic> roster =  new ArrayList<basketballPlayerPic>();
  
  public basketballRoster() {
    
    basketballPlayerPic glenn = new basketballPlayerPic("img/glenn.jpeg", "1", "Glenn Robinson III", "6-6", "Forward");
    basketballPlayerPic spike = new basketballPlayerPic("img/spike.jpeg","2", "Spike Albrecht", "5-11", "Guard");
    basketballPlayerPic trey = new basketballPlayerPic("img/trey.jpeg","3", "Trey Burke",  "6-0", "Guard");
    basketballPlayerPic mitch = new basketballPlayerPic("img/mitch.jpeg","4", "Mitch McGary", "6-10", "Forward", "MitchMcGary4");
    basketballPlayerPic eso = new basketballPlayerPic("img/eso.jpeg","5", "Eso Akunne", "6-2", "Guard");
    basketballPlayerPic timmy = new basketballPlayerPic("img/timmy.jpeg","10", "Tim Hardaway Jr.", "6-6", "Guard");
    basketballPlayerPic nik = new basketballPlayerPic("img/nik.jpeg","11", "Nik Stauskas", "6-6", "Guard", "NStauskas11");
    basketballPlayerPic mattV = new basketballPlayerPic("img/mattV.jpeg","13", "Matt Vogrich", "6-4", "Guard");
    basketballPlayerPic jonH = new basketballPlayerPic("img/jonH.jpeg","15", "Jon Horford", "6-10", "Forward");
    basketballPlayerPic JoshB = new basketballPlayerPic("img/JoshB.jpeg","20", "Josh Bartelstein", "6-3", "Guard");
    basketballPlayerPic blakeMc = new basketballPlayerPic("img/blakeMc.jpeg","22", "Blake McLimans", "6-10", "Forward", "BlakeMc22");
    basketballPlayerPic caris = new basketballPlayerPic("img/caris.jpeg","23", "Caris LeVert", "6-5", "Guard");
    basketballPlayerPic corey = new basketballPlayerPic("img/corey.jpeg","32", "Corey Person", "6-3", "Guard");
    basketballPlayerPic max = new basketballPlayerPic("img/maxB.jpeg","44", "Max Bielfeldt", "6-7", "Forward");
    basketballPlayerPic jmo = new basketballPlayerPic("img/jmo.jpeg","52", "Jordan Morgan", "6-8", "Forward");
    
    roster.add(glenn);
    roster.add(spike);
    roster.add(trey);
    roster.add(mitch);
    roster.add(eso);
    roster.add(timmy);
    roster.add(nik);
    roster.add(mattV);
    roster.add(jonH);
    roster.add(JoshB);
    roster.add(blakeMc);
    roster.add(caris);
    roster.add(corey);
    roster.add(max);
    roster.add(jmo);
    
    
  }
  
  public  ArrayList<basketballPlayerPic> getRoster() { 
    return roster;
  }

}
