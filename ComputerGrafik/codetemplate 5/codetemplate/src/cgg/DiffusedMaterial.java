package cgg;

import cgtools.*;

public class DiffusedMaterial implements Material {

    private final Color albedo;

    public DiffusedMaterial(Color albedo) {
        this.albedo = albedo;
    }

    @Override
    public Ray reflection(Ray incomingRay, Hit hit ) {// Berechnet die Streurichtung des einfallenden Strahls und gibt einen neuen reflektierten Strahl zurück.
        Direction scatterDirection; 
        while(true){//Es wird eine zufällige Streurichtung innerhalb einer Halbkugel um den Normalenvektor des Schnittpunkts berechnet.
            double x = -1 + Random.random() * 2;
            double y = -1 + Random.random() * 2;
            double z = -1 + Random.random() * 2;
            if((( x * x) + ( y * y) + ( z + z)) <= 1) {
                scatterDirection = Vector.direction(x, y, z);
                break;
            }

        }
        Direction d = Vector.normalize(Vector.add(hit.n(), scatterDirection));

        return new Ray ( d, Double.POSITIVE_INFINITY,0.00001, hit.x());//Die Methode gibt einen neuen Strahl zurück, der vom Schnittpunkt in die berechnete Streurichtung zeigt.
    }

    @Override
    public Color albedo() {
        return albedo; // Rückgabe der Albedo des Materials
    }

    @Override
    public Color emission() {
        return Vector.black;//Diese Methode gibt Vector.black zurück, da diffuse Materialien kein Licht emittieren.
    }

}
