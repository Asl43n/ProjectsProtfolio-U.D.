/** @author henrik.tramberend@bht-berlin.de */
package cgg;

import cgg.a02.ColoredDiscs;
import cgtools.*;
import cgtools.Random;

public class Image {

  private double[] daten;
  private int width;
  private int height;
  private double gamma = 2.2; // die gammakorrektion ist auf 1/2.2 in monitoren laut vorlesungsblätter

  public Image(int width, int height) {
    this.width = width;
    this.height = height;
    this.daten = new double[width * height * 3];
  }

  public void setPixel(int x, int y, Color color) {
    int index = (y * width + x) * 3;
    daten[index] = color.r();
    daten[index + 1] = color.g();
    daten[index + 2] = color.b();
  }

  // ig = i^1/gamma
  public double gammakorrektion(double i) {
    return Math.pow(i, 1 / gamma);
  }

  public void sample(ColoredDiscs discs) {
    int n = 2;
    for (int x = 0; x != width; x++) {
      for (int y = 0; y != height; y++) {
        //Stratified Sampling
        Color vorFarbe = new Color(0, 0, 0);
        for (int xi = 0; xi < n; xi++) {
          for (int yi = 0; yi < n; yi++) {
            double rx = Random.random();
            double ry = Random.random();
            double xs = x + (xi + rx) / n;
            double ys = y + (yi + ry) / n;
            Color nebenColor = discs.getColor(xs, ys);
            //bis hier aus Foilien vorlage
            vorFarbe = new Color(
                vorFarbe.r() + nebenColor.r() / (n * n),
                vorFarbe.g() + nebenColor.g() / (n * n),
                vorFarbe.b() + nebenColor.b() / (n * n));
          }
        }
        Color nachColor = new Color(
            gammakorrektion(vorFarbe.r()),
            gammakorrektion(vorFarbe.g()),
            gammakorrektion(vorFarbe.b()));
        setPixel(x, y, nachColor);
      }
    }
  }

  public void imageWrite(String filename) {
    ImageWriter.write(filename, daten, width, height);
  }
}
