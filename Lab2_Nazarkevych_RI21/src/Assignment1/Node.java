package Assignment1;

public class Node {
    String name;
    int value;
    public Node(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
