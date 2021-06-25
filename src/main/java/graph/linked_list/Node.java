package graph.linked_list;

import graph.Vertex;

public class Node {

    private final Vertex vertex;

    // O peso do arco do vértice de origem até o vértice em questão
    private final int weight;

    private Node nextNode;

    public Node(int value, int weight) {
        this.vertex = new Vertex(value);
        this.weight = weight;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public int getValue() {
        return this.vertex.getValue();
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
