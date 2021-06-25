package graph.exceptions;

public class RepeatedVertexException extends Exception {
    public RepeatedVertexException(int initialVertex, int finalVertex) {
        super(String.format("Vértice %d já possui um arco de saída até %d", initialVertex, finalVertex));
    }
}

