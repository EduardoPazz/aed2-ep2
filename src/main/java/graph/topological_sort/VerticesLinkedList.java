package graph.topological_sort;

import graph.Vertex;
import graph.linked_list.AdjacentList;
import graph.linked_list.Node;

/*
* Essa classe estender AdjacentList é um reaproveitamento porco de código
* e um mau uso de herança, eu admito, já que VerticesLinkedList não utiliza
* todos os métodos de AdjacentList. Mas como AdjacentList já implementa uma
* lista ligada de Vertex, quis reaproveitá-la
* */
public class VerticesLinkedList extends AdjacentList {

    public void add(Vertex vertex) {

        Node newNode = new Node(vertex);

        if (this.headNode == null) {
            this.headNode = newNode;
            return;
        }

        Node previousNode = null;
        Node actualNode = this.headNode;

        while ((actualNode != null)
                && (actualNode.getVertex().getFinishedTimestamp() > vertex.getFinishedTimestamp())) {

           previousNode = actualNode;
           actualNode = actualNode.getNextNode();
        }

        Node nextNode = actualNode;

        if (previousNode == null) this.headNode = newNode;
        else previousNode.setNextNode(newNode);

        newNode.setNextNode(nextNode);
    }
}
