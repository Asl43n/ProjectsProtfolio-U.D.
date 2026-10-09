/** @author henrik.tramberend@bht-berlin.de */
package cgg.a03;
import cgtools.*;
import cgg.*;

public class Main {

  public static void main(String[] args) {
    final int width = 7680; //512;
    final int height = 4320; //256;

    Image image = new Image(width, height);
    LochKamara a32 = new LochKamara(Math.PI / 2, 10, 10);
    LochKamara kamara = new LochKamara(Math.PI / 2, height, width);
    Raytracer raytracer = new Raytracer(kamara);

        raytracer.addKugel(new Kugel(new Point(0, 0, -7), 2));
        raytracer.addKugel(new Kugel(new Point(2, 0, -6), 0.5));
        raytracer.addKugel(new Kugel(new Point(-2, 0, -6), 0.5));
        raytracer.addKugel(new Kugel(new Point(0, -1, -4), 0.75));
        raytracer.addKugel(new Kugel(new Point(0, 2, -7), 1.5));
   
        image.superSample((Sampler) raytracer);
    
    Ray ray1 = a32.generateRay(0, 0);
    Ray ray2 = a32.generateRay(5, 5);
    Ray ray3 = a32.generateRay(10, 10);

    System.out.println(printVector(ray1.getDirection()));
    System.out.println(printVector(ray2.getDirection()));
    System.out.println(printVector(ray3.getDirection()));

    final String filename = "doc/a03-image.png";
    image.imageWrite(filename);
    System.out.println("Wrote image: " + filename);
  }
//@Author chatgpt. davor hat er nur den verzeichnis geprintet
  private static String printVector(Direction v){
    return String.format("(%f, %f, %f)",  v.x(), v.y(), v.z());
  }
}
