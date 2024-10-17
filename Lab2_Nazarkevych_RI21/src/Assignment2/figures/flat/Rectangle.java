package Assignment2.figures.flat;

import Assignment2.addFunctions.Rounding;
import Assignment2.interfaces.FlatFigure;

public class Rectangle implements FlatFigure {
    private final double width;
    private final double height;

    public Rectangle(double height, double width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Side of a rectangle must be greater than 0");
        }
        this.height = height;
        this.width = width;
    }

    public Rectangle(Square square) {
        this.height = square.getSide();
        this.width = square.getSide();
    }

    @Override
    public double getSquare() {
        return width * height;
    }


    @Override
    public void show() {
        System.out.println("This is a rectangle with area " + Rounding.roundNumber(getSquare()) + " cm^2.");
    }

}
