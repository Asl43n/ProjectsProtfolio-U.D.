/** @author chatGPT mit den Kommentare */

package cgg;

import cgtools.*;

public class Lochkamera {
    private double winkel; // Sichtwinkel der Kamera
    private double height; // Höhe des Bildes
    private double width; // Breite des Bildes

    // Konstruktor zur Initialisierung der Kamera mit Winkel, Höhe und Breite
    public Lochkamera(double winkel, double height, double width) {
        this.winkel = winkel;
        this.height = height;
        this.width = width;
    }

    // Methode zur Generierung eines Strahls (Ray) basierend auf Bildkoordinaten
    // (xp, yp)
    public Ray generateRay(double xp, double yp) {
        // Berechnung der Richtung des Strahls basierend auf den Bildkoordinaten
        Direction direction = Vector.direction(
                xp - width / 2,
                -(yp - height / 2),
                -width / (2 * Math.tan(winkel / 2)));
        // Normalisierung der berechneten Richtung
        Direction normDirection = Vector.normalize(direction);

        // Ursprung des Strahls ist der Koordinatenursprung (0, 0, 0)
        Point ursprungsPoint = new Point(0, 0, 0);

        // Rückgabe des generierten Strahls mit der berechneten Richtung und dem
        // Ursprung
        return new Ray(normDirection, Double.POSITIVE_INFINITY, Util.EPSILON, ursprungsPoint);
    }
}
