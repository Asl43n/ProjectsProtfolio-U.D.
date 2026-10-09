/** @author chatGPT mit den Kommentare */

package cgg;

import java.util.*;

import cgtools.*;
import cgtools.Vector;

public class Group implements Shape {
    // Liste zur Speicherung von Shape-Objekten (verschiedene Formen)
    private Shape[] shapes;
    private Matrix transformation;
    private Matrix inverseTransformation;

    public Group(Shape[] shapes) {
        this.shapes = shapes;
        this.transformation = Matrix.identity();
        this.inverseTransformation = Matrix.identity();
    }

    public Group(Shape[] shapes, Matrix transformation) {
        this.shapes = shapes;
        this.transformation = transformation;
        this.inverseTransformation = Matrix.invert(transformation);
    }

    // Methode zur Bestimmung des nächsten Schnittpunkts eines Strahls mit einer
    // Form in der Gruppe
    @Override
    public Hit intersect(Ray ray) {
        ArrayList<Hit> hits = new ArrayList<Hit>();
        Point transformedOrigin = Matrix.multiply(inverseTransformation, ray.getOrigin());
        Direction transformedDirection = Matrix.multiply(inverseTransformation, ray.getDirection());
        Ray transformedRay = new Ray(transformedDirection, ray.tMax(), ray.tMin(), transformedOrigin);
        
            // Iteriere über jede Form in der Gruppe
        for (Shape shape : shapes) {
            // Bestimme den Schnittpunkt des Strahls mit der aktuellen Form
            Hit hit = shape.intersect(transformedRay);
            // Überprüfe, ob der Schnittpunkt existiert und näher ist als der vorherige
            if (hit != null) {
                hits.add(hit);
            }
        }
        if (!hits.isEmpty()) {
            hits.sort(Comparator.comparing(Hit::getT));  // Verwenden von Methodenreferenzen für Klarheit
            Hit closestHit = hits.get(0);  // Greife auf den ersten (nächsten) Hit zu
            
            return new Hit(
                closestHit.getT(),
                Matrix.multiply(transformation, closestHit.x()), 
                Vector.normalize(Matrix.multiply(transformation, closestHit.n())),
                closestHit.getMaterial()
            );
        }
        return null;  // Kein Schnittpunkt gefunden
    }

    public Material material() {
        return null;
    }
}
