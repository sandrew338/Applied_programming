package Assignment2;

import Assignment2.figures.flat.Circle;
import Assignment2.figures.flat.Rectangle;
import Assignment2.figures.flat.Square;
import Assignment2.figures.flat.Triangle;
import Assignment2.figures.voluminous.Cube;
import Assignment2.figures.voluminous.Pyramid;
import Assignment2.figures.voluminous.Sphere;

//трикутник, квадрат, прямокутник, куб, піраміда, коло, сфера.
public class Main {
    private static final double SIDE1 = 2;
    private static final double SIDE2 = 4;
    private static final double SIDE3 = 9;
    private static final double SIDE4 = 11;


    public static void main(String[] args) {
        Square square;
        Triangle triangle;
        Rectangle rectangle;
        Circle circe;
        Cube cube;
        Pyramid pyramid;
        Sphere sphere;
        try {
            square = new Square(SIDE1);
            triangle = new Triangle(SIDE1, SIDE1, SIDE1);
            rectangle = new Rectangle(square);
            circe = new Circle(SIDE1); // SIDE1 instead of radius
            cube = new Cube(square); // SIDE1 or square result will be the same
            sphere = new Sphere(circe); // SIDE1 instead of radius
            pyramid = new Pyramid(SIDE1, SIDE2, SIDE3, SIDE4);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        square.show();
        triangle.show();
        rectangle.show();
        circe.show();
        cube.show();
        pyramid.show();
        sphere.show();
    }
}
