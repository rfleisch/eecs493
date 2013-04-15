package eecs493.mgosports;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


/**
 * Class that creates the graph
 * @author edance
 *
 */
public class Graph {

  final static int PAD = 80;
  static BufferedImage image;
  final static int WIDTH = 800;
  final static int HEIGHT = 600;
  static Graphics2D g2;
  final static Color[] ColorWheel = {
    Color.CYAN,
    Color.BLUE,
    Color.DARK_GRAY,
    Color.GREEN,
    Color.MAGENTA,
    Color.ORANGE,
    Color.PINK,
    Color.RED,
  };
  
  static
  {
    image = new BufferedImage(  WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    g2 = image.createGraphics();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setColor(Color.WHITE);
    g2.fillRect(0, 0, WIDTH, HEIGHT);
  }
  
  public static BufferedImage getGraph(int [] data)
  {
    g2.setColor(Color.WHITE);
    g2.fillRect(0, 0, WIDTH, HEIGHT);
    drawLines(data);
    drawAxis(data);
    try
    {
      File file = new File("H:/graph.png");
      ImageIO.write(image, "png", file);
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
    return image;
  }

  private static void drawAxis(int [] numbers) {
    g2.setColor(Color.BLACK);
    g2.drawRect(PAD, PAD, WIDTH - 2 * PAD, HEIGHT - 2 * PAD);
      for (int i = 0; i < numbers.length; i++)
        g2.draw(new Line2D.Double(i * (WIDTH - (2 * PAD)) / numbers.length - 1 + PAD, HEIGHT-PAD,
            i * (WIDTH - (2 * PAD)) / numbers.length - 1 + PAD, HEIGHT-PAD - 3));
      for (int i = 0; i < 6; i++)
        g2.draw(new Line2D.Double(PAD, i * (HEIGHT - (2 * PAD)) / 5 + PAD,
            PAD + 3, i * (HEIGHT - (2 * PAD)) / 5 + PAD));
      Font font = g2.getFont();
      FontRenderContext frc = g2.getFontRenderContext();
      LineMetrics lm = font.getLineMetrics("0", frc);
      float sh = lm.getAscent() + lm.getDescent();
      String s = "Tweets";
      float sy = PAD + ((HEIGHT - 2*PAD) - s.length()*sh)/2 + lm.getAscent();
      for(int i = 0; i < s.length(); i++) {
          String letter = String.valueOf(s.charAt(i));
          float sw = (float)font.getStringBounds(letter, frc).getWidth();
          float sx = (PAD - sw)/2;
          g2.drawString(letter, sx, sy);
          sy += sh;
      }
      s = "Tweets Per Day";
      sy = HEIGHT - PAD + (PAD - sh)/2 + lm.getAscent();
      float sw = (float)font.getStringBounds(s, frc).getWidth();
      float sx = (WIDTH - sw)/2;
      g2.drawString(s, sx, sy);
  }
  
  private static void drawLines(int [] numbers)
  {
      double xInc = (double)(WIDTH - 2*PAD)/(numbers.length-1);
      int max = 0;
      for(int i = 0; i < numbers.length - 1; i++) {
        max = Math.max(max, numbers[i]);
      }
      double scale = (double)(HEIGHT - 2*PAD)/ (double)max;
      g2.setPaint(ColorWheel[0]);

      for(int i = 0; i < numbers.length - 1; i++) {
          double x1 = PAD + i*xInc;
          double y1 = HEIGHT - PAD - scale* (double)numbers[i];
          double x2 = PAD + (i+1)*xInc;
          double y2 = HEIGHT - PAD - scale* (double)numbers[i + 1];
          g2.draw(new Line2D.Double(x1, y1, x2, y2));
      }
  }
}