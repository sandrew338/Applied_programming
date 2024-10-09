package Assignment3;

public class Main {
    public static void main(String[] args) {

        Storage storage = new Storage();

        ContainerOfProducts container1 = new ContainerOfProducts();
        ContainerOfProducts container2 = new ContainerOfProducts();

        Product product1 = new Product(4, 4, 4);
        Product product2 = new Product(6, 6, 6);  // this one can't be contained
        Product product3 = new Product(5, 5, 5);

        BoxOfProduct box1 = new BoxOfProduct(5, 5, 5);
        BoxOfProduct box2 = new BoxOfProduct(4, 5, 5);
        BoxOfProduct box3 = new BoxOfProduct(8, 5.5, 5.9);


        try {
            product1.sendToStorage(box1, container1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            product2.sendToStorage(box2, container1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            product3.sendToStorage(box3, container1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        storage.addContainer(container1);
        storage.addContainer(container2);

        storage.displayStorage();
    }
}
