package cgg;

import cgtools.*;

public interface Material {

    // In welche Richtung wird der Strahl gestreut?
    Ray reflection(Ray ray, Hit hit);

    // Wie stark wird die Strahldichte entlang des gestreuten Strahls abgeschwächt
    // (Albedo)?
    Color albedo();

    // Welchen Wert hat die emittierte Strahldichte?
    Color emission();

}
