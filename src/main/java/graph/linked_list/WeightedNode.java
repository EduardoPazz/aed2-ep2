package graph.linked_list;

import graph.Vertex;

public class WeightedNode extends Node {

    // O peso do arco do vértice do Node cabeça até o vértice deste Node
    private final int weight;

    /**
     * O construtor da classe Node. Apenas popula os atributos
     * @param v o vértice a ser armazenado
     * @param weight o peso do arco que tem fim nesse vértice
     * */
    public WeightedNode(Vertex v, int weight) {
        super(v);
        this.weight = weight;
    }

    /**
     * Getter do peso
     * @return o peso do arco do vértice fonte até este vértice
     * */
    public int getWeight() {
        return this.weight;
    }
}
