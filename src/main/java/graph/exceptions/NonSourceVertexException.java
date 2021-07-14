package graph.exceptions;

import graph.Vertex;

public class NonSourceVertexException extends IllegalArgumentException {
    public NonSourceVertexException(int source) {
        super(String.format("Vértice %d não é origem de nenhum arco conhecido", source));
    }
}
