package graph.linked_list;

import graph.Vertex;
import graph.exceptions.NoVertexFoundInAdjacentListException;

import java.util.StringJoiner;

public class AdjacentList {
    private final Node headNode;

    /**
     * Construtor que aceita dois vértices de uma vez só
     * @param initialVertexNode valor do vértice cabeça
     * @param finalVertexNode valor do vértice seguinte
     * */
    public AdjacentList(Node initialVertexNode, WeightedNode finalVertexNode) {
        this.headNode = initialVertexNode;
        this.headNode.setNextNode(finalVertexNode);
    }

    /**
     * Construtor da lista de adjacência
     * @param headNode o nó a ser armazenado
     * */
    public AdjacentList(Node headNode) {
        this.headNode = headNode;
    }

    /**
     * Checa se a lista em questão já possui um elemento
     * @param searchedVertex valor buscado
     * @return um boolean representando a existência ou não do valor na lista
    * */
    public boolean hasValue(int searchedVertex) {
        Node actualNode = this.headNode;
        while (actualNode != null) {
            if (actualNode.getValue() == searchedVertex) return true;
            actualNode = actualNode.getNextNode();
        }
        return false;
    }

    /**
     * Método que adiciona um vértice na lista de adjacência
     * @param vertexValue o valor do vértice
     * @param weight o peso do arco */
    public void add(Vertex vertexValue, int weight) {
        WeightedNode newNode = new WeightedNode(vertexValue, weight);

        Node lastNode = this.headNode;
        while (lastNode.getNextNode() != null) lastNode = lastNode.getNextNode();
        lastNode.setNextNode(newNode);
    }

    /**
     * Sobreescritura do método toString para facilitar o print do digrafo
     * */
    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" - ", "", "");
        Node actualNode = this.headNode.getNextNode();
        while (actualNode != null) {
            sj.add(String.valueOf(actualNode.getValue()));
            actualNode = actualNode.getNextNode();
        }
        return String.format("%d: %s", this.headNode.getValue(), sj.toString());
    }

    /**
     * Getter do Vertex do Node cabeça desta lista de adjascência
     * @return o Vertex do Node cabeça
     * */
    public Vertex getSourceVertex() {
        return this.headNode.getVertex();
    }

    /**
     * Método que busca o peso do arco do vértice fonte até o vértice detentor do valor passado
     * como parâmetro
     * @param finalVertexValue o valor inteiro do vértice de entrada do arco em questão
     * @return o peso do arco
     * @throws NoVertexFoundInAdjacentListException caso o vértice não exista nesta lista de adjacência
     * */
    public int getWeight(int finalVertexValue) throws NoVertexFoundInAdjacentListException {
        WeightedNode actualNode = (WeightedNode) this.headNode.getNextNode();
        while (actualNode != null) {
            if (actualNode.getValue() == finalVertexValue)
                return actualNode.getWeight();

            actualNode = (WeightedNode) actualNode.getNextNode();
        }

        throw new NoVertexFoundInAdjacentListException(this.headNode.getValue(), finalVertexValue);
    }
}
