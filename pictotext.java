import java.io.File;
import java.io.FileWriter;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.*;
import java.awt.Desktop;
//import java.util.concurrent.TimeUnit;

public class pictotext {
    public static void main(String[] args) throws Exception {
        filechooser file1 = new filechooser();
        String ChosenFile = String.valueOf(file1.filemethod());
        FileWriter writer = new FileWriter(ChosenFile + ".txt");
        System.out.println(ChosenFile);

        int z = 0;
        String PhotoFile = String.valueOf(file1.fileopenmethod());
        System.out.println(PhotoFile);
        File file = new File(PhotoFile);
        BufferedImage img = ImageIO.read(file);
        long start = System.nanoTime();
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                //Retrieving contents of a pixel
                int pixel = img.getRGB(x, y);
                //Creating a Color object from pixel value
                Color color = new Color(pixel, true);
                //Retrieving the R G B values
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int teTriat = red + green + blue;
                if (teTriat < 382) {
                    if (teTriat < 150) {
                        if (teTriat > 100) {
                            writer.append(";");
                        } if (teTriat < 100) {
                            writer.append(".");
                        }
                    } if (teTriat > 150) {
                        if (teTriat < 350) {
                            writer.append("=");
                        } else if (teTriat > 350) {
                            writer.append("/");
                        }
                    }

                }
                if (teTriat > 382) {
                    if (teTriat < 573) {
                        if(teTriat > 477){
                            writer.append("Y");
                        }
                        if(teTriat < 477){
                            writer.append("N");
                        }
                    }
                    if(teTriat > 573){
                        if (teTriat > 668) {
                            writer.append("X");
                        }
                        if (teTriat <668){
                            writer.append("W");

                        }
                    }
                    if (teTriat > 500) {
                        writer.append("N");
                    }
                    writer.flush();
                }
                if (z <= img.getWidth()) {
                    z = z + 1;
                }if (z == img.getWidth()) {
                    z = 0;
                    writer.write(System.getProperty("line.separator"));
                }

            }
        }
        writer.close();
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(ChosenFile + ".txt"));
        double elapsedTime = System.nanoTime() - start;
        System.out.println("EKZEKUTIMI MORRI: " + (elapsedTime / 1000000000));

    }
}
