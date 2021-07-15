package min_path_algos.dijkstra;

import graph.Digraph;
import graph.Vertex;
import graph.exceptions.NonSourceVertexException;
import graph.linked_list.AdjacentList;
import graph.linked_list.Node;
import min_path_algos.MinPath;

public class Dijkstra {
    public static void apply(Digraph dg, int sourceVertexValue) throws NonSourceVertexException {

        MinPath.initializeSingleSource(dg, sourceVertexValue);

        VertexMinPriorityQueue vertexMinPriorityQueue = new VertexMinPriorityQueue(dg);

        while (vertexMinPriorityQueue.isNotEmpty()) {

            Vertex minVertex = vertexMinPriorityQueue.extractMin();

            AdjacentList adjacentList = dg.getAdjacentList(minVertex.getValue());

            Node adjacentVertexNode = adjacentList.getHeadNode().getNextNode();

            while (adjacentVertexNode != null) {

                MinPath.relax(dg, minVertex, adjacentVertexNode.getVertex());
                adjacentVertexNode = adjacentVertexNode.getNextNode();
            }

            /*
             * É preciso chamar novamente o minHeapfy pois os relaxamentos do while anterior
             * alteraram os valores das distâncias dos vértices, o que desbalanceia internamente
             * o heap. Importante salientar que o heap é um array de ponteiros para os vértices
             * */
            vertexMinPriorityQueue.minHeapfy();
        }

    }
}
