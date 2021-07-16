package graph.topological_sort;

import graph.Digraph;
import graph.Vertex;
import graph.depth_first_search.Color;
import graph.depth_first_search.DepthFirstSearch;
import graph.linked_list.AdjacentList;
import graph.linked_list.Node;

import java.util.StringJoiner;

public class TopologicalSort {

    private VerticesLinkedList listOfVertices;

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" - ");

        Node actualNode = listOfVertices.getHeadNode();

        while (actualNode != null) {
            sj.add(String.format("%d:%d",
                    actualNode.getValue(),
                    actualNode.getVertex().getFinishedTimestamp()));

            actualNode = actualNode.getNextNode();
        }

        return sj.toString();
    }

    public TopologicalSort(Digraph dg) {
        DepthFirstSearch.depthFirstSearch(dg);

        listOfVertices = new VerticesLinkedList();

        for (AdjacentList adjacentList : dg.getArrayOfAdjacentLists()) {
            if (adjacentList == null) continue;

            Vertex vertex = adjacentList.getSourceVertex();

            listOfVertices.add(vertex);
        }
    }
}
