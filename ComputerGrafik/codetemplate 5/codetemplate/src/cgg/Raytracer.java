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

    public Color radiance(Ray ray, Shape scene, int depth) {// Berechnet die Farbe, die von einem Strahl stammt, indem es rekursiv die Strahlenverfolgung durchführt.
        if (depth == 0) {//Rekursionstiefenbegrenzung
            return Vector.black;  // Schwarze Farbe für maximale Tiefe
        }
        Hit hit = scene.intersect(ray);//Hier wird der Schnittpunkt des Strahls mit der Szene berechnet. Die intersect-Methode gibt ein Hit-Objekt zurück, das Informationen über den Schnittpunkt enthält (z.B. Position, Normale, Material).
        Ray secondRay = hit.getMaterial().reflection(ray, hit);//Die reflection-Methode des Materials berechnet den reflektierten Strahl basierend auf den Eigenschaften des Materials und dem Schnittpunkt.
        if(secondRay == null) return hit.getMaterial().emission();//Wenn das Material keine Reflexion hat (d.h. secondRay ist null), gibt die Methode die emittierte Farbe des Materials zurück.
        return Vector.add(hit.getMaterial().emission(), Vector.multiply(radiance(secondRay, scene, depth-1), hit.getMaterial().albedo()));//Wenn ein reflektierter Strahl existiert, wird die radiance-Methode rekursiv auf den reflektierten Strahl aufgerufen, wobei die Rekursionstiefe um 1 verringert wird. Die resultierende Farbe wird mit der Albedo des Materials multipliziert (um die Streuung zu berücksichtigen) und zur emittierten Farbe des Materials addiert.
    }
    
    }

