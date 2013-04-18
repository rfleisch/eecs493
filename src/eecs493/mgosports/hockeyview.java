package eecs493.mgosports;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class hockeyview extends JPanel
{
  private sportsView sv;
  private String[] columnsSche = {"Date", "Opponent", "Location", "Time/Result"};
  private hockeyRoster hRoster = new hockeyRoster();

  private Object[][] dataSche = {
      {"Tue., Oct. 9", "vs. Windsor ex", "Yost Ice Arena", "W 7-3"},
      {"Thu., Oct 11", "vs Rochester Institute of Technology", "Yost Ice Arena", "L 5-4 (OT)" },
      {"Fri., Oct. 12", "vs Rochester Institute of Technology",  "Yost Ice Arena", "W 7-2"},
      {"Fri,. Oct. 19", " vs. Bentley", "Yost Ice Arena", "W 6-3"},
      {"Fri., Oct. 26", "vs. Miami", "Yost Ice Arena", "W 4-2"},
      {"Sat., Oct. 27", "vs. Miami", "Yost Ice Arena", "L 4-3"},
      {"Fri., Nov. 2", "at Northern Michigan", "Marquette, Mich", "T 4-4 (SO-W)"},
      {"Sat., Nov. 3", "at Northern Michigan", "Marquette, Mich", "L 4-3"},
      {"Fri., Nov. 9", "vs. Michigan State", "Yost Ice Arena", "W 5-1"},
      {"Sat., Nov. 10", "at Michigan State", "East Lansing, Mich", " L 7-2"},
      {"Thu., Nov. 15", "vs. Notre Dame", "Yost Ice Arena", "L 3-1"},
      {"Fri., Nov. 16", "vs. Notre Dame", "Yost Ice Arena", "L 4-1"},
      {"Wed., Nov. 21", "vs. Bowling Green", "Yost Ice Arena", " W 3-1"},
      {"Sat., Nov. 24", "vs. Cornell", "Yost Ice Arena", "L 5-1"},
      {"Fri., Nov. 30", "at Ferris State", "Big Rapids, Mich", "L 5-0"},
      {"Sat., Dec. 1", "at Ferris State", "Big Rapids, Mich", "T 3-3 (SO-W)"},
      {"Fri., Dec. 14", "vs. Western Michigan", "Yost Ice Arena", "L 4-1"},
      {"Sat., Dec. 15", "vs. Western Michigan", "Yost Ice Arena", "W 2-0"},
      {"Sat., Dec. 29", "vs. Michigan Tech", "Yost Ice Arena", "L 4-0"},
      {"Sun., Dec. 30", "vs. Michigan Tech", "Yost Ice Arena", "W 5-2"},
      {"Fri., Jan. 4", "vs. U.S. NTDP Under-18 ex", "Yost Ice Arena", "L 5-3"},
      {"Tue., Jan. 8", "vs. Bowling Green", "Yost Ice Arena", "L 5-1"},
      {"Fri., Jan. 11", "vs. Alaska",  "Yost Ice Arena", "L 5-4"},
      {"Sat., Jan. 12", "vs. Alaska", "Yost Ice Arena", "L 4-1"},
      {"Fri., Jan. 18", "at Lake Superior State", "Sault Ste. Marie, Mich", "W 6-4"},
      {"Sat., Jan. 19", "at Lake Superior State", "Sault Ste. Marie, Mich", "L 3-2"},
      {"Fri., Jan. 25", "at Western Michigan", "Kalamazoo, Mich.", "L 3-2"},
      {"Sat., Jan. 26", "at Western Michigan", "Kalamazoo, Mich.", "L 5-1"},
      {"Fri., Feb. 1", "vs. Michigan State", "Yost Ice Arena", "W 3-2"},
      {"Fri., Feb. 2", "vs. Michigan State", "Detroit, Mich", "W 5-3"},
      {"Fri., Feb. 8", "at Notre Dame", "South Bend, Ind.", "L 7-4"},
      {"Sat., Feb. 9", "at Notre Dame", "South Bend, Ind.", "L 6-4"},
      {"Fri., Feb. 22", "at Ohio State", "Columbus, Ohio", "W 5-3"},
      {"Sat., Feb. 23", "at Ohio State", "Columbus, Ohio", "W 6-3"},
      {"Fri., Mar. 1", "vs. Ferris State", "Yost Ice Arena", "W 4-1"},
      {"Sat., Mar. 2", "vs. Ferris State", "Yost Ice Arena", "T 1-1(SO-W)"}

  };
  
  private String[] columnsRos = {"Number", "Name", "Pos"};

  private Object[][] dataRos = {
      {"1", "Steve Racine", "G"},
      {"2", "Mike Chiasson", "D" },
      {"4", "Kevin Clare",  "D"},
      {"6", "Brennan Serville", "D"},
      {"7", "Phil Di Giuseppe", "F"},
      {"8", "Jacob Truba", "D"},
      {"9", "Luke Moffatt", "F"},
      {"10", "Justin Selman", "F"},
      {"11", "Zach Hyman", "F"},
      {"12", "Cristoval 'Boo' Nieves", "F"},
      {"13", "Lee Moffie", "D"},
      {"14", "Kevin Lynch", "F"},
      {"17", "Andrew Sinelli", "F"},
      {"18", "Andrew Copp", "F"},
      {"19", "Derek DeBlois", "F"},
      {"20", "Travis Lynch", "F"},
      {"22", "Jeff Rohrkemper", "F"},
      {"23", "A.J. Treais", "F"},
      {"24", "Jon Merrill", "D"},
      {"26", "Mike Szuma", "D"},
      {"27", "Alex Guptill", "F"},
      {"28", "Jared Rutledge", "G"},
      {"29", "Luke Dwyer", "G"},
      {"30", "Adam Janecyk", "G"},
      {"37", "Mac Bennett", "D"},
      {"39", "Lindsay Sparks", "F"}
  };
  
  public hockeyview() {
    setLayout(new FlowLayout());
    setBackground(Color.YELLOW);
    sv = new sportsView("hockey", "umichhockey");
    
    sv.scheduleTabSetup(columnsSche, dataSche);
    sv.rosterTabSetup(columnsRos, dataRos);
    sv.tweetsTabSetup();
    
    add(sv);
    
  }
}
