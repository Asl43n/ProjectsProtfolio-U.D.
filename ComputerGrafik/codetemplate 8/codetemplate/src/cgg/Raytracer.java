package cgg;

import cgtools.*;

public class Raytracer implements Sampler {
    private Shape shapes; // Liste von Formen, die in der Szene vorhanden sind
    private Lochkamera kamara; // Kamera, die zur Generierung von Strahlen verwendet wird
    private int maxDepth = 20;

    public Raytracer(Lochkamera kamara, Shape g) {
        this.kamara = kamara;
        this.shapes = g;
    }

    @Override
    public Color getColor(double x, double y) {
        Ray ray = kamara.generateRay(x, y);
        return radiance(ray, shapes, maxDepth); // Weiterleitung zur radiance Methode
    }

    public Color radiance(Ray ray, Shape scene, int depth) {
        if (depth == 0) {
            return Vector.black;  // Schwarze Farbe für maximale Tiefe
        }
        Hit hit = scene.intersect(ray);
        Ray secondRay = hit.getMaterial().reflection(ray, hit);
        if(secondRay == null) return hit.getMaterial().emission();
        return Vector.add(hit.getMaterial().emission(), Vector.multiply(radiance(secondRay, scene, depth-1), hit.getMaterial().albedo()));
    }
    
    }

