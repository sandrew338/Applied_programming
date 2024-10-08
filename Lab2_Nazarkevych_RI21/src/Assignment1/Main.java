package Assignment1;

/*
That's a program that improvises drawing graphs

To see the result:
First, You need to some nodes
Second, Add edges in try catch
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Node node1 = new Node("A", 1);
        Node node2 = new Node("B", 2);
        Node node3 = new Node("C", 3);

        Graph graph = new OrientedGraph();

        try{
            graph.addNode(node1);
            graph.addNode(node2);
            graph.addNode(node3);
            graph.addEdge(node1, node2);
            graph.addEdge(node2, node3);

        }
        catch(Exception e){
            System.out.println(e);
        }

        //System.out.println(graph);
        graph.display();
    }
}