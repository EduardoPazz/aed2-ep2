package graph;
//comentario
import graph.exceptions.NoVertexFoundException;
import graph.exceptions.NoVertexFoundInAdjacentListException;
import graph.exceptions.NonSourceVertexException;
import graph.exceptions.RepeatedEdgeException;
import graph.linked_list.AdjacentList;
import graph.linked_list.Node;
import graph.linked_list.WeightedNode;

public class Digraph {
    private final int vertexMaxValue;
    private int arcsQuantity;

    /*
    * O objeto digrafo possui um vetor de listas de adjacência de tal forma que
    * o índice deste vetor representa um vértice do digrafo. Além disso, o primeiro objeto Vertex
    * de cada lista de adjacência representa o próprio vértice do índice
    *
    * Se determinado índice guarda null, aquele vértice não existe.
    *
    * Se determinado índice guarda uma lista de adjacência, essa lista de adjacência representa
    * todos os outros vértice os quais o índice em questão possui um arco conectando-os.
    *
    *
    * Se determinado índice guarda uma lista de adjacência, mas a lista de adjacência
    * por sua não guarda nenhum outro vértice além do vértice cabeça, quer dizer que esse
    * vértice existe e ele não possui nenhum arco de saída
    * */

    private final AdjacentList[] arrayOfAdjacentLists;

    /**
     * Construtor da classe Digraph. Popula os atributos vertexMaxValue e inicializa o array de listas
     * de adjascência
     * @param vertexMaxValue o valor máximo de um vértice. Na prática, esse valor representa
     *                         o intervalo [0, vertexMaxValue] que podemos ter de índices no
     *                         array de listas de adjascências.
     * */
    public Digraph(int vertexMaxValue) {
        this.vertexMaxValue = vertexMaxValue;
        this.arrayOfAdjacentLists = new AdjacentList[vertexMaxValue+1];
    }

    /**
     * Método de inserção de um arco no digrafo. Caso os vértices já existam no grafo, apenas o arco é criado
     * @param initialVertexValue o vértice de saída do arco
     * @param finalVertexValue o vértice de entrada do arco
     * @param weight o peso do arco
     * @throws RepeatedEdgeException Caso o arco já exista, lança essa exceção
     * */
    public void insert(int initialVertexValue, int finalVertexValue, int weight) throws RepeatedEdgeException,
            NoVertexFoundException {

        if (this.arrayOfAdjacentLists[initialVertexValue] == null)
            this.arrayOfAdjacentLists[initialVertexValue] = new AdjacentList(new Node(new Vertex(initialVertexValue)));

        if (this.arrayOfAdjacentLists[finalVertexValue] == null)
            this.arrayOfAdjacentLists[finalVertexValue] = new AdjacentList(new Node(new Vertex(finalVertexValue)));

        else if (this.arrayOfAdjacentLists[initialVertexValue].hasValue(finalVertexValue))
            throw new RepeatedEdgeException(initialVertexValue, finalVertexValue);

        this.arrayOfAdjacentLists[initialVertexValue].add(this.getVertex(finalVertexValue), weight);

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
     * desse vértice. Se o vértice é uma fonte, retorna-o.
     * @param source inteiro de um vértice a ser testado
     * @return o vértice fonte
     * */
    public Vertex getSourceVertex(int source) throws NonSourceVertexException {
        if ((source < 0 || source > this.vertexMaxValue)
            || (this.arrayOfAdjacentLists[source] == null)) throw new NonSourceVertexException(source);

        return this.arrayOfAdjacentLists[source].getSourceVertex();
    }

    /**
     * Getter do vetor de listas de adjacência
     * @return o vetor de listas de adjacência
     * */
    public AdjacentList[] getArrayOfAdjacentLists() {
        return this.arrayOfAdjacentLists;
    }


    /**
     * Obtem o peso entre dois vértices
     * @param initialVertex
     * @param finalVertex
     * @return um inteiro representando o peso entre os vertices
     * @throws NoVertexFoundInAdjacentListException, caso o vértice final não exista na lista de adjacência do vértice inicial
     * */
    public int getWeightBetween(Vertex initialVertex, Vertex finalVertex) throws NoVertexFoundInAdjacentListException {
        return this.arrayOfAdjacentLists[initialVertex.getValue()].getWeight(finalVertex.getValue());
    }

    /**
     * Obtem um vértice do array de listas de adjacência
     * @param vertexValue o valor do vértice a ser retornado
     * @return o vértice buscado
     * @throws NoVertexFoundException caso o vértice não exista no grafo
     * */
    public Vertex getVertex(int vertexValue) throws NoVertexFoundException {
        try { return this.arrayOfAdjacentLists[vertexValue].getSourceVertex();
        } catch (ArrayIndexOutOfBoundsException e) { throw new NoVertexFoundException(vertexValue); }
    }


    /*
    * v.p ponteiro para o vértice predecessor
    * */
}
