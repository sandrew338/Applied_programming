package Assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Graph {
    protected Map<Node, ArrayList<Node>> nodes;

    public Graph() {
        this.nodes = new HashMap<>();
    }

    public void addNode(Node node)
    {
        nodes.putIfAbsent(node, new ArrayList<>());
    }
    public abstract void addEdge(Node from, Node to) throws Exception;

    @Override
    public String toString() {
        return "Graph{" +
                nodes +
                '}';
    }
    //
    public void display()
    {
        for (Map.Entry<Node, ArrayList<Node>> entry : nodes.entrySet())
        {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
