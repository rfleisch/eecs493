package eecs493.mgosports;

import javax.swing.ImageIcon;

public class hockeyPlayerPic
{
  public ImageIcon pic;
  
  public hockeyPlayerPic(String pic_) {

    pic = new ImageIcon(pic_);
  }
  
  public ImageIcon getPicture() {
    return pic;
  }

}
