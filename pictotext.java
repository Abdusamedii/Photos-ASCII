import java.io.File;
import java.io.FileWriter;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
public class pictotext{
   public static void main(String args[])throws Exception {
	  Scanner sc = new Scanner(System.in);
	  System.out.println("qysh po don me qujt file??????????");
	  String venditxt = sc.nextLine();
      FileWriter writer = new FileWriter("C:\\Users\\EmriUserit\\Pictures\\" + venditxt + ".txt");
	  int z = 0;
	   
      File file= new File("C:\\Users\\meddi\\Pictures\\emriIfotografise.jpg");
      BufferedImage img = ImageIO.read(file);
      for (int y = 0; y < img.getHeight(); y++) {
         for (int x = 0; x < img.getWidth(); x++) {
            //Retrieving contents of a pixel
            int pixel = img.getRGB(x,y);
            //Creating a Color object from pixel value
            Color color = new Color(pixel, true);
            //Retrieving the R G B values
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
			int teTriat = red + green + blue;
			if(teTriat < 382){
				if(teTriat < 150){
					if(teTriat > 100){
					writer.append(";");
					}
					if(teTriat < 100){
						writer.append(".");
					}
				}
				
				if(teTriat > 150){
					if(teTriat < 350){
					writer.append("=");
					}
					if(teTriat > 350){
						writer.append("/");
					}
				}
				writer.flush();
			}
			if(teTriat > 382){
				if(teTriat < 500){
					if(teTriat > 650){
					writer.append("X");
					}
					if(teTriat < 650){
						writer.append("Y");
					}
				}
				if(teTriat > 500){
					writer.append("N");
				}
				writer.flush();
			}
			if(z<= img.getWidth()){
				z = z + 1;
			}
			if(z == img.getWidth()){
				z = 0;
				writer.write(System.getProperty("line.separator"));
			}
			
         }
      }
      writer.close();
      System.out.println("RGB values at each pixel are stored in the specified file");
   }
}
