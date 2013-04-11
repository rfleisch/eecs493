package eecs493.mgosports;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class basketballview extends JPanel
{
  private sportsView sv;
  private String[] columnsSche = {"Date", "Opponent", "Location", "Time/Result"};

  private Object[][] dataSche = {
      {"Tue., Nov. 1", "vs. Northern Michigan ex", "Crisler Center", "W 83-47"},
      {"Mon., Nov. 5", "vs Saginaw Valley State ex", "Crisler Center", "W 76-48" },
      {"Fri., Nov. 9", "vs Slippery Rock", "Crisler Center", "W 100-62"},
      {"Thu., Dec. 20", "vs. Eastern Michigan", "Crisler Center", "W 93-54"},
      {"Thu., Dec. 29", "vs Central Michigan", "Crisler Center", "W 88-73" },
      {"Thu., Jan 3", "at Northwestern", "Evanston, Ill.", "W 94-66"},
      {"Sun., Jan. 6", "vs. Iowa", "Crisler Center", "W 95-67"},
      {"Wed., Jan. 9", "vs Nebraska", "Crisler Center", "W 62-47" },
      {"Sun., Jan. 13", "at Ohio State", "Columbus, Ohio", "L 56-53"},
      {"Thu., Jan. 17", "at Minnesota", "Minneapolis, Minn.", "W 83-75"},
      {"Thu., Jan. 24", "vs. Purdue", "Crisler Center", "W 68-53"},
      {"Sun., Jan. 27", "at Illinois", "Champaign, Ill.", "W 74-60" },
      {"Wed., Jan. 30", "vs. Northwesternn", "Crisler Center", "W 68-46"},
      {"Sat., Feb. 2", "at Indiana", "Bloomington, Ind.", "L 81-73"},
      {"Tue., Feb. 5", "vs. Ohio State", "Crisler Center", "W 76-74 (OT)" },
      {"Sat., Feb. 9", "at Wisconsin", "Madison, Wis.", "L 65-62(OT)"},
      {"Tue., Feb. 12", "at Michigan State", "East Lansing, Mich.", "L 75-52"},
      {"Sun., Feb. 17", "vs. Penn State", "Crisler Center", "W 79-71" },
      {"Sun., Feb. 24", "vs. Illinois", "Crisler Center", "W 71-58"},
      {"Wed., Feb. 27", "at Penn State", "State College, Pa.", "L 84-78"},
      {"Sun., Mar. 3", "vs. Michigan State", "Crisler Center", "W 58-57" },
      {"Wed., Mar. 6", "at Purdue", "West Lafayette, Ind.", "W 80-75"},  
      {"Sun., Mar. 10", "vs. Indiana", "Crisler Center", "L 72-71"},

  };
  
  private String[] columnsRos = {"Number", "Name", "Height", "Position"};

  private Object[][] dataRos = {
      {"1", "Glenn Robinson III", "6-6", "Forward"},
      {"2", "Spike Albrecht", "5-11", "Guard"},
      {"3", "Trey Burke",  "6-0", "Guard"},
      {"4", "Mitch McGary", "6-10", "Forward"},
      {"5", "Eso Akunne", "6-2", "Guard"},
      {"10", "Tim Hardaway Jr.", "6-6", "Guard"},
      {"11", "Nik Stauskas", "6-6", "Guard"},
      {"13", "Matt Vogrich", "6-4", "Guard"},
      {"15", "Jon Horford", "6-10", "Forward"},
      {"20", "Josh Bartelstein", "6-3", "Guard"},
      {"22", "Blake McLimans", "6-10", "Forward"},
      {"23", "Caris LeVert", "6-5", "Guard"},
      {"32", "Corey Person", "6-3", "Guard"},
      {"44", "Max Bielfeldt", "6-7", "Forward"},
      {"52", "Jordan Morgan", "6-8", "Forward"}
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

