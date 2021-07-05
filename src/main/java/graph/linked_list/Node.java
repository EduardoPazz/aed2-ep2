package graph.linked_list;

import graph.Vertex;

public class Node {

    private final Vertex vertex;
    private Node nextNode;

    /**
     * O construtor da classe Node. Apenas popula os atributos
     * @param value o valor a ser armazenado no vértice atributo de Node
     * */
    public Node(int value) {
        this.vertex = new Vertex(value);
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
}
