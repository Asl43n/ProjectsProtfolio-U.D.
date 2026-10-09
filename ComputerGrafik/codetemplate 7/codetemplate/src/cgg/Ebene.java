/** @author chatGPT mit den Kommentare */

package cgg;

import cgtools.*;
import static cgtools.Vector.normalize;

public class Ebene implements Shape {
    private Direction normal; // Normalenvektor der Ebene
    private Point anker; // Ankerpunkt der Ebene (ein Punkt auf der Ebene)
    private Material material; // Farbe der Ebene

    // Konstruktor zur Initialisierung der Ebene mit Normalenvektor, Radius,
    // Ankerpunkt und Farbe

    public Ebene(Direction normal, Point anker,  Material material) {
        this.normal = normalize(normal); // Normalisierung des Normalenvektors
        this.anker = anker;
        this.material = material;
    }

    // Methode zur Bestimmung des Schnittpunkts der Ebene mit einem Strahl
    @Override
    public Hit intersect(Ray ray) {
        double dotProduct = Vector.dotProduct(normal, ray.getDirection());
    
        if (dotProduct == 0) {
            return null;
        }
    
        double t = Vector.dotProduct(normal, Vector.subtract(anker, ray.getOrigin())) / dotProduct;
    
        if (!ray.isValid(t)) {
            return null;
        }
    
        Point hitPoint = ray.pointAt(t);
        return new Hit(t, hitPoint, normal, material);
    }
    public Material material() {
        return material; 
    }
}
