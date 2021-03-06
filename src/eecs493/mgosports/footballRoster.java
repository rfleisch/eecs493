package eecs493.mgosports;

import java.util.ArrayList;

public class footballRoster
{
  private ArrayList<footballPlayerPic> roster =  new ArrayList<footballPlayerPic>();
  
  public footballRoster() { 
    
    footballPlayerPic bo = new footballPlayerPic("img/bo.jpeg", "3", "Bo Dever", "WR"); 
    roster.add(bo);
    footballPlayerPic marvin = new footballPlayerPic ("img/marvin.jpeg", "3", "Marvin Robinson", "S" );
    roster.add(marvin);
    footballPlayerPic cam = new footballPlayerPic ("img/cam.jpeg", "4", "Cameron Gordon",  "LB"); 
    roster.add(cam);
    footballPlayerPic just = new footballPlayerPic ("img/just.jpeg", "5", "Justice Hayes", "RB"); 
    roster.add(just);
    footballPlayerPic court = new footballPlayerPic ("img/court.jpeg", "5", "Courtney Avery", "CB"); 
    roster.add(court);
    footballPlayerPic raymon = new footballPlayerPic ("img/raymon.jpeg", "6", "Raymon Taylor", "DB"); 
    roster.add(raymon);
    footballPlayerPic brian = new footballPlayerPic ("img/brian.jpeg", "6", "Brian Cleary", "QB"); 
    roster.add(brian);
    footballPlayerPic ross = new footballPlayerPic ("img/ross.jpeg", "7", "Ross Douglas", "DB"); 
    roster.add(ross);
    footballPlayerPic russell = new footballPlayerPic ("img/russell.jpeg", "8", "Russell Bellomy", "QB" );
    roster.add(russell);
    footballPlayerPic drew = new footballPlayerPic ("img/drew.jpeg", "9", " Drew Dileo", "WR"); 
    roster.add(drew);
    footballPlayerPic jer = new footballPlayerPic ("img/jer.jpeg", "10", "Jeremy Gallon", "WR"); 
    roster.add(jer);
    footballPlayerPic allen = new footballPlayerPic ("img/allen.jpeg", "12", "Allen Gant", "DB"); 
    roster.add(allen);
    footballPlayerPic devin = new footballPlayerPic ("img/devin.jpeg", "12", "Devin Gardner", "QB", "dg1two"); 
    roster.add(devin);
    footballPlayerPic alex = new footballPlayerPic ("img/alex.jpeg", "13", "Alex Swieca", "QB"); 
    roster.add(alex);
    footballPlayerPic terry = new footballPlayerPic ("img/terry.jpeg", "13", "Terry Richardson", "DB"); 
    roster.add(terry);
    footballPlayerPic josh = new footballPlayerPic ("img/josh.jpeg", "14", "Josh Furman", "S"); 
    roster.add(josh);
    footballPlayerPic james = new footballPlayerPic ("img/james.jpeg", "15", "James Ross III", "LB"); 
    roster.add(james);
    footballPlayerPic shaun = new footballPlayerPic ("img/shaun.jpeg", "15", "Shaun Austin", "QB"); 
    roster.add(shaun);
    footballPlayerPic jeremy = new footballPlayerPic ("img/jeremy.jpeg", "17", "Jeremy Jackson", "WR"); 
    roster.add(jeremy);
    footballPlayerPic blake = new footballPlayerPic ("img/blake.jpeg", "18", "Blake Countess", "DB"); 
    roster.add(blake);
    footballPlayerPic devinF = new footballPlayerPic ("img/devinF.jpeg", "19", "Devin Funchess", "TE"); 
    roster.add(devinF);
    footballPlayerPic jarrod = new footballPlayerPic ("img/Jarrod.jpeg", "22", "Jarrod Wilson", "S"); 
    roster.add(jarrod);
    footballPlayerPic del = new footballPlayerPic ("img/del.jpeg", "24", "Delonte Hollowell", "DB"); 
    roster.add(del);
    footballPlayerPic dym = new footballPlayerPic ("img/dym.jpeg", "25", "Dymonte Thomas", "DB"); 
    roster.add(dym);
    footballPlayerPic dennis = new footballPlayerPic ("img/dennis.jpeg", "26", "Dennis Norfleet", "RB"); 
    roster.add(dennis);
    footballPlayerPic mike = new footballPlayerPic ("img/mike.jpeg", "27", "Mike Jones", "LB"); 
    roster.add(mike);
    footballPlayerPic jonK = new footballPlayerPic ("img/jonK.jpeg", "27", "Jonathan Keizer", "WR"); 
    roster.add(jonK);
    footballPlayerPic fitz = new footballPlayerPic ("img/fitz.jpeg", "28", "Fitzgerald Toussaint", "RB"); 
    roster.add(fitz);
    footballPlayerPic drake = new footballPlayerPic ("img/drake.jpeg", "29", "Drake Johnson", "RB"); 
    roster.add(drake);
    footballPlayerPic thomas = new footballPlayerPic ("img/thomas.jpeg", "30", "Thomas Gordon", "S"); 
    roster.add(thomas);
    footballPlayerPic taco = new footballPlayerPic ("img/taco.jpeg", "33", "Taco Charlton", "DE"); 
    roster.add(taco);
    footballPlayerPic jerC = new footballPlayerPic ("img/jerC.jpeg", "34", "Jeremy Clark", "DB"); 
    roster.add(jerC);
    footballPlayerPic brendan = new footballPlayerPic ("img/brendan.jpeg", "34", "Brendan Gibbions", "PK"); 
    roster.add(brendan);
    footballPlayerPic joeB = new footballPlayerPic ("img/joeB.jpeg", "35", "Joe Bolden", "LB"); 
    roster.add(joeB);
    footballPlayerPic joeK = new footballPlayerPic ("img/joeK.jpeg", "36", "Joe Kerridge", "FB"); 
    roster.add(joeK);
    footballPlayerPic ajP = new footballPlayerPic ("img/ajP.jpeg", "36", "AJ Pearson", "DB"); 
    roster.add(ajP);
    footballPlayerPic thomasR = new footballPlayerPic ("img/thomasR.jpeg", "38", "Thomas Rawls", "RB"); 
    roster.add(thomasR);
    footballPlayerPic sione = new footballPlayerPic ("img/sione.jpeg", "29", "Sione Houma", "FB"); 
    roster.add(sione);
    footballPlayerPic tony = new footballPlayerPic ("img/tony.jpeg", "40", "Antonio Poole", "LB"); 
    roster.add(tony);
    footballPlayerPic dylan = new footballPlayerPic ("img/dylan.jpeg", "42", "Dylan Esterline", "TE"); 
    roster.add(dylan);
    footballPlayerPic will = new footballPlayerPic ("img/will.jpeg", "43", "Will Hagerup", "P"); 
    roster.add(will);
    footballPlayerPic chrisW = new footballPlayerPic ("img/chrisW.jpeg", "43", "Chris Wormley", "DL"); 
    roster.add(chrisW);
    footballPlayerPic mattW = new footballPlayerPic ("img/mattW.jpeg", "45", "Matt Wile", "PK"); 
    roster.add(mattW);
    footballPlayerPic clark = new footballPlayerPic ("img/clark.jpeg", "45", "Clark Grace", "TE"); 
    roster.add(clark);
    footballPlayerPic jakeR = new footballPlayerPic ("img/jakeR.jpeg", "47", "Jake Ryan", "LB"); 
    roster.add(jakeR);
    footballPlayerPic desmond = new footballPlayerPic ("img/desmond.jpeg", "48", "Desmond Morgan", "LB"); 
    roster.add(desmond);
    footballPlayerPic brad = new footballPlayerPic ("img/brad.jpeg", "49", "Brad Anlauf", "WR"); 
    roster.add(brad);
    footballPlayerPic kaleb = new footballPlayerPic ("img/kaleb.jpeg", "49", "Kaleb Ringer", "LB"); 
    roster.add(kaleb);
    footballPlayerPic tomS = new footballPlayerPic ("img/tomS.jpeg", "50", "Tom Strobel", "DE"); 
    roster.add(tomS);
    footballPlayerPic bobby = new footballPlayerPic ("img/bobby.jpeg", "51", "Bobby Henderson", "RB"); 
    roster.add(bobby);
    footballPlayerPic royce = new footballPlayerPic ("img/royce.jpeg", "52", "Royce Jenkins-Stone", "LB"); 
    roster.add(royce);
    footballPlayerPic mario = new footballPlayerPic ("img/mario.jpeg", "53", "Mario Ojemudia", "DE"); 
    roster.add(mario);
    footballPlayerPic jare = new footballPlayerPic ("img/jare.jpeg", "54", "Jareth Glanda", "LS"); 
    roster.add(jare);
    footballPlayerPic richard = new footballPlayerPic ("img/richard.jpeg", "54", "Richard Ash", "DT"); 
    roster.add(richard);
    footballPlayerPic jib = new footballPlayerPic ("img/jib.jpeg", "55", "Jibreel Black", "DT"); 
    roster.add(jib);
    footballPlayerPic ondre = new footballPlayerPic ("img/ondre.jpeg", "56", "Ondre Pipkins", "DT"); 
    roster.add(ondre);
    footballPlayerPic joey = new footballPlayerPic ("img/joey.jpeg", "56", "Joey Burzynski", "OL"); 
    roster.add(joey);
    footballPlayerPic frankC = new footballPlayerPic ("img/frankC.jpeg", "57", " Frank Clark", "DE"); 
    roster.add(frankC);
    footballPlayerPic chrisBr = new footballPlayerPic ("img/chrisBr.jpeg", "58", "Chris Bryant", "OL"); 
    roster.add(chrisBr);
    footballPlayerPic mark = new footballPlayerPic ("img/mark.jpeg", "59", "Mark Lawson", "LB"); 
    roster.add(mark);
    footballPlayerPic jack = new footballPlayerPic ("img/jack.jpeg", "60", "Jack Miller", "OL"); 
    roster.add(jack);
    footballPlayerPic gram = new footballPlayerPic ("img/gram.jpeg", "61", "Graham Glasgow", "OL"); 
    roster.add(gram);
    footballPlayerPic blakeB = new footballPlayerPic ("img/blakeB.jpeg", "62", "Blake Bars", "OL"); 
    roster.add(blakeB);
    footballPlayerPic benP = new footballPlayerPic ("img/benP.jpeg", "63", "Ben Pliska", "OL"); 
    roster.add(benP);
    footballPlayerPic kyleB = new footballPlayerPic ("img/kyleB.jpeg", "65", "Kyle Bosch", "OL"); 
    roster.add(kyleB);
    footballPlayerPic danL = new footballPlayerPic ("img/danL.jpeg", "66", "Dan Liesman", "LB"); 
    roster.add(danL);
    footballPlayerPic kyle = new footballPlayerPic ("img/kyle.jpeg", "67", "Kyle Kalis", "OL"); 
    roster.add(kyle);
    footballPlayerPic erikG = new footballPlayerPic ("img/erikG.jpeg", "69", "Erik Gunderson", "OL"); 
    roster.add(erikG);
    footballPlayerPic willie = new footballPlayerPic ("img/willie.jpeg", "69", "Willie Henry", "DT"); 
    roster.add(willie);
    footballPlayerPic kris = new footballPlayerPic ("img/kris.jpeg", "70", "Kristian Mateus", "OL"); 
    roster.add(kris);
    footballPlayerPic ben = new footballPlayerPic ("img/ben.jpeg", "71", "Ben Braden", "OL"); 
    roster.add(ben);
    footballPlayerPic logan = new footballPlayerPic ("img/logan.jpeg", "72", "Logan Tuley-Tillman", "OL"); 
    roster.add(logan);
    footballPlayerPic michaelS = new footballPlayerPic ("img/michaelS.jpeg", "75", "Michael Schofield", "OL"); 
    roster.add(michaelS);
    footballPlayerPic quin = new footballPlayerPic ("img/quinton.jpeg", "76", "Quinton Washington", "DT"); 
    roster.add(quin);
    footballPlayerPic taylor = new footballPlayerPic ("img/taylor.jpeg", "77", "Taylor Lewan", "OL", "TaylorLewan77"); 
    roster.add(taylor);
    footballPlayerPic erik = new footballPlayerPic ("img/erik.jpeg", "78", "Erik Magnuson", "OL"); 
    roster.add(erik);
    footballPlayerPic dan = new footballPlayerPic ("img/dan.jpeg", "79", "Dan Gibbs", "OL"); 
    roster.add(dan);
    footballPlayerPic amara = new footballPlayerPic ("img/amara.jpeg", "82", "Amara Darboh", "WR"); 
    roster.add(amara);
    footballPlayerPic ajW = new footballPlayerPic ("img/ajW.jpeg", "84", "A.J. Williams", "TE"); 
    roster.add(ajW);
    footballPlayerPic joe = new footballPlayerPic ("img/joe.jpeg", "85", "Joe Reynolds", "WR"); 
    roster.add(joe);
    footballPlayerPic jehu = new footballPlayerPic ("img/jehu.jpeg", "86", "Jehu Chesson", "WR"); 
    roster.add(jehu);
    footballPlayerPic jake = new footballPlayerPic ("img/jake.jpeg", "88", "Jake Butt", "TE"); 
    roster.add(jake);
    footballPlayerPic Alex = new footballPlayerPic ("img/alex.jpeg", "91", "Alex Mitropoulous-Rundus", "TE"); 
    roster.add(Alex);
    footballPlayerPic Kenneth = new footballPlayerPic ("img/kenneth.jpeg", "91", "Kenneth Allen", "K/P"); 
    roster.add(Kenneth);
    footballPlayerPic keith = new footballPlayerPic ("img/keith.jpeg", "92", "Keith Heitzman", "DE"); 
    roster.add(keith);
    footballPlayerPic jordan = new footballPlayerPic ("img/jordan.jpeg", "94", "Jordan Paskorz", "TE"); 
    roster.add(jordan);
    footballPlayerPic Anthony = new footballPlayerPic ("img/tony.jpeg", "95", "Anthony Capatina", "DB"); 
    roster.add(Anthony);
    footballPlayerPic Michael = new footballPlayerPic ("img/michael.jpeg", "95", "Michael Jocz", "TE"); 
    roster.add(Michael);
    footballPlayerPic Ryan = new footballPlayerPic ("img/ryan.jpeg", "96", "Ryan Glasgow", "DL"); 
    roster.add(Ryan);
    footballPlayerPic breenen = new footballPlayerPic ("img/brennen.jpeg", "97", "Breenen Beyer", "DE"); 
    roster.add(breenen);
    footballPlayerPic matthew = new footballPlayerPic ("img/matthew.jpeg", "99", "Matthew Godin", "DE"); 
    roster.add(matthew);
    
  }

  
  
  public  ArrayList<footballPlayerPic> getRoster() { 
    return roster;
  }
  
}
