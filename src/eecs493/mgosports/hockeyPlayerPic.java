package eecs493.mgosports;

import javax.swing.ImageIcon;

public class hockeyPlayerPic implements player
{
  public ImageIcon pic;
  public String num;
  public String name;
  public String pos;
  public String handle;
  
  public hockeyPlayerPic(String pic_, String num_, String name_, String pos_) {

    pic = new ImageIcon(pic_);
    num = num_;
    name = name_;
    pos = pos_;
    handle = "";
  }
  
  public hockeyPlayerPic(String pic_, String num_, String name_, String pos_, String handle_) {

      pic = new ImageIcon(pic_);
      num = num_;
      name = name_;
      pos = pos_;
      handle = handle_;
    }
  
  public ImageIcon getPicture() {
    return pic;
  }
  
  public String getNum() {
    return num;
  }
  public String getName() {
    return name;
  }
  public String getPos() {
    return pos;
  }
  
  public String getHandle()
  {
      return handle;
  }

}
