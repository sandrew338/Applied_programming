package Assignment2.figures.flat;

import Assignment2.addFunctions.Rounding;
import Assignment2.interfaces.FlatFigure;

public class Square implements FlatFigure {

    private final double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side of a square must be greater than 0");
        }
        this.side = side;
    }

    public Square(Square square) {
        this.side = square.side;
    }

    public double getSide() {
        return side;
    }


    @Override
    public double getSquare() {
        return side * side;
    }

    @Override
    public void show() {
        System.out.println("This is a square with area " + Rounding.roundNumber(getSquare()) + " cm^2.");
    }

}
