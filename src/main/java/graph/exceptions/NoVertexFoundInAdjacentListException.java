package graph.exceptions;

public class NoVertexFoundInAdjacentListException extends Exception {
    public NoVertexFoundInAdjacentListException(int initialVertex, int finalVertex) {
        super(String.format("Vértice %d não encontrado na lista de adjacência de %d", finalVertex, initialVertex));
    }
}
