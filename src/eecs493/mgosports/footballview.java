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
  
  private String[] columnsRos = {"Number", "Name", "Position"};

  private Object[][] dataRos = {
      {"3", "Bo Dever", "WR"},
      {"3", "Marvin Robinson", "S" },
      {"4", "Cameron Gordon",  "LB"},
      {"5", "Justice Hayes", "RB"},
      {"5", "Courtney Avery", "CB"},
      {"6", "Raymon Taylor", "DB"},
      {"6", "Brian Cleary", "QB"},
      {"7", "Ross Douglas", "DB"},
      {"8", "Russell Bellomy", "QB" },
      {"9", " Drew Dileo", "WR"},
      {"10", "Jeremy Gallon", "WR"},
      {"12", "Allen Gant", "DB"},
      {"12", "Devin Gardner", "QB"},
      {"13", "Alex Swieca", "QB"},
      {"13", "Terry Richardson", "DB"},
      {"14", "Josh Furman", "S"},
      {"15", "James Ross III", "LB"},
      {"15", "Shaun Austin", "QB"},
      {"17", "Jeremy Jackson", "WR"},
      {"18", "Blake Countess", "DB"},
      {"19", "Devin Funchess", "TE"},
      {"22", "Harrod Wilson", "S"},
      {"24", "Delonte Hollowell", "DB"},
      {"25", "Dymonte Thomas", "DB"},
      {"26", "Dennis Norfleet", "RB"},
      {"27", "Mike Jones", "LB"},
      {"27", "Jonathan Keizer", "WR"},
      {"28", "Fitzgerald Toussaint", "RB"},
      {"29", "Drake Johnson", "RB"},
      {"30", "Thomas Gordon", "S"},
      {"33", "Taco Charlton", "DE"},
      {"34", "Jeremy Clark", "DB"},
      {"34", "Brendan Gibbions", "PK"},
      {"35", "Joe Bolden", "LB"},
      {"36", "Joe Kerridge", "FB"},
      {"36", "AJ Pearson", "DB"},
      {"38", "Thomas Rawls", "RB"},
      {"29", "Sione Houma", "FB"},
      {"40", "Antonio Poole", "LB"},
      {"42", "Dylan Esterline", "TE"},
      {"43", "Will Hagerup", "P"},
      {"43", "Chris Wormley", "DL"},
      {"45", "Matt Wile", "PK"},
      {"45", "Clark Grace", "TE"},
      {"47", "Jake Ryan", "LB"},
      {"48", "Desmond Morgan", "LB"},
      {"49", "Brad Anlauf", "WR"},
      {"49", "Kaleb Ringer", "LB"},
      {"50", "Tom Strobel", "DE"},
      {"51", "Bobby Henderson", "RB"},
      {"52", "Royce Jenkins-Stone", "LB"},
      {"53", "Mario Ojemudia", "DE"},
      {"54", "Jareth Glanda", "LS"},
      {"54", "Richard Ash", "DT"},
      {"55", "Jibreel Black", "DT"},
      {"56", "Ondre Pipkins", "DT"},
      {"56", "Joey Burzynski", "OL"},
      {"57", " Frank Clark", "DE"},
      {"58", "Chris Bryant", "OL"},
      {"59", "Mark Lawson", "LB"},
      {"60", "Jack Miller", "OL"},
      {"61", "Graham Glasgow", "OL"},
      {"62", "Blake Bars", "OL"},
      {"63", "Ben Pliska", "OL"},
      {"65", "Kyle Bosch", "OL"},
      {"66", "Dan Liesman", "LB"},
      {"67", "Kyle Kalis", "OL"},
      {"69", "Erik Gunderson", "OL"},
      {"69", "Willie Henry", "DT"},
      {"70", "Kristian Mateus", "OL"},
      {"71", "Ben Braden", "OL"},
      {"72", "Logan Tuley-Tillman", "OL"},
      {"75", "Michael Schofield", "OL"},
      {"76", "Quinton Washington", "DT"},
      {"77", "Taylor Lewan", "OL"},
      {"78", "Erik Magnuson", "OL"},
      {"79", "Dan Gibbs", "OL"},
      {"82", "Amara Darboh", "WR"},
      {"84", "A.J. Williams", "TE"},
      {"85", "Joe Reynolds", "WR"},
      {"86", "Jehu Chesson", "WR"},
      {"88", "Jake Butt", "TE"},
      {"91", "Alex Mitropoulous-Rundus", "TE"},
      {"91", "Kenneth Allen", "K/P"},
      {"92", "Keith Heitzman", "DE"},
      {"94", "Jordan Paskorz", "TE"},
      {"95", "Anthony Capatina", "DB"},
      {"95", "Michael Jocz", "TE"},
      {"96", "Ryan Glasgow", "DL"},
      {"97", "Breenen Beyer", "DE"},
      {"99", "Matthew Godin", "DE"}
      
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