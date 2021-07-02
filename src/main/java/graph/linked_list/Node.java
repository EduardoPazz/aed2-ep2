package graph.linked_list;

import graph.Vertex;

public class Node {

    private final Vertex vertex;

    // O peso do arco do vértice de origem até o vértice em questão
    private final int weight;

    private Node nextNode;

    /**
     * O construtor da classe Node. Apenas popula os atributos
     * @param value o valor a ser armazenado no vértice atributo de Node
     * @param weight o peso do arco que tem fim nesse vértice. O vertice cujo arco em questão sai é o que é
     *               representado pelo índice do array de listas de adjacências cuja posição possui a lista de adjacência
     *               que possui esse Node
     * */
    public Node(int value, int weight) {
        this.vertex = new Vertex(value);
        this.weight = weight;
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
