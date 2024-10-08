package Assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Graph {
    protected HashMap<Node, ArrayList<Node>> edges;

    public Graph() {
        this.edges = new HashMap<>();
    }

    public void addNode(Node node)
    {
        edges.putIfAbsent(node, new ArrayList<>());
    }
    public abstract void addEdge(Node from, Node to) throws Exception;

    @Override
    public String toString() {
        return "Graph{" +
                edges +
                '}';
    }
    //
    public void display()
    {
        for (Map.Entry<Node, ArrayList<Node>> entry : edges.entrySet())
        {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
