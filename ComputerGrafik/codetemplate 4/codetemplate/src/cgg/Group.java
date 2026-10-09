/** @author chatGPT mit den Kommentare */

package cgg;

import java.util.*;

public class Group implements Shape {
    // Liste zur Speicherung von Shape-Objekten (verschiedene Formen)
    private List<Shape> shapes;

    // Konstruktor zur Initialisierung der Liste
    public Group() {
        this.shapes = new ArrayList<>();
    }

    // Methode zum Hinzufügen einer Form zur Gruppe
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    // Methode zur Bestimmung des nächsten Schnittpunkts eines Strahls mit einer Form in der Gruppe
    @Override
    public Hit intersect(Ray ray) {
        Hit closestHit = null; // Nächster Trefferpunkt
        double closestT = Double.POSITIVE_INFINITY; // Nächster Parameter t

        // Iteriere über jede Form in der Gruppe
        for (Shape shape : shapes) {
            // Bestimme den Schnittpunkt des Strahls mit der aktuellen Form
            Hit hit = shape.intersect(ray);
            // Überprüfe, ob der Schnittpunkt existiert und näher ist als der vorherige
            if (hit != null && hit.getT() < closestT) {
                closestHit = hit;
                closestT = hit.getT();
            }
        }
        return closestHit;
    }
}
