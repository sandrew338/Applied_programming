package Assignment3;

public class Product {
    private final String name;
    private final double height;
    private final double width;
    private final double depth;

    public Product(String name, double height, double width, double depth) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                "depth=" + depth +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    public double getDepth() {
        return depth;
    }

    public double getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public double getWidth() {
        return width;
    }

    //rename

}
