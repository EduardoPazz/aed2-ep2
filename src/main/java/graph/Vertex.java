package graph;

public class Vertex {
    private final int value;

    /*
    * Atributos utilizados apenas nos algoritmos de caminho mínimo
    * */
    private int distance;
    private Vertex previousVertex;

    /**
     * Construtor de um Vertex. Apenas popula o atributo value
     * @param value valor a ser armazenado
     * */
    public Vertex(int value) {
        this.value = value;
        this.distance = Integer.MAX_VALUE;
    }

    /**
     * Getter do valor armazenado no vértice
     * @return valor armazenad no vértice
     * */
    public int getValue() {
        return this.value;
    }

    /**
     * Getter da distância até o vértice fonte de um caminho mínino
     * @return distância com base no peso dos arcos até este vértice
     * */
    public int getDistance() {
        return this.distance;
    }
    /**
     * Getter do vértice anterior no caminho mínimo
     * @return vértice anterior
     * */
    public Vertex getPreviousVertex() {
        return this.previousVertex;
    }
}
