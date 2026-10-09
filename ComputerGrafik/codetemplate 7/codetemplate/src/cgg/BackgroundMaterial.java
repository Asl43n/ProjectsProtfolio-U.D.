package cgg;

import cgtools.*;

public class BackgroundMaterial implements Material {
    private Color emission;

    public BackgroundMaterial(Color emission) {
        this.emission = emission;
    }

    @Override
    public Color emission() {
        return emission;  // gibt die emittierte Farbe zurück
    }

    @Override
    public Color albedo() {
        return new Color(0, 0, 0);  // keine Reflexion
    }

    @Override
    public Ray reflection( Ray ray, Hit hit) {
        return null;  // keine Streuung, keine Richtung
    }

}
