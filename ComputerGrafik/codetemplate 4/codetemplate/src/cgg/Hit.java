package cgg;

import cgtools.*;

public class Hit {
    private double t; // Strahlparameter
    private Point x; // der Position des Trefferpunkts
    private Direction n; // Normalenvektor
    private Color color;

    public Hit(double t, Point x, Direction n, Color color) {
        this.t = t;
        this.x = x;
        this.n = n;
        this.color = color;
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

    public Color color(){
        return color;
    }

}
