package graph;

import graph.exceptions.RepeatedVertexException;
import graph.linked_list.AdjacentList;

public class Digraph {
    private final int verticesMaximumQuantity;
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

    public Digraph(int verticesQuantity) {
        this.verticesMaximumQuantity = verticesQuantity;
        this.arrayOfAdjacentLists = new AdjacentList[verticesQuantity];
    }

    public void insert(int initialVertex, int finalVertex, int weight) throws RepeatedVertexException {

        if (this.arrayOfAdjacentLists[initialVertex] == null)
            this.arrayOfAdjacentLists[initialVertex] = new AdjacentList();
        else if (this.arrayOfAdjacentLists[initialVertex].hasValue(finalVertex))
            throw new RepeatedVertexException(initialVertex, finalVertex);

        this.arrayOfAdjacentLists[initialVertex].add(finalVertex, weight);

        this.arcsQuantity++;
    }

    public void print() {
        System.out.printf("Quantidade máxima de vértices:\t%d\nQuantidade de arcos:\t%d\n",
                this.verticesMaximumQuantity,
                this.arcsQuantity);

        for (int vertexValue = 0; vertexValue < this.arrayOfAdjacentLists.length; vertexValue++) {
            if (this.arrayOfAdjacentLists[vertexValue] != null)
                System.out.printf("%d: %s\n", vertexValue, this.arrayOfAdjacentLists[vertexValue].toString());
        }
    }
}
