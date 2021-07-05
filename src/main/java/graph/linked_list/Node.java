package graph.linked_list;

import graph.Vertex;

public class Node {

    private final Vertex vertex;
    private Node nextNode;

    /**
     * O construtor da classe Node. Apenas popula os atributos
     * @param v o vértice a ser armazenado
     * */
    public Node(Vertex v) {
        this.vertex = v;
    }

    /**
     * Getter do próximo Node deste Node
     * @return o próximo Node na lista de adjacência
     * */
    public Node getNextNode() {
        return this.nextNode;
    }

    /**
     * Getter do valor armazenado no vértice desse Node
     * @return o valor inteiro
     * */
    public int getValue() {
        return this.vertex.getValue();
    }

    /**
     * Setter do próximo Node
     * @param nextNode o próximo Node a ser armazenado
     * */
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * Getter do Vertex deste Node
     * @return o Vertex
     * */
    public Vertex getVertex() {
        return this.vertex;
    }

}
