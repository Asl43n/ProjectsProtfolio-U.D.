package cgg.a04;

import cgtools.*;

import static cgtools.Vector.white;

import cgg.*;

import static cgtools.Vector.blue;
import static cgtools.Vector.color;
import static cgtools.Vector.green;
import static cgtools.Vector.red;

public class Main {
    public static void main(String[] args) {
        final int width = 512;
        final int height = 512;

        // Erstellen der Kamera
        Lochkamera camera = new Lochkamera(Math.PI / 3, width, height);

        // Erstellen der Formen
        Shape background = new Background(color(0.6, 0.7, 1));
        Shape ground = new Disc(new Point(0.0, -0.5, 0.0),new Direction(0, 1, 0), color(0.6, 1, 0.6));
        Shape globe1 = new Sphere(new Point(-1.0, -0.25, -2.5), 0.7, red);
        Shape globe2 = new Sphere(new Point(0.0, -0.25, -2.5), 0.5, green);
        Shape globe3 = new Sphere(new Point(1.0, -0.25, -2.5), 0.7, blue);

        // Erstellen der Gruppe
        Group scene = new Group();
        scene.addShape(ground);
        scene.addShape(globe1);
        scene.addShape(globe2);
        scene.addShape(globe3);

        // Raytracer und Bild erstellen
        Raytracer tracer = new Raytracer(camera, background);
        tracer.addShape(scene);

        Image image = new Image(width, height);
        image.superSample(tracer);

        // Bild speichern
        final String filename = "doc/a44-image.png";
        image.imageWrite(filename);
        System.out.println("Wrote image: " + filename);
    }
}
