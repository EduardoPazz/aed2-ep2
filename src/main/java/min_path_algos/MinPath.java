package min_path_algos;

import graph.Digraph;
import graph.Vertex;
import graph.exceptions.NoVertexFoundException;
import graph.exceptions.NoVertexFoundInAdjacentListException;
import graph.exceptions.NonSourceVertexException;

public class MinPath {

    public static void initializeSingleSource(Digraph dg, int source) throws NonSourceVertexException {
        dg.getSourceVertex(source).setDistance(0);
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
}