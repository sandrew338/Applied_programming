package Assignment2.figures.voluminous;

import Assignment2.addFunctions.Rounding;
import Assignment2.figures.flat.Square;
import Assignment2.interfaces.VoluminousFigure;
//---
public class Cube extends Square implements VoluminousFigure {



    public Cube(Square square) {
        super(square);
    }

    public Cube(Cube cube) {
        super(cube.getSide());
    }

    @Override
    public double getSurfaceArea() {
        return 6 * getSquare()  ;
    }

    @Override
    public double getVolume() {
        return Math.pow(getSide(), 3);
    }

    @Override
    public void show() {
        System.out.println("This is a cube with area " + Rounding.roundNumber(getSurfaceArea()) +
                " cm^2 and volume " + Rounding.roundNumber(getVolume()) + " cm^3" );

    }
}
