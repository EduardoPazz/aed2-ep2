package graph;

import graph.exceptions.NonSourceVertexException;

public class MinPath {

    public static void initializeSingleSource(Digraph dg, int source) throws NonSourceVertexException {
        if (!dg.hasSourceVertex(source)) throw new NonSourceVertexException(source);

//        dg.ge
    }
}
