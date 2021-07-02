package graph;

import graph.exceptions.RepeatedEdgeException;
import graph.linked_list.AdjacentList;

public class Digraph {
    private final int vertexMaxValue;
    private int arcsQuantity;

    /*
    * O objeto digrafo possui um vetor de listas de adjacência de tal forma que
    * o índice deste vetor representa um vértice do digrafo.
    *
    * Se determinado índice guarda null, aquele vértice não existe.
    *
    * Se determinado índice guarda uma lista de adjacência, mas a lista de adjacência
    * por sua não guarda nenhum valor, quer dizer que esse vértice existe e ele não possui
    * nenhum arco de saída
    *
    * Se determinado índice guarda uma lista de adjacência, essa lista de adjacência representa
    * todos os outros vértice os quais o índice em questão possui um arco conectando-os.
    * */

    private final AdjacentList[] arrayOfAdjacentLists;

    /**
     * Construtor da classe Digraph. Popula os atributos vertexMaxValue e inicializa o array de listas
     * de adjascência
     * @param vertexMaxValue o valor máximo de um vértice. Na prática, esse valor representa
     *                         o intervalo [0, vertexMaxValue] que podemos ter de índices no
     *                         array de listas de adjascências. Não representa a quantidade máxima
     *                         de vértices que o digrafo aceita
     * */
    public Digraph(int vertexMaxValue) {
        this.vertexMaxValue = vertexMaxValue;
        this.arrayOfAdjacentLists = new AdjacentList[vertexMaxValue];
    }

    /**
     * Método de inserção de um arco no digrafo.
     * @param initialVertex o vértice de saída do arco
     * @param finalVertex o vértice de entrada do arco
     * @param weight o peso do arco
     * @throws RepeatedEdgeException Caso o arco já exista, lança essa exceção
     * */
    public void insert(int initialVertex, int finalVertex, int weight) throws RepeatedEdgeException {

        if (this.arrayOfAdjacentLists[initialVertex] == null)
            this.arrayOfAdjacentLists[initialVertex] = new AdjacentList();

        else if (this.arrayOfAdjacentLists[initialVertex].hasValue(finalVertex))
            throw new RepeatedEdgeException(initialVertex, finalVertex);

        this.arrayOfAdjacentLists[initialVertex].add(finalVertex, weight);

        this.arcsQuantity++;
    }

    /**
     * Printa o digrafo na saída padrão
     * */
    public void print() {
        System.out.printf("Quantidade máxima de vértices:\t%d\nQuantidade de arcos:\t%d\n",
                this.vertexMaxValue,
                this.arcsQuantity);

        for (int vertexValue = 0; vertexValue < this.arrayOfAdjacentLists.length; vertexValue++)
            if (this.arrayOfAdjacentLists[vertexValue] != null)
                System.out.printf("%d: %s\n", vertexValue, this.arrayOfAdjacentLists[vertexValue].toString());
    }
}
