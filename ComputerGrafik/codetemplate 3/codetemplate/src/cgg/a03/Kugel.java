package cgg.a03;

import cgtools.*;

public class Kugel {

    private Point center;
    private double radius;

    public Kugel(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Hit intersect(Ray r) {
        Direction MittelpunktK = Vector.subtract(r.getOrigin(), center );
        // für Quadratische gleichung ax^2 + bx + c
        double a = Vector.dotProduct(r.getDirection(), r.getDirection());
        double b = 2 * Vector.dotProduct(MittelpunktK, r.getDirection() );
        double c = Vector.dotProduct(MittelpunktK, MittelpunktK) - (radius * radius);

        double diskriminant = (b * b) - (4 * a * c);

        if (diskriminant < 0) { 
            return null;
        }
        double sqrtD = (Math.sqrt(diskriminant));
        double t1 = (-b - sqrtD) / (2 * a);
        double t2 = (-b + sqrtD) / (2 * a);

        if (r.isValid(t1)){
            Point hitPoint = r.pointAt(t1); 
            Direction normal1 = Vector.normalize(Vector.subtract(hitPoint, center));
            return new Hit(t1, hitPoint, normal1);
        }
        else if (r.isValid(t2)){
            Point hitPoint = r.pointAt(t2); 
            Direction normal1 = Vector.normalize(Vector.subtract(hitPoint, center));
            return new Hit(t2, hitPoint, normal1);
        }
        return null;
    }
    
}
