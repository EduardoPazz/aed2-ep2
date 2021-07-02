package graph;

public class Vertex {
    private final int value;

    /**
     * Construtor de um Vertex. Apenas popula o atributo value
     * @param value valor a ser armazenado
     * */
    public Vertex(int value) {
        this.value = value;
    }

    /**
     * Getter do valor armazenado no vértice
     * @return valor armazenad no vértice
     * */
    public int getValue() {
        return this.value;
    }

}
