package graph.linked_list;

import graph.Vertex;

public class WeightedNode extends Node {

    // O peso do arco do vértice do Node cabeça até o vértice deste Node
    private final int weight;

    /**
     * O construtor da classe Node. Apenas popula os atributos
     * @param value o valor a ser armazenado no vértice atributo de Node
     * @param weight o peso do arco que tem fim nesse vértice
     * */
    public WeightedNode(int value, int weight) {
        super(value);
        this.weight = weight;
    }
}
