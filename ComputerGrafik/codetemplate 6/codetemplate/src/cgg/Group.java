/** @author chatGPT mit den Kommentare */

package cgg;

import java.util.*;

public class Group implements Shape {
    // Liste zur Speicherung von Shape-Objekten (verschiedene Formen)
    private Shape[] shapes;
    Material material;


    public Group(Shape[] shapes) {
        this.shapes = shapes;
    }


    // Methode zur Bestimmung des nächsten Schnittpunkts eines Strahls mit einer Form in der Gruppe
    @Override
    public Hit intersect(Ray ray) {
        ArrayList<Hit> hits = new ArrayList<Hit>();

        // Iteriere über jede Form in der Gruppe
        for (Shape shape : shapes) {
            // Bestimme den Schnittpunkt des Strahls mit der aktuellen Form
            Hit hit = shape.intersect(ray);
            // Überprüfe, ob der Schnittpunkt existiert und näher ist als der vorherige
            if (hit != null ) {
                hits.add(hit);
            }
        }
        hits.sort(Comparator.comparing(h -> h.getT()));
        for(Hit h: hits){
            return h;
        }
        return null;
    }
        public Material material() {
        return material;
    }
}
