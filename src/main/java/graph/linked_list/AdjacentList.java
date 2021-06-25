package graph.linked_list;

import java.util.StringJoiner;

public class AdjacentList {
    private Node headNode;

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

    public void add(int value, int weight) {
        Node newNode = new Node(value, weight);


        if (this.headNode == null) this.headNode = newNode;
        else {
            Node lastNode = this.headNode;
            while (lastNode.getNextNode() != null) lastNode = lastNode.getNextNode();
            lastNode.setNextNode(newNode);
        }
    }


    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" - ", "", "");
        Node actualNode = this.headNode;
        while (actualNode != null) {
            sj.add(String.valueOf(actualNode.getValue()));
            actualNode = actualNode.getNextNode();
        }
        return sj.toString();
    }
}
