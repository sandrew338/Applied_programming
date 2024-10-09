package Assignment3;

public class Product {
    private final double height;
    private final double width;
    private final double depth;

    public Product(double height, double width, double depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public boolean fitsInBox(BoxOfProduct box) {
        return this.height <= box.getHeight() && this.width <= box.getWidth() && this.depth <= box.getDepth();
    }

    @Override
    public String toString() {
        return "Product{" +
                "depth=" + depth +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    public void sendToStorage(BoxOfProduct box, ContainerOfProducts container) {
        if (!fitsInBox(box)) {
            throw new IllegalArgumentException("Product doesn't fit in the box.");
        }
        box.setProduct(this);
        container.addBox(box);
    }
}
