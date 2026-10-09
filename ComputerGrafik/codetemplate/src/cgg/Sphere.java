/** @author chatGPT mit den Kommentare */

package cgg;

import cgtools.*;

public class Sphere implements Shape {

    private Point center; // Zentrum der Kugel
    private double radius; // Radius der Kugel
    private Color color; // Farbe der Kugel

    // Konstruktor zur Initialisierung der Kugel mit Zentrum, Radius und Farbe
    public Sphere(Point center, double radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    // Methode zur Bestimmung des Schnittpunkts einer Kugel mit einem Strahl
    @Override
    public Hit intersect(Ray r) {
        // Vektor vom Ursprung des Strahls zum Zentrum der Kugel
        Direction MittelpunktK = Vector.subtract(r.getOrigin(), center);

        // Berechnung der Koeffizienten für die quadratische Gleichung ax^2 + bx + c
        double a = Vector.dotProduct(r.getDirection(), r.getDirection());
        double b = 2 * Vector.dotProduct(MittelpunktK, r.getDirection());
        double c = Vector.dotProduct(MittelpunktK, MittelpunktK) - (radius * radius);

        // Berechnung der Diskriminante zur Bestimmung der Schnittpunkte
        double diskriminant = (b * b) - (4 * a * c);

        // Überprüfung, ob es reale Schnittpunkte gibt
        if (diskriminant < 0) {
            return null; // Kein realer Schnittpunkt
        }

        // Berechnung der beiden möglichen Schnittpunkte t1 und t2
        double sqrtD = Math.sqrt(diskriminant);
        double t1 = (-b - sqrtD) / (2 * a);
        double t2 = (-b + sqrtD) / (2 * a);

        // Überprüfung des ersten Schnittpunkts t1 auf Gültigkeit
        if (r.isValid(t1)) {
            Point hitPoint = r.pointAt(t1);
            Direction normal1 = Vector.normalize(Vector.subtract(hitPoint, center));
            return new Hit(t1, hitPoint, normal1, color); // Erstellen eines neuen Hit-Objekts
        }
        // Überprüfung des zweiten Schnittpunkts t2 auf Gültigkeit
        else if (r.isValid(t2)) {
            Point hitPoint = r.pointAt(t2);
            Direction normal1 = Vector.normalize(Vector.subtract(hitPoint, center));
            return new Hit(t2, hitPoint, normal1, color); // Erstellen eines neuen Hit-Objekts
        }

        return null; // Kein gültiger Schnittpunkt
    }

}
