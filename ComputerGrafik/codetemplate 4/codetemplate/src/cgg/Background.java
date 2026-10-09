package cgg;

import cgtools.*;

public class Background implements Shape {

    private Color color;

    public Background(Color color) {
        this.color = color;
    }

    @Override
    public Hit intersect(Ray ray) {
        // den Hintergrund ganz nach hinten schicken
        return new Hit(Double.POSITIVE_INFINITY, ray.pointAt(Double.POSITIVE_INFINITY), ray.getDirection(), color);

    }

}
