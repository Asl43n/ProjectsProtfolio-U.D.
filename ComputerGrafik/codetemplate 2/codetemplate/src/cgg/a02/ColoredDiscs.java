/** @author henrik.tramberend@bht-berlin.de */
package cgg.a02;
import static cgtools.Vector.color;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import cgtools.*;

public class ColoredDiscs {
  private List<Disc> discs;

  ColoredDiscs() {
    this.discs = new ArrayList<>();
  }

  public void addDisc(Disc disc){
    discs.add(disc);
    //@author chatpgt kurz gesagt sortiert Kreise von klein (vorne) nach groß (hinzen) per radius
    discs.sort(Comparator.comparingDouble(Disc::getRadius));
  }

  // Returns the color for the given position.
  public Color getColor(double x, double y) {
    for(Disc disc : discs){
      if(disc.isPointInDisc(x, y)){
        return disc.getColor(x, y);
      }
    }
    return color(0, 0, 0);
  }

  //@author chatgpt eine korriegierte version von der ganze methode
  public static ColoredDiscs createRandomDiscs(int numDisc){
    Random random = new Random();
    ColoredDiscs coloredDiscs = new ColoredDiscs();
    for(int i = 0; i < numDisc; i++){
      double x = random.nextDouble()* 512; //idee ist das nextDouble 0 bis 1 random macht und max 500 und min 0 sein kann
      double y = random.nextDouble()* 256; //btw stellt die pos im bild da
      double radius = 10 + random.nextDouble()* 90; //min 10 max 100
      Color color = new Color(random.nextDouble(), random.nextDouble(), random.nextDouble());
      coloredDiscs.addDisc(new Disc(color, radius, x, y));
    }
    return coloredDiscs;
  }
}