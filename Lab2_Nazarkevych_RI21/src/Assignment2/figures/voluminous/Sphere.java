package Assignment2.figures.voluminous;

import Assignment2.addFunctions.Rounding;
import Assignment2.figures.flat.Circle;
import Assignment2.interfaces.VoluminousFigure;

public class Sphere extends Circle implements VoluminousFigure {

    public Sphere(Circle circle) {
        super(circle.getRadius());
    }

    public Sphere(Sphere sphere) {
        super(sphere.getRadius());
    }

    @Override
        public double getSurfaceArea() {
        return 4 * getSquare();

    }

    @Override
    public double getVolume() {
        return 4 * (Math.PI * Math.pow(getRadius(), 3))/3;
    }

    @Override
    public void show() {
        System.out.println("This is a sphere with area " + Rounding.roundNumber(getSurfaceArea()) +
                " cm^2 and volume " + Rounding.roundNumber(getVolume()) + " cm^3" );

    }

}
