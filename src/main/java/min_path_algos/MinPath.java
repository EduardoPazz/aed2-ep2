package min_path_algos;

import graph.Digraph;
import graph.Vertex;
import graph.exceptions.NoVertexFoundException;
import graph.exceptions.NoVertexFoundInAdjacentListException;
import graph.exceptions.NonSourceVertexException;
import graph.linked_list.AdjacentList;

public class MinPath {

    public static void initializeSingleSource(Digraph dg, int source) throws NonSourceVertexException {
        Vertex sourceVertex = dg.getSourceVertex(source);
        sourceVertex.setDistance(0);
        sourceVertex.setPrevious(sourceVertex);
    }

    public static void relax(Digraph dg, int initialVertexValue, int finalVertexValue)
            throws NoVertexFoundInAdjacentListException, NoVertexFoundException {

        relax(dg, dg.getVertex(initialVertexValue), dg.getVertex(finalVertexValue));

    }
    public static void relax(Digraph dg, Vertex initialVertex, Vertex finalVertex) throws NoVertexFoundInAdjacentListException {
        int possibleNewDistance = initialVertex.getDistance() + dg.getWeightBetween(initialVertex, finalVertex);
        if (finalVertex.getDistance() > possibleNewDistance) {
            finalVertex.setDistance(possibleNewDistance);
            finalVertex.setPrevious(initialVertex);
        }
    }

    public static void printMinPathReport(Digraph dg) {
        AdjacentList[] adjacentLists = dg.getArrayOfAdjacentLists();

        for (AdjacentList adjacentList : adjacentLists) {
            if (adjacentList == null) continue;

            Vertex vertex = adjacentList.getSourceVertex();

            /*
             * Se um vértice não possui um anterior, quer dizer que ele não
             * participou dos relaxamentos dos algoritmos de caminho mínimo e sequer faz parte
             * do caminho mínimo
             * */
            if (vertex.getPreviousVertex() == null) continue;

            System.out.printf("value: %d\tprevious: %d\tdistance: %d\n",
                    vertex.getValue(),
                    vertex.getPreviousVertex().getValue(),
//                    dg.getWeightBetween(vertex.getPreviousVertex(), vertex),
                    vertex.getDistance());
        }
    }
}
