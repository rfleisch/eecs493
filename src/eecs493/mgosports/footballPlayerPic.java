package eecs493.mgosports;

import javax.swing.ImageIcon;

public class footballPlayerPic
{
  public ImageIcon pic;
  public String num;
  public String name;
  public String pos;
  
  public footballPlayerPic(String pic_, String num_, String name_, String pos_) {

    pic = new ImageIcon(pic_);
    num = num_;
    name = name_;
    pos = pos_;
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

}
