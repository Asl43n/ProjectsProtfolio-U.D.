package cgg;

public class Background implements Shape {

    private Material material;

    public Background(Material material) {
        this.material = material;
    }

    @Override
    public Hit intersect(Ray ray) {
        // den Hintergrund ganz nach hinten schicken
        return new Hit(Double.POSITIVE_INFINITY, ray.pointAt(Double.POSITIVE_INFINITY), ray.getDirection(), material);

    }

    @Override
    public Material material() {
        return material;
    }

}
