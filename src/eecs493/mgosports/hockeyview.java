package eecs493.mgosports;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class hockeyview extends JPanel
{
  private sportsView sv;
  private String[] columnsSche = {"Date", "Opponent", "Location", "Time/Result"};

  private Object[][] dataSche = {
      {"Tue., Oct. 9", "vs. Windsor ex", "Yost Ice Arena", "W 7-3"},
      {"Thu., Oct 11", "vs Rochester Institute of Technology", "Yost Ice Arena", "L 5-4 (OT)" },
      {"Fri., Oct. 12", "vs Rochester Institute of Technology",  "Yost Ice Arena", "W 7-2"}
  };
  
  private String[] columnsRos = {"Number", "Name", "Pos", "DOB", "Hometown"};

  private Object[][] dataRos = {
      {"1", "Steve Racine", "G", "08/28/1991", "Williamsville, N.Y."},
      {"2", "Mike Chiasson", "D", "03/28/1991", "Henderson, Nev." },
      {"4", "Kevin Clare",  "D", "03/13/1992", "New Rochelle, N.Y."}
  };
  
  public hockeyview() {
    setLayout(new FlowLayout());
    setBackground(Color.YELLOW);
    sv = new sportsView("hockey");
    
    sv.scheduleTabSetup(columnsSche, dataSche);
    sv.rosterTabSetup(columnsRos, dataRos);
    sv.tweetsTabSetup();
    
    add(sv);
    
  }
}
