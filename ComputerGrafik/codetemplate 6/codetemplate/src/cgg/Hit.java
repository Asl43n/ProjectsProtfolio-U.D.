package cgg;

import cgtools.*;

public class Hit {
    private double t; // Strahlparameter
    private Point x; // die Position des Trefferpunkts
    private Direction n; // Normalenvektor
    private Material material;

    public Hit(double t, Point x, Direction n, Material material) {
        this.t = t;
        this.x = x;
        this.n = n;
        this.material = material;
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

    public Material getMaterial(){
        return material;
    }

}
