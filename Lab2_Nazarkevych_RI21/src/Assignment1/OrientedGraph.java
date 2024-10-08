package Assignment1;

public class OrientedGraph extends Graph {
    /**
     * @param nodeFrom - node from
     * @param nodeTo   - node which should be linked by nodeFrom
     */
    @Override
    public void addEdge(Node nodeFrom, Node nodeTo) throws Exception {
        if (!edges.containsKey(nodeFrom)) {
            throw new Exception("Graph doesn't contain node " + nodeFrom);
        } else if (edges.get(nodeFrom).contains(nodeTo)) {
            throw new Exception("Graph already contains edge with node from " + nodeFrom + "to " + nodeTo);
        }
        edges.get(nodeFrom).add(nodeTo);
    }
}
