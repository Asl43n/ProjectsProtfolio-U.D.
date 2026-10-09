package cgg;

import cgtools.*;

public class BackgroundMaterial implements Material {// Diese Klasse implementiert das Material-Interface und ist speziell für das Emissionsverhalten des Hintergrunds zuständig.
    private Color emission;

    public BackgroundMaterial(Color emission) {// nimmt eine Farbe (Color) als Argument entgegen, die die Emission des Hintergrunds darstellt. Diese Farbe wird in der privaten Variable emission gespeichert.
        this.emission = emission;
    }

    @Override
    public Color emission() {//Diese Methode gibt einfach den gespeicherten emission-Wert zurück, der die konstante Farbe des Hintergrunds repräsentiert.
        return emission;  // Gibt die emittierte Farbe zurück, da der Hintergrund Licht emittiert.
    }

    @Override
    public Color albedo() {
        return new Color(0, 0, 0);  // keine Reflexion gibt also new Color(0, 0, 0) (Schwarz) zurück, da der Hintergrund kein Licht reflektiert.
    }

    @Override
    public Ray reflection( Ray ray, Hit hit) {
        return null;  // keine Streuung, keine Richtung also gibt man null zurück, da der Hintergrund keine Reflexionen erzeugt.
    }

}
