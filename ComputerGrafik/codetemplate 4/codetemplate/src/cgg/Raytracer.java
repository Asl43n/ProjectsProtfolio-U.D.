/** @author chatGPT mit den Kommentare */

package cgg;

import cgtools.*;

import java.util.ArrayList;
import java.util.List;

public class Raytracer implements Sampler {
    private List<Shape> shapes; // Liste von Kugeln, die in der Szene vorhanden sind
    private Lochkamera kamara; // Kamera, die zur Generierung von Strahlen verwendet wird
    private Shape background; // Hintergrund-Shape

    public Raytracer(Lochkamera kamara) {
        this.kamara = kamara;
        this.shapes = new ArrayList<>();
    }

    // Konstruktor zur Initialisierung des Raytracers mit einer Kamera
    public Raytracer(Lochkamera kamara, Shape background) {
        this.kamara = kamara;
        this.background = background;
        this.shapes = new ArrayList<>();
    }

    // Methode zum Hinzufügen einer Kugel zur Szene
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    // Methode zur Bestimmung der Farbe eines Pixels basierend auf den
    // Bildkoordinaten (x, y)
    @Override
    public Color getColor(double x, double y) {
        // Generiere einen Strahl basierend auf den Bildkoordinaten
        Ray ray = kamara.generateRay(x, y);
        double t = Double.POSITIVE_INFINITY;
        Hit closestHit = null;

        // Überprüfe jede Kugel auf Schnittpunkte mit dem Strahl
        for (Shape kugel : shapes) {
            Hit hit = kugel.intersect(ray);
            // Wenn ein Schnittpunkt existiert und näher ist als der vorherige, aktualisiere
            // den nächsten Treffer
            if (hit != null && hit.getT() < t) {
                t = hit.getT();
                closestHit = hit;
            }
        }
        // Wenn kein Schnittpunkt gefunden wurde, gebe die Hintergrundfarbe zurück
        if (closestHit == null) {
            return background.intersect(ray).color();
        }
        // Berechne die Schattierung basierend auf dem Trefferpunkt und gebe die
        // resultierende Farbe zurück
        return shade(closestHit.n(), closestHit.color());
    }

    // Methode zur Berechnung der Schattierung basierend auf der Normalen und der
    // Grundfarbe
    Color shade(Direction normal, Color color) {
        // Richtung der Lichtquelle
        Direction lightDir = Vector.normalize(Vector.direction(1, 1, 0.5));
        // Umgebungsbeleuchtung
        Color ambient = Vector.multiply(0.1, color);
        // Diffuse Beleuchtung basierend auf der Lichtquelle und der Normalen
        Color diffuse = Vector.multiply(0.9 * Math.max(0, Vector.dotProduct(lightDir, normal)), color);
        // Rückgabe der kombinierten Farbe
        return Vector.add(ambient, diffuse);
    }

}
