package cgg.a03;

import cgtools.*;

// repräsentiert das Ergebnis einer Schnittuntersuchung 
public class Hit {
    private double t; // Strahlparameter
    private Point x; // der Position des Trefferpunkts
    private Direction n; // Normalenvektor

    public Hit(double t, Point x, Direction n) {
        this.t = t;
        this.x = x;
        this.n = n;
    }

    public double getT() {
        return t;
    }

    public Point x() {
        return x;
    }

    public Direction n() {
        return n;
    }

}
