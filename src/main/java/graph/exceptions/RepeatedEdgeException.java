package graph.exceptions;

public class RepeatedEdgeException extends IllegalArgumentException {

    /**
     * Construtor desta classe de exceção. Usa os parâmetros para formatar uma mensagem mais explicativa
     * @param initialVertex o vértice de sáida do arco
     * @param finalVertex o vértice de chegada do arco que já existia
     * */
    public RepeatedEdgeException(int initialVertex, int finalVertex) {
        super(String.format("Vértice %d já possui um arco de saída até %d", initialVertex, finalVertex));
    }
}

