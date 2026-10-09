package cgg.a03;

import cgtools.*;

public class Ray {
    private Point x; // ursprung
    private Direction d; // richtung
    private double tMin;
    private double tMax;

    public Point getOrigin(){
        return x;
    }

  
    public Ray(Direction d, double tMax, double tMin, Point x) {
        this.d = d;
        this.tMin = tMin;
        this.tMax = tMax;
        this.x = x;
    }  

  //berechnet für einen Parameter t einen Punkt x auf dem Strahl, so dass gilt x(t) = x0 + t d
    public Point pointAt(double t) {
        return new Point(                
        x.x() + t * d.x(),
        x.y() + t * d.y(),
        x.z() + t * d.z());
    }

    public Direction getDirection(){
        return d;
    }

//überprüft, ob der übergebene Strahlparameter im Interval [tmin, tmax] liegt.
    public boolean isValid(double t) {
        return tMin <= t && t <= tMax;
    }
}
