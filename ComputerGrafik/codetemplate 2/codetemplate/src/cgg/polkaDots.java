package cgg;

import cgtools.Color;

public class polkaDots {
    int height;
    int width;
    double radius;
    double abstand;
    Color farbe;
    Color background = new Color(0, 0, 0);

    public polkaDots(int height, int width, double radius, double abstand, Color farbe) {
        this.abstand = abstand;
        this.height = height;
        this.farbe = farbe;
        this.radius = radius;
        this.width = width;
    }

    public Color getColor(double x, double y) {
        // Berechnen der Position im Raster basierend auf den Koordinaten x und y
        /** @author chatgpt */
        double nearestX = Math.round(x / (abstand + 2 * radius)) * (abstand + 2 * radius);
        double nearestY = Math.round(y / (abstand + 2 * radius)) * (abstand + 2 * radius);
        // nur bis hier
        if (Math.pow(x - nearestX, 2) + Math.pow(y - nearestY, 2) <= Math.pow(radius, 2)) {
            return farbe;
        }
        return background;

    }

}
