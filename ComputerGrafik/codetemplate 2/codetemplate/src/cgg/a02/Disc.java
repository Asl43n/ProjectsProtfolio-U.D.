
package cgg.a02;

import cgtools.*;

public class Disc {
  private double x;
  private double y;
  private double radius;
  Color color;

  public Disc(Color color, double radius, double x, double y) {
    this.color = color;
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  public double getRadius(){
    return this.radius;
  }

  public boolean isPointInDisc(double x1, double y1) {
    double längeX = x1 - x;
    double längeY = y1 - y;
    //a^2 + b^2 = c^2 logik
    return längeX * längeX + längeY * längeY <= radius * radius;
  }

  public Color getColor(double x, double y) {
      return color;

  }
}