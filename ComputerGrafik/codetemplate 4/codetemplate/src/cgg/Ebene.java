/** @author chatGPT mit den Kommentare */

package cgg;

import cgtools.*;
import static cgtools.Vector.normalize;

public class Ebene implements Shape {
    private Direction normal; // Normalenvektor der Ebene
    private double r; // Radius der Ebene
    private Point anker; // Ankerpunkt der Ebene (ein Punkt auf der Ebene)
    private Color color; // Farbe der Ebene

    // Konstruktor zur Initialisierung der Ebene mit Normalenvektor, Radius,
    // Ankerpunkt und Farbe
    public Ebene(Direction normal, double r, Point anker, Color color) {
        this.normal = normalize(normal); // Normalisierung des Normalenvektors
        this.r = r;
        this.anker = anker;
        this.color = color;
    }

    // Methode zur Bestimmung des Schnittpunkts der Ebene mit einem Strahl
    @Override
    public Hit intersect(Ray ray) {
        double skalar = Vector.dotProduct(normal, ray.getDirection());

        // Vermeidung von Division durch Null
        if (skalar == 0) {
            return null; // Strahl ist parallel zur Ebene und schneidet sie daher nicht
        }

        // Berechnung des Strahlparameters t zum Schnittpunkt
        double t = Vector.dotProduct(normal, Vector.subtract(anker, ray.getOrigin())) / skalar;

        // Überprüfung, ob t innerhalb der gültigen Reichweite des Strahls liegt
        if (ray.isValid(t)) {
            Point hitPoint = ray.pointAt(t); // Berechnung des Schnittpunkts
            Direction länge = Vector.subtract(anker, hitPoint); // Vektor vom Ankerpunkt zum Schnittpunkt

            // Überprüfung, ob der Schnittpunkt innerhalb des Radius der Ebene liegt
            if (Vector.length(länge) <= r) {
                return new Hit(t, hitPoint, normal, color); // Rückgabe eines neuen Hit-Objekts
            }
        }
        return null; // Kein gültiger Schnittpunkt
    }
}
