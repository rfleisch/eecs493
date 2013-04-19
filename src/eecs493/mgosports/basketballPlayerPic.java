package eecs493.mgosports;

import javax.swing.ImageIcon;

public class basketballPlayerPic implements player
{
  public ImageIcon pic;
  public String num;
  public String name;
  public String pos;
  public String height;
  public String handle;
  
  public basketballPlayerPic(String pic_, String num_, String name_, String height_, String pos_) {

    pic = new ImageIcon(pic_);
    num = num_;
    name = name_;
    pos = pos_;
    height = height_;
    handle = "";
  }
  
  public basketballPlayerPic(String pic_, String num_, String name_, String height_, String pos_, String handle_) {

      pic = new ImageIcon(pic_);
      num = num_;
      name = name_;
      pos = pos_;
      height = height_;
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
