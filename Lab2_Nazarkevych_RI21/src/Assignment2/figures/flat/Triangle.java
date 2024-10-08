package Assignment2.figures.flat;
import Assignment2.addFunctions.Rounding;
import Assignment2.interfaces.FlatFigure;

public class Triangle implements FlatFigure {

    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) throws Exception {
        if(isTriangleExist(a, b, c))
        {
            if (a <= 0 || b <= 0 || c <= 0) {
                throw new IllegalArgumentException("Side of a triangle must be greater than 0");
            }
            this.a = a;
            this.b = b;
            this.c = c;
        }
        else {
            throw new Exception("Invalid triangle");
        }
    }

    @Override
    public double getSquare() {
        double s = (a + b + c) / 2;
         double result = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return result;
    }

    @Override
    public void show() {
        System.out.println("This is a triangle with area " + Rounding.roundNumber(getSquare()) + " cm^2.");
    }

    private boolean isTriangleExist (double a, double b, double c)
    {
        return a + b > c && a + c > b && b + c > a;
    }
}
