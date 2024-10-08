package Assignment2.figures.voluminous;

import Assignment2.addFunctions.Rounding;
import Assignment2.interfaces.VoluminousFigure;
//That's a pyramid with quadratic base
public class Pyramid implements VoluminousFigure {
    private final double heightBase;
    private final double widthBase;
    private final double heightApothem;
    private final double widthApothem;

    public Pyramid(double heightBase, double widthBase, double heightApothem, double widthApothem) {
        if (heightBase <= 0 || widthBase <= 0 || heightApothem <= 0 || widthApothem <= 0) {
            throw new IllegalArgumentException("Side of a Pyramid must be greater than 0");
        }
        this.heightBase = heightBase;
        this.widthBase = widthBase;
        this.heightApothem = heightApothem;
        this.widthApothem = widthApothem;
    }


    @Override
    public double getSurfaceArea() {
        double baseArea = heightBase * widthBase; // Area of the rectangular base
        double sideArea1 = (heightBase * heightApothem) / 2; // Area of two sides with base 'a'
        double sideArea2 = (widthBase * widthApothem) / 2; // Area of two sides with base 'b'
        return baseArea + 2 * sideArea1 + 2 * sideArea2;
    }

    @Override
    public double getVolume() {
        double heightPyramid = Math.sqrt(Math.pow(heightApothem, 2) - Math.pow(heightBase / 2.0, 2));
        return (1.0 / 3.0) * heightBase * widthBase * heightPyramid;
    }

    @Override
    public void show() {
        System.out.println("This is a pyramid with area " + Rounding.roundNumber(getSurfaceArea()) +
                " cm^2 and volume " + Rounding.roundNumber(getVolume()) + " cm^3" );

    }
}
