package graph.exceptions;

public class NoVertexFoundException extends IllegalArgumentException {
    public NoVertexFoundException(int vertexValue) {
        super(String.format("Vértice %d não encontrado no grafo", vertexValue));
    }
}
