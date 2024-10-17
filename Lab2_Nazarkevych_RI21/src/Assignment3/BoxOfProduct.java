package Assignment3;

public class BoxOfProduct {

    private Product product;
    private final double height;
    private final double width;
    private final double depth;

    public Product getProduct() {
        return product;
    }


    public BoxOfProduct(Product product, double depth, double height, double width) {
        this.product = product;
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
    public void sendToContainer(ContainerOfProducts container) {
        if (!fitsInBox()) {
            throw new IllegalArgumentException("Product with the name " + product.getName() + " doesn't fit in the box.");
        }
        container.addBox(this);
    }
    public boolean fitsInBox() {
        return product.getHeight() <= this.height && product.getWidth() <= this.width && product.getDepth() <= this.depth;
    }

}
