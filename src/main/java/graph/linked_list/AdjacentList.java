package graph.linked_list;

import java.util.StringJoiner;

public class AdjacentList {
    private Node headNode;

    public AdjacentList(int initialVertex, int finalVertex, int weight) {
        this.headNode = new Node(initialVertex);
        this.headNode.setNextNode(new WeightedNode(finalVertex, weight));
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
     * @param value o valor do vértice
     * @param weight o peso do arco
     * */
    public void add(int value, int weight) {
        WeightedNode newNode = new WeightedNode(value, weight);

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
}
