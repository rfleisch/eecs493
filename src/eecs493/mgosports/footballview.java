package eecs493.mgosports;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class footballview extends JPanel
{
  private sportsView sv;
  private String[] columnsSche = {"Date", "Opponent", "Location", "Time/Result"};

  private Object[][] dataSche = {
      {"Sat., Aug. 31", "vs. Central Michigan", "Michigan Stadium", "TBA"},
      {"Sat., Sept. 7", "vs Notre Dame", "Michigan Stadium", "TBA" },
      {"Sat., Sept. 14", "vs Akron", "Michigan Stadium", "TBA"},
      {"Sat., Sept. 21", "at Connecticut", "East Hartford, Conn.", "TBA"},
      {"Sat., Oct. 5", "vs Minnesota", "Michigan Stadium", "TBA" },
      {"Sat., Oct. 12", "at Penn State", "State College, Pa.", "TBA"},
      {"Sat., Oct. 19", "vs. Indiana", "Michigan Stadium", "TBA"},
      {"Sat., Nov. 2", "at Michigan State", "East Lansing, Mich.", "TBA" },
      {"Sat., Nov. 9", "vs Nebraska", "Michigan Stadium", "TBA"},
      {"Sat., Nov. 16", "at Northwestern", "Evanston, Ill.", "TBA"},
      {"Sat., Nov. 23", "at Iowa", "Iowa City, Iowa", "TBA" },
      {"Sat., Nov. 30", "vs Ohio State", "Michigan Stadium", "TBA"}
  };
  
  private String[] columnsRos = {"Number", "Name", "Position", "Hometown"};

  private Object[][] dataRos = {
      {"3", "Bo Dever", "WR", "Lake Forest, Ill."},
      {"3", "Marvin Robinson", "S", "Winter Haven, Fla." },
      {"4", "Cameron Gordon",  "LB", "Detroit, Mich."}
  };
  
  public footballview() {
    setLayout(new FlowLayout());
    setBackground(Color.YELLOW);
    sv = new sportsView("football");
    
    sv.scheduleTabSetup(columnsSche, dataSche);
    sv.rosterTabSetup(columnsRos, dataRos);
    sv.tweetsTabSetup();
    
    add(sv);
    
  }
}