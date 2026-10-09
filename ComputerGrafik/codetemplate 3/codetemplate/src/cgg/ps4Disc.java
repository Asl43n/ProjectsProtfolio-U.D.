package cgg;

import cgtools.Color;

public class ps4Disc {
    Color circleColor;
    Color backgroundColor = new Color(0, 0, 0);
    int width;
    int height;
    double radius;

    public ps4Disc(int width, int height, double radius, Color circleColor) {
        this.height = height;
        this.width = width;
        this.radius = radius;
        this.circleColor = circleColor;
    }
    // (x−cx)^2 +(y−cy)^2 < r^2 = mittelpunkt
    // formel für kreiserstellung laut chatGPT

    public Color getColor(int x, int y) {
        double cx = width / 2;
        double cy = height / 2; // Beide stellen die mittelpunkte dar
        double cdDistance = Math.pow(x - cx, 2) + Math.pow(y - cy, 2); // formel von oben

        if (cdDistance <= Math.pow(radius, 2)) {
            return circleColor;
        } else {
            return backgroundColor;
        }
    }
}
