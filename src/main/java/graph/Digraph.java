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
            this.arrayOfAdjacentLists[initialVertex] = new AdjacentList(initialVertex, finalVertex, weight);

        else if (this.arrayOfAdjacentLists[initialVertex].hasValue(finalVertex))
            throw new RepeatedEdgeException(initialVertex, finalVertex);

        else this.arrayOfAdjacentLists[initialVertex].add(finalVertex, weight);

        this.arcsQuantity++;
    }

    /**
     * Printa o digrafo na saída padrão
     * */
    public void print() {
        System.out.printf("Quantidade máxima de vértices:\t%d\nQuantidade de arcos:\t%d\n",
                this.vertexMaxValue,
                this.arcsQuantity);

        for (AdjacentList adjacentList : this.arrayOfAdjacentLists)
            if (adjacentList != null) System.out.println(adjacentList.toString());
    }

    /**
     * Verifica se o inteiro passado como parâmetro é de um vértice fonte, isto é, se há algum arco
     * que sai desse vértice. A lógica é a seguinte: um vértice pode existir no grafo mas não ser um
     * índice do array de listas de adjacência. Isso implicaria que não há nenhum arco que sai
     * desse vértice
     * @param source inteiro de um vértice a ser testado
     * @return um boolean representado se o inteiro é de um vértice fonte ou não
     * */
    public boolean hasSourceVertex(int source) {
        return (source >= 0 && source <= this.vertexMaxValue)
            && (this.arrayOfAdjacentLists[source] != null);
    }


    /*
    * v.p ponteiro para o vértice predecessor
    * */
}
