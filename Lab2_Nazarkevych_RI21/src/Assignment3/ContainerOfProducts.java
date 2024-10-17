package Assignment3;

import java.util.ArrayList;

public class ContainerOfProducts {
    private static final int MAX_CAPACITY = 5;
    private ArrayList<BoxOfProduct> products = new ArrayList<BoxOfProduct>(MAX_CAPACITY);

    public ContainerOfProducts() {
        this.products = new ArrayList<BoxOfProduct>();
    }

    public void addBox(BoxOfProduct box) {
        if(products.size() >= MAX_CAPACITY) {
            throw new ArrayIndexOutOfBoundsException("No enough place in container");
        }
        products.add(box);
    }

    public ArrayList<BoxOfProduct> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<BoxOfProduct> products) {
        this.products = products;
    }
}
