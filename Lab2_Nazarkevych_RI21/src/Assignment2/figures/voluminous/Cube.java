package Assignment2.figures.voluminous;

import Assignment2.addFunctions.Rounding;
import Assignment2.interfaces.VoluminousFigure;

public class Cube implements VoluminousFigure {
    private final double side;

    public Cube(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side of a cube must be greater than 0");
        }
        this.side = side;
    }

    @Override
    public double getSurfaceArea() {
        return 6 * side * side;
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3);
    }

    @Override
    public void show() {
        System.out.println("This is a cube with area " + Rounding.roundNumber(getSurfaceArea()) +
                " cm^2 and volume " + Rounding.roundNumber(getVolume()) + " cm^3" );

    }
}
