package min_path_algos.dijkstra;

import graph.Digraph;
import graph.Vertex;
import graph.exceptions.NoVertexFoundException;

import java.util.Arrays;
import java.util.StringJoiner;

public class VertexMinPriorityQueue {

    private static class NoRightChildException extends RuntimeException {}
    private static class NoLeftChildException extends RuntimeException {}


    private Vertex[] verticesHeap;

    /**
     * Inicializa a fila de prioridade populando o heap e chamando o minHeapfy
     * @param dg digrafo a ser analizado
     * */
    public VertexMinPriorityQueue(Digraph dg) {
        this.verticesHeap = new Vertex[dg.getVertexMaxValue()+1];

        /*
        * Os vértices são primeiramente armazenados na ordem crescente de seus valores, e não seus pesos,
        * justamente porque vai rolar um minHeapfy posteriormente
        * */
        for (int i = 0; i < verticesHeap.length; i++) {
            try {
                verticesHeap[i] = dg.getVertex(i);
            } catch (NoVertexFoundException ignored) { }
        }

        this.minHeapfy();
    }

    private void minHeapfy() {
        for (int vertexPosition = this.verticesHeap.length - 1; vertexPosition >= 0; vertexPosition--) {
            if (this.verticesHeap[vertexPosition] == null) continue;

            int rightChildPosition = this.getRightChildPositionFrom(vertexPosition);
            int leftChildPosition = this.getLeftChildPositionFrom(vertexPosition);

            if ((leftChildPosition >= this.verticesHeap.length)
                    || (this.verticesHeap[leftChildPosition] == null))
                continue;

            int lowestChildPosition = leftChildPosition;
            if ((rightChildPosition < this.verticesHeap.length)
                    && (this.verticesHeap[rightChildPosition] != null)
                    && (this.verticesHeap[leftChildPosition].getDistance()
                        > this.verticesHeap[rightChildPosition].getDistance()))
                lowestChildPosition = rightChildPosition;

            if (this.verticesHeap[vertexPosition].getDistance() > this.verticesHeap[lowestChildPosition].getDistance())
                this.swapVertices(vertexPosition, lowestChildPosition);
        }
    }

    private void swapVertices(int vertexAPosition, int vertexBPosition) {
        Vertex aux = this.verticesHeap[vertexAPosition];
        this.verticesHeap[vertexAPosition] = this.verticesHeap[vertexBPosition];
        this.verticesHeap[vertexBPosition] = aux;
    }

    private int getRightChildPositionFrom(int nodePosition) {
        return (nodePosition * 2) + 2;
    }

    private int getLeftChildPositionFrom(int nodePosition) {
        return (nodePosition * 2) + 1;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");

        for (int i = 0; i < this.verticesHeap.length; i++) {
            Vertex v = this.verticesHeap[i];
            sj.add(String.format("indice: %d\tvertice: %d\tdistancia: %d",
                    i,
                    v.getValue(),
                    v.getDistance()
                    ));
        }

        return sj.toString();
    }
}
