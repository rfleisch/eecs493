package eecs493.mgosports;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class basketballview extends JPanel
{
  private sportsView sv;
  private String[] columnsSche = {"Date", "Opponent", "Location", "Time/Result"};

  private Object[][] dataSche = {
      {"Tue., Nov 1", "vs. Northern Michigan ex", "Crisler Center", "W 83-47"},
      {"Mon., Nov 5", "vs Saginaw Valley State ex", "Crisler Center", "W 76-48" },
      {"Fri., Nov. 9", "vs Slippery Rock", "Crisler Center", "W 100-62"}
  };
  
  private String[] columnsRos = {"Number", "Name", "Height", "Position", "Hometown"};

  private Object[][] dataRos = {
      {"1", "Glenn Robinson III", "6-6", "Forward", "St. John, Ind."},
      {"2", "Spike Albrecht", "5-11", "Guard", "Crown Point, Ind." },
      {"3", "Trey Burke",  "6-0", "Guard", "Columbus, Ohio"}
  };
  
  public basketballview() {
    setLayout(new FlowLayout());
    setBackground(Color.YELLOW);
    sv = new sportsView("basketball");
    
    sv.scheduleTabSetup(columnsSche, dataSche);
    sv.rosterTabSetup(columnsRos, dataRos);
    sv.tweetsTabSetup();
    
    add(sv);
    
  }
}

