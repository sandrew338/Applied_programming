package Assignment2.figures.voluminous;

import Assignment2.addFunctions.Rounding;
import Assignment2.figures.flat.Circle;
import Assignment2.interfaces.VoluminousFigure;

public class Sphere implements VoluminousFigure {
    private final double radius;

    public Sphere(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Side of a sphere must be greater than 0");
        }
        this.radius = radius;
    }

    public Sphere(Circle circle) {
        this.radius = circle.getRadius();
    }

    @Override
        public double getSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);

    }

    @Override
    public double getVolume() {
        return (Math.PI * Math.pow(radius, 3))/4;
    }

    @Override
    public void show() {
        System.out.println("This is a sphere with area " + Rounding.roundNumber(getSurfaceArea()) +
                " cm^2 and volume " + Rounding.roundNumber(getVolume()) + " cm^3" );

    }

}
