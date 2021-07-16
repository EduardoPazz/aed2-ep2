package graph;

import graph.depth_first_search.Color;

public class Vertex {
    private final int value;

    /*
    * Atributos utilizados apenas nos algoritmos de caminho mínimo
    * */
    private int distance;
    private Vertex previousVertex;
    private Color color;
    private int discoveredTimestamp;
    private int finishedTimestamp;

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

    /**
     * Setter da distância deste Vertex até o Vertex fonte
     * @param distance um inteiro que representa a distância
     * */
    public void setDistance(int distance) {
        this.distance = distance;
    }


    /**
     * Setter do Vertex anterior a este Vertex no algoritmo do caminho mínimo
     * @param previousVertex o Vertex anterior
     * */
    public void setPrevious(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isColor(Color color) {
        return (this.color.equals(color));
    }

    public void setDiscoveredTimestamp(int timestamp) {
        this.discoveredTimestamp = timestamp;
    }

    public void setFinishedTimestamp(int timestamp) {
        this.finishedTimestamp = timestamp;
    }
}
