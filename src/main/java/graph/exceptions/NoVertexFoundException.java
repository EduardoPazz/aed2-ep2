package graph.exceptions;

public class NoVertexFoundException extends Exception {
    public NoVertexFoundException(int vertexValue) {
        super(String.format("Vértice %d não encontrado no grafo", vertexValue));
    }
}
