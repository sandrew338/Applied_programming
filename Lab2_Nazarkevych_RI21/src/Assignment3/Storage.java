package Assignment3;

import java.util.ArrayList;

public class Storage {

    private ArrayList<ContainerOfProducts> containers;

    public Storage() {
        this.containers = new ArrayList<ContainerOfProducts>();
    }

    public ArrayList<ContainerOfProducts> getContainers() {
        return containers;
    }

    public void setContainers(ArrayList<ContainerOfProducts> containers) {
        this.containers = containers;
    }

    public void addContainer(ContainerOfProducts container) {
        containers.add(container);
    }

    public void displayStorage() {
        for (int i = 0; i < containers.size(); i++) {
            ContainerOfProducts container = containers.get(i);
            int sizeOfContainer = container.getProducts().size();
            System.out.println("Container " + (i + 1) + " contains " + sizeOfContainer + " boxes.");
            for (int j = 0; j < sizeOfContainer; j++) {
                System.out.println(j + 1 + ".");

                System.out.println(container.getProducts().get(j) + " with product's size ");
                System.out.print(container.getProducts().get(j).getProduct());

                System.out.println();
            }
            System.out.println();
        }
    }
}
