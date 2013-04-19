package eecs493.mgosports;

import java.util.ArrayList;

public class hockeyRoster
{
  private ArrayList<hockeyPlayerPic> roster = new ArrayList<hockeyPlayerPic>();
  
  public hockeyRoster() {
    hockeyPlayerPic racine = new hockeyPlayerPic("img/steveRacine.jpeg", "1", "Steve Racine", "G");
    hockeyPlayerPic chiasson = new hockeyPlayerPic( "img/chiasson.jpeg", "2", "Mike Chiasson", "D");
    hockeyPlayerPic clare = new hockeyPlayerPic("img/clare.jpeg", "4", "Kevin Clare",  "D");
    hockeyPlayerPic serville = new hockeyPlayerPic("img/serv.jpeg", "6", "Brennan Serville", "D");
    hockeyPlayerPic diGiu = new hockeyPlayerPic( "img/diGiu.jpeg", "7", "Phil Di Giuseppe", "F");
    hockeyPlayerPic truba = new hockeyPlayerPic("img/trouba.jpeg", "8", "Jacob Truba", "D");
    hockeyPlayerPic moffatt = new hockeyPlayerPic("img/moffatt.jpeg", "9", "Luke Moffatt", "F");
    hockeyPlayerPic selman = new hockeyPlayerPic( "img/selman.jpeg", "10", "Justin Selman", "F");
    hockeyPlayerPic hyman = new hockeyPlayerPic("img/hyman.jpeg", "11", "Zach Hyman", "F");
    hockeyPlayerPic boo = new hockeyPlayerPic("img/boo.jpeg", "12", "Cristoval 'Boo' Nieves", "F");
    hockeyPlayerPic moffie = new hockeyPlayerPic( "img/moffie.jpeg", "13", "Lee Moffie", "D");
    hockeyPlayerPic klynch = new hockeyPlayerPic("img/klynch.jpeg", "14", "Kevin Lynch", "F");
    hockeyPlayerPic sinelli = new hockeyPlayerPic("img/sinelli.jpeg", "17", "Andrew Sinelli", "F");
    hockeyPlayerPic copp = new hockeyPlayerPic( "img/copp.jpeg", "18", "Andrew Copp", "F");
    hockeyPlayerPic deblois = new hockeyPlayerPic("img/deblois.jpeg", "19", "Derek DeBlois", "F");
    hockeyPlayerPic tlynch = new hockeyPlayerPic("img/tlynch.jpeg", "20", "Travis Lynch", "F", "TravisLynch20");
    hockeyPlayerPic rohr = new hockeyPlayerPic( "img/rohr.jpeg", "22", "Jeff Rohrkemper", "F");
    hockeyPlayerPic aj = new hockeyPlayerPic("img/aj.jpeg", "23", "A.J. Treais", "F");
    hockeyPlayerPic merrill = new hockeyPlayerPic("img/merrill.jpeg", "24", "Jon Merrill", "D");
    hockeyPlayerPic szuma = new hockeyPlayerPic( "img/szuma.jpeg", "26", "Mike Szuma", "D");
    hockeyPlayerPic guptill = new hockeyPlayerPic("img/guptill.jpeg", "27", "Alex Guptill", "F", "alexguptill");
    hockeyPlayerPic rut = new hockeyPlayerPic("img/rut.jpeg", "28", "Jared Rutledge", "G");
    hockeyPlayerPic dwyer = new hockeyPlayerPic( "img/dwyer.jpeg", "29", "Luke Dwyer", "G");
    hockeyPlayerPic janecyk = new hockeyPlayerPic("img/jan.jpeg", "30", "Adam Janecyk", "G");
    hockeyPlayerPic bennett = new hockeyPlayerPic("img/bennett.jpeg", "37", "Mac Bennett", "D");
    hockeyPlayerPic sparks = new hockeyPlayerPic( "img/sparks.jpeg", "39", "Lindsay Sparks", "F");
    
    
    roster.add(racine);
    roster.add(chiasson);
    roster.add(clare);
    roster.add(serville);
    roster.add(diGiu);
    roster.add(truba);
    roster.add(moffatt);
    roster.add(selman);
    roster.add(hyman);
    roster.add(boo);
    roster.add(moffie);
    roster.add(klynch);
    roster.add(sinelli);
    roster.add(copp);
    roster.add(deblois);
    roster.add(tlynch);
    roster.add(rohr);
    roster.add(aj);
    roster.add(merrill);
    roster.add(szuma);
    roster.add(guptill);
    roster.add(rut);
    roster.add(dwyer);
    roster.add(janecyk);
    roster.add(bennett);
    roster.add(sparks);
    
  }

  public  ArrayList<hockeyPlayerPic> getRoster() {
    return roster;
  }

}
