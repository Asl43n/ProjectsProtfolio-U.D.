package cgg.a03;

import cgtools.*;

public class KugelTest {
    public static void main(String[] args) {
        KugelTest test = new KugelTest();
        test.runtest();
    }

    public void runtest() {
        try {
            testChecker(new Point(0, 0, -2), 1, new Point(0, 0, 0), new Direction(0, 0, -1), 0,
                    Double.POSITIVE_INFINITY, new Point(0,0,-1), new Direction(0, 0, 1));
        } catch (AssertionError e) {
            System.out.println("Test 1 failed: " + e.getMessage());
        }

        try {
            testChecker(new Point(0, 0, -2), 1, new Point(0, 0, 0), new Direction(0, 1, -1), 0,
                    Double.POSITIVE_INFINITY, null, null);
        } catch (AssertionError e) {
            System.out.println("Test 2 failed: " + e.getMessage());
        }

        try {
            testChecker(new Point(0, -1, -2), 1, new Point(0, 0, 0), new Direction(0, 0, -1), 0,
                    Double.POSITIVE_INFINITY, new Point(0, 0, -2), new Direction(0, 0, 1));
        } catch (AssertionError e) {
            System.out.println("Test 3 failed: " + e.getMessage());
        }

        try {
            testChecker(new Point(0, 0, -2), 1, new Point(0, 0, -4), new Direction(0, 0, -1), 0,
                    Double.POSITIVE_INFINITY, null, null);
        } catch (AssertionError e) {
            System.out.println("Test 4 failed: " + e.getMessage());
        }

        try {
            testChecker(new Point(0, 0, -4), 1, new Point(0, 0, 0), new Direction(0, 0, -1), 0, 2, null, null);
        } catch (AssertionError e) {
            System.out.println("Test 5 failed: " + e.getMessage());
        }
    }

    public void testChecker(Point center, double radius, Point x, Direction d, double tMin, double tMax,
            Point treffPoint, Direction normal) {
        Kugel kugel = new Kugel(center, radius);
        Ray ray = new Ray(d, tMax, tMin, x);
        Hit hit = kugel.intersect(ray);

        if (hit == null) {
            if (treffPoint != null) {
                throw new AssertionError("Expected a hit at " + treffPoint + " but got none.");
            } else {
                System.out.println("Passed: No hit as expected.");
            }
        } else {
            Point hitPoint = hit.x();
            Direction normalDirection = hit.n();

            if (!hitPoint.equals(treffPoint)) {
                throw new AssertionError("Failed: Hit at " + hitPoint + " with normal " + normalDirection +
                        ", but expected hit at " + treffPoint + " with normal " + normal);
            } else {
                System.out.println("Passed: Hit at " + hitPoint + " with normal " + normalDirection + " as expected.");
            }
        }
    }

}
