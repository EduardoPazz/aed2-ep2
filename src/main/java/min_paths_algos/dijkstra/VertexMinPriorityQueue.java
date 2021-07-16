package min_paths_algos.dijkstra;

import graph.Digraph;
import graph.Vertex;
import graph.exceptions.NoVertexFoundException;

import java.util.StringJoiner;

public class VertexMinPriorityQueue {

    private final Vertex[] verticesHeap;

    /**
     * Inicializa a fila de prioridade populando o array do heap e chamando o minHeapfy
     * @param dg digrafo a ser analizado
     * */
    public VertexMinPriorityQueue(Digraph dg) {
        this.verticesHeap = new Vertex[dg.getVertexMaxValue()+1];

        /*
        * Os vértices são primeiramente armazenados na ordem crescente de seus valores, e não suas distâncias,
        * justamente porque vai rolar um minHeapfy posteriormente. Se o vértice não existir, o array guarda uma
        * referência nula
        * */
        for (int i = 0; i < verticesHeap.length; i++) {
            try {
                verticesHeap[i] = dg.getVertex(i);
            } catch (NoVertexFoundException ignored) { }
        }

        this.minHeapfy();
    }

    /**
     * Aplica o bubbleDown para cada vértice presente no array do heap
     * */
    public void minHeapfy() {
        for (int vertexPosition = this.verticesHeap.length - 1; vertexPosition >= 0; vertexPosition--)
            bubbleDown(vertexPosition);
    }

    /**
     * Verifica se é necessário trocar um vértice com um de seus filhos e assim o faz recursivamente,
     * até que o vértice esteja na posição correta.
     * @param vertexPosition a posição do vértice a ser verificado
     * */
    private void bubbleDown(int vertexPosition) {
        int rightChildPosition = this.getRightChildPositionFrom(vertexPosition);
        int leftChildPosition = this.getLeftChildPositionFrom(vertexPosition);

        if (leftChildPosition >= this.verticesHeap.length) return;

        int lowestChildPosition = leftChildPosition;
        if ((rightChildPosition < this.verticesHeap.length)
                && (this.verticesHeap[rightChildPosition] != null)
                && ((this.verticesHeap[leftChildPosition] == null)
                    || (this.verticesHeap[leftChildPosition].getDistance()
                        > this.verticesHeap[rightChildPosition].getDistance())))

            lowestChildPosition = rightChildPosition;

        if (this.verticesHeap[lowestChildPosition] == null) return;

        if ((this.verticesHeap[vertexPosition] == null)
                || (this.verticesHeap[vertexPosition].getDistance()
                        > this.verticesHeap[lowestChildPosition].getDistance())) {

            this.swapVertices(vertexPosition, lowestChildPosition);

            this.bubbleDown(lowestChildPosition);
        }
    }

    /**
     * Troca os valores dos vértices A e B no heap nas posições passadas como parâmetro
     * @param vertexAPosition a posição do vértice A
     * @param vertexBPosition a posição do vértice B
     * */
    private void swapVertices(int vertexAPosition, int vertexBPosition) {
        Vertex aux = this.verticesHeap[vertexAPosition];
        this.verticesHeap[vertexAPosition] = this.verticesHeap[vertexBPosition];
        this.verticesHeap[vertexBPosition] = aux;
    }

    /**
     * Obtém a posição do filho esquerdo de um vértice conforme a fórmula
     * (p * 2) + 1
     * @param vertexPosition a posição do vértice pai
     * */
    private int getRightChildPositionFrom(int vertexPosition) {
        return (vertexPosition * 2) + 2;
    }

    /**
     * Obtém a posição do filho direito de um vértice conforme a fórmula
     * (p * 2) + 2
     * @param vertexPosition a posição do vértice pai
     * */
    private int getLeftChildPositionFrom(int vertexPosition) {
        return (vertexPosition * 2) + 1;
    }

    /**
     * Remove e retorna o vértice com menor caminho atualmente presente no heap. Para manter a integridade
     * do heap, este método joga o último vértice na primeira posição e aplica o bubbleDown nele a partir da
     * primeira posição
     * @return o vértice de menor distância
     * */
    public Vertex extractMin() {
        int firstPosition = 0;
        int lastPosition = this.verticesHeap.length - 1;

        Vertex minVertex = this.verticesHeap[firstPosition];

        // Joga o último vértice na primeira posição
        this.verticesHeap[firstPosition] = this.verticesHeap[lastPosition];
        this.verticesHeap[lastPosition] = null;

        // Corrige o heap
        this.bubbleDown(firstPosition);

        return minVertex;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");

        for (int i = 0; i < this.verticesHeap.length; i++) {
            Vertex v = this.verticesHeap[i];
            String message = v != null
                    ? String.format("indice: %d\tvertice: %d\tdistancia: %d",
                        i, v.getValue(), v.getDistance())
                    : String.format("indice: %d\tnull", i);

            sj.add(message);
        }

        return sj.toString();
    }

    public boolean isNotEmpty() {
        int firstPosition = 0;
        return (this.verticesHeap[firstPosition] != null);
    }
}
