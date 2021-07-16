package graph.depth_first_search;

import graph.Digraph;
import graph.Vertex;
import graph.linked_list.AdjacentList;
import graph.linked_list.Node;

public class DepthFirstSearch {

    private static int timestamp;

    public void depthFirstSearch(Digraph dg) {
        for (AdjacentList adjacentList : dg.getArrayOfAdjacentLists()) {
            if (adjacentList == null) continue;

            Vertex vertex = adjacentList.getSourceVertex();
            vertex.setColor(Color.WHITE);
            vertex.setPrevious(null);
            timestamp = 0;
        }

        for (AdjacentList adjacentList : dg.getArrayOfAdjacentLists()) {
            if (adjacentList == null) continue;

            Vertex vertex = adjacentList.getSourceVertex();

            if (vertex.isColor(Color.WHITE)) depthFirstSearchVisit(dg, vertex);
        }
    }

    private void depthFirstSearchVisit(Digraph dg, Vertex vertex) {
        vertex.setDiscoveredTimestamp(++timestamp);
        vertex.setColor(Color.GRAY);

        AdjacentList adjacentList = dg.getAdjacentList(vertex.getValue());

        Node adjacentNode = adjacentList.getHeadNode().getNextNode();
        while (adjacentNode != null) {
            Vertex adjacentVertex = adjacentNode.getVertex();

            if (adjacentVertex.isColor(Color.WHITE)) {
                adjacentVertex.setPrevious(vertex);
                depthFirstSearchVisit(dg, adjacentVertex);
            }

            adjacentNode = adjacentNode.getNextNode();
        }

        vertex.setColor(Color.BLACK);
        vertex.setFinishedTimestamp(++timestamp);
    }
}
