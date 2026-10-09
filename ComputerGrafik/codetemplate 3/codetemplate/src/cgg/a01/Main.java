/** @author henrik.tramberend@bht-berlin.de */
package cgg.a01;

import static cgtools.Vector.*;
import cgg.*;

public class Main {

  public static void main(String[] args) {
    final int width = 512;
    final int height = 256;

    // This class instance defines the contents of the image.
    ConstantColor content = new ConstantColor(red);
    ps4Disc cDisc = new ps4Disc(width, height, 50.0, red);
    polkaDots many = new polkaDots(height, width, 9.0, 1, blue);

    // Creates an image and iterates over all pixel positions inside the image.
    //aufgabe 1.4
    Image image = new Image(width, height);
    for (int x = 0; x != width; x++) {
      for (int y = 0; y != height; y++) {
        // Sets the color for one particular pixel.
        image.setPixel(x, y, content.getColor(x, y));
      }
    }

    // Write the image to disk.
    final String filename = "doc/a01-image.png";
    image.imageWrite(filename);
    System.out.println("Wrote image: " + filename);

    // aufgabe 1.5
    Image image2 = new Image(width, height);
    for (int x = 0; x != width; x++) {
      for (int y = 0; y != height; y++) {
        // Sets the color for one particular pixel.
        image2.setPixel(x, y, cDisc.getColor(x, y));
      }
    }

    // Write the image to disk.
    final String filename2 = "doc/a01-disc.png";
    image2.imageWrite(filename2);
    System.out.println("Wrote image: " + filename2);

    // aufgabe 1.6
    Image image3 = new Image(width, height);
    for (int x = 0; x != width; x++) {
      for (int y = 0; y != height; y++) {
        // Sets the color for one particular pixel.
        image3.setPixel(x, y, many.getColor(x, y));
      }
    }

    // Write the image to disk.
    final String filename3 = "doc/a01-many.png";
    image3.imageWrite(filename3);
    System.out.println("Wrote image: " + filename3);
  }
}
