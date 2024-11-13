package Assignment3;

public class Main {
    public static void main(String[] args) {

        Storage storage = new Storage();

        ContainerOfProducts container1 = new ContainerOfProducts();
        ContainerOfProducts container2 = new ContainerOfProducts();

        Product product1 = new Product("sweets",4, 4, 4);
        Product product2 = new Product("notebooks",6, 6, 6);  // this one can't be contained
        Product product3 = new Product("plates",5, 5, 5);

        BoxOfProduct box1 = new BoxOfProduct(product1, 5, 5, 5);
        BoxOfProduct box2 = new BoxOfProduct(product2, 4, 5, 5);
        BoxOfProduct box3 = new BoxOfProduct(product3, 8, 5.5, 5.9);


        try {
            box1.sendToContainer(container1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            box2.sendToContainer(container1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            box3.sendToContainer(container1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        storage.addContainer(container1);
        storage.addContainer(container2);

        storage.displayStorage();
    }
}
