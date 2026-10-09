/** @author chatGPT mit den Kommentare */
package cgg;

import cgtools.*;

public class Image {

    // Array zur Speicherung der Bilddaten (RGB-Werte für jeden Pixel)
    private double[] daten;
    // Breite des Bildes
    private int width;
    // Höhe des Bildes
    private int height;
    // Gammawert für die Gamma-Korrektur (Standardwert für Monitore ist 2.2)
    private double gamma = 2.2;

    // Konstruktor zur Initialisierung der Bildbreite, -höhe und des Datenarrays
    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.daten = new double[width * height * 3];
    }

    // Methode zum Setzen der Farbe eines Pixels an den Koordinaten (x, y)
    public void setPixel(int x, int y, Color color) {
        int index = (y * width + x) * 3;
        daten[index] = color.r();
        daten[index + 1] = color.g();
        daten[index + 2] = color.b();
    }

    // Methode zur Anwendung der Gamma-Korrektur auf einen Farbwert
    public double gammakorrektion(double i) {
        return Math.pow(i, 1 / gamma);
    }

    // Methode zur Super-Sampling-Anti-Aliasing (SSAA)
    // Übernimmt einen Sampler als Quelle für die Farbinformationen
    public void superSample(Sampler source) {
        int n = 2; // Anzahl der Subpixel pro Pixel (n x n)
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color vorFarbe = new Color(0, 0, 0); // Initialfarbe
                for (int xi = 0; xi < n; xi++) {
                    for (int yi = 0; yi < n; yi++) {
                        double rx = Random.random(); // Zufällige Verschiebung in x-Richtung
                        double ry = Random.random(); // Zufällige Verschiebung in y-Richtung
                        double xs = x + (xi + rx) / n; // Subpixel x-Koordinate
                        double ys = y + (yi + ry) / n; // Subpixel y-Koordinate
                        Color nebenColor = source.getColor(xs, ys); // Farbe des Subpixels
                        // Mittelwertbildung der Subpixel-Farben
                        vorFarbe = new Color(
                                vorFarbe.r() + nebenColor.r() / (n * n),
                                vorFarbe.g() + nebenColor.g() / (n * n),
                                vorFarbe.b() + nebenColor.b() / (n * n));
                    }
                }
                // Anwendung der Gamma-Korrektur auf die gemittelte Farbe
                Color nachColor = new Color(
                        gammakorrektion(vorFarbe.r()),
                        gammakorrektion(vorFarbe.g()),
                        gammakorrektion(vorFarbe.b()));
                // Setzen der korrigierten Farbe für das Pixel
                setPixel(x, y, nachColor);
            }
        }
    }

    // Methode zum Schreiben des Bildes in eine Datei
    public void imageWrite(String filename) {
        ImageWriter.write(filename, daten, width, height);
    }
}
