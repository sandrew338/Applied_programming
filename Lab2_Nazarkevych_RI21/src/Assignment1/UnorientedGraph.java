package Assignment1;

import java.util.ArrayList;
import java.util.HashMap;

public class UnorientedGraph extends Graph {
    @Override
    public void addEdge(Node nodeFrom, Node nodeTo) throws Exception {
        if (!(edges.containsKey(nodeFrom) && edges.containsKey(nodeTo))) {
            throw new Exception("Graph doesn't contain proper node or nodes");
        } else if (edges.get(nodeFrom).contains(nodeTo)) {
            throw new Exception("Graph already contains edge with node from " + nodeFrom + "to " + nodeTo);
        }
        edges.get(nodeFrom).add(nodeTo);
        edges.get(nodeTo).add(nodeFrom);
    }
}
