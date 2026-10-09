package cgg.a03;

import cgtools.*;

public class LochKamara {
    private double winkel;
    private double height;
    private double width;

    public LochKamara(double winkel, double height, double width) {
        this.winkel = winkel;
        this.height = height;
        this.width = width;
    }

    public Ray generateRay(double xp, double yp){
        Direction direction = Vector.direction(
            xp - width / 2,
            -(yp - height / 2),
            -width / (2 * Math.tan(winkel / 2))
        ); 
        Direction normDirection = Vector.normalize(direction);
 
        Direction direction1 = new Direction(normDirection.x(),normDirection.y(),normDirection.z());
        Point ursprung = new Point(0,0,0);

        return new Ray(direction1, Double.POSITIVE_INFINITY, 0, ursprung);
    }

}
