package Assignment1;

public class OrientedGraph extends Graph {
    /**
     * @param nodeFrom - node from
     * @param nodeTo   - node which should be linked by nodeFrom
     */
    @Override
    public void addEdge(Node nodeFrom, Node nodeTo) throws Exception {
        if (!nodes.containsKey(nodeFrom)) {
            throw new Exception("Graph doesn't contain node " + nodeFrom);
        }
        if(!nodes.containsKey(nodeTo)){
            throw new Exception("Graph doesn't contain node " + nodeTo);
        }
        if (nodes.get(nodeFrom).contains(nodeTo)) {
            throw new Exception("Graph already contains edge with node from " + nodeFrom + "to " + nodeTo);
        }
        nodes.get(nodeFrom).add(nodeTo);
    }
}
