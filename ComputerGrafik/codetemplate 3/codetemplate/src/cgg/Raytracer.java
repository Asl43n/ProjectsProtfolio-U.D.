package cgg;

import cgtools.*;
import cgtools.Vector;
import java.util.ArrayList;
import java.util.List;
import cgg.a03.*;

public class Raytracer implements Sampler{
    List<Kugel> kugelList;
    LochKamara kamara;

    public Raytracer(LochKamara kamara) {
        this.kamara = kamara;
        kugelList = new ArrayList<>();
    }

    public void addKugel(Kugel kugell) {
        kugelList.add(kugell);
    }

    public Color getColor(double x, double y) {
        Ray ray = kamara.generateRay(x, y);
        double t = Double.POSITIVE_INFINITY;
        Hit closestHit = null;

        for (Kugel kugel : kugelList) {
            Hit hit = kugel.intersect(ray);
            if (hit != null && hit.getT() < t) {
                t = hit.getT();
                closestHit = hit;
            }
        }
        if (closestHit == null) {
            return new Color(0, 0, 0);
        }
        return shade(closestHit.n(), new Color(0, 2, 2));
    }

    Color shade(Direction normal, Color color) {
        Direction lightDir = Vector.normalize(Vector.direction(1, 1, 0.5));
        Color ambient = Vector.multiply(0.1, color);
        Color diffuse = Vector.multiply(0.9 * Math.max(0,
                Vector.dotProduct(lightDir, normal)), color);
        return Vector.add(ambient, diffuse);
    }

}
