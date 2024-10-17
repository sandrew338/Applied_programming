package Assignment2.figures.flat;

import Assignment2.addFunctions.Rounding;
import Assignment2.interfaces.FlatFigure;

public class Circle implements FlatFigure {
    private final double radius;
    @Override
    public double getSquare() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Side of a circle must be greater than 0");
        }
        this.radius = radius;
    }

    @Override
    public void show() {
        System.out.println("This is a circle with area " + Rounding.roundNumber(getSquare()));

    }
}

