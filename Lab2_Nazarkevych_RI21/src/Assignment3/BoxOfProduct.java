package Assignment3;

public class BoxOfProduct {
    private final double height;
    private final double width;
    private final double depth;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private Product product;

    public BoxOfProduct(double depth, double height, double width) {
        this.depth = depth;
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return "BoxOfProduct{" +
                "depth=" + depth +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
