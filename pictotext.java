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
import java.awt.Desktop;
import java.util.concurrent.TimeUnit;

public class pictotext {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        filechooser file1 = new filechooser();
        String ChosenFile = String.valueOf(file1.filemethod());
        FileWriter writer = new FileWriter(ChosenFile + ".txt");
        System.out.println(ChosenFile);

        int z = 0;

        File file = new File("C:\\Users\\meddi\\Pictures\\emriIfotografise.jpg");
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
                    //writer.flush();
                } if (teTriat > 382) {
                    if (teTriat < 500) {
                        if (teTriat > 650) {
                            writer.append("X");
                        }if (teTriat < 650) {
                            writer.append("Y");
                        }
                    } if (teTriat > 500) {
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
        //desktop.open(writer);
        double elapsedTime = System.nanoTime() - start;
        System.out.println("EKZEKUTIMI MORRI: " + (elapsedTime / 1000000000) + "+");

    }
}
