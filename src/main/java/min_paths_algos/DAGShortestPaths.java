package min_paths_algos;

import graph.Digraph;
import graph.linked_list.AdjacentList;
import graph.linked_list.Node;
import graph.topological_sort.TopologicalSort;

public class DAGShortestPaths {
    public static void apply(Digraph dg, int sourceVertexValue) {
        TopologicalSort ts = new TopologicalSort(dg);

        MinPaths.initializeSingleSource(dg, sourceVertexValue);

        Node actualNode = ts.getHeadNode();

        while (actualNode != null) {

            AdjacentList adjacentList = dg.getAdjacentListOf(actualNode.getValue());

            Node actualAdjacentNode = adjacentList.getHeadNode().getNextNode();

            while (actualAdjacentNode != null) {

                MinPaths.relax(dg, actualNode.getVertex(), actualAdjacentNode.getVertex());

                actualAdjacentNode = actualAdjacentNode.getNextNode();
            }

            actualNode = actualNode.getNextNode();
        }
    }
}
