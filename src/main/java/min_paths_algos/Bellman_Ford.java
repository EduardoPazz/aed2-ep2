package min_paths_algos;

import graph.Digraph;
import graph.exceptions.NonSourceVertexException;
import graph.linked_list.AdjacentList;
import graph.linked_list.Node;

public class Bellman_Ford {

    public static boolean BF(Digraph dg, int sourceVertexValue) throws NonSourceVertexException {

//        dg.getWeightBetween();
        //initialize single source
        MinPaths.initializeSingleSource(dg, sourceVertexValue);

        AdjacentList[] arrayOfAdjacentList = dg.getArrayOfAdjacentLists();

        //o algoritmo faz |V| – 1 passagens pelas arestas do grafo
        for (int i = 0; i < arrayOfAdjacentList.length; i++) {

            System.out.println("for de fora: " + i);
            //se a posição estiver vazia, próximo
            if (arrayOfAdjacentList[i] == null) continue;

            //iteração em cada lista de adjacencia
            for (int j = 0; j < arrayOfAdjacentList.length; j++) {
                System.out.println("for de dentro: " + j);

                //se a posição estiver vazia, próximo
                if (arrayOfAdjacentList[j] == null) continue;

                AdjacentList temp = arrayOfAdjacentList[j];
                Node sourceNode = temp.getHeadNode();
                Node endNode = sourceNode.getNextNode();

                while (endNode != null) {
                    MinPaths.relax(dg, sourceNode.getVertex(), endNode.getVertex());
                    System.out.println(endNode);
                    endNode = endNode.getNextNode();
                }
            }
        }
        //verificação de ciclo negativo

        System.out.println("passou dos for");

        //iteração em cada lista de adjacencia
        for (int i = 0; i < arrayOfAdjacentList.length; i++) {

            //se a posição estiver vazia, próximo
            if (arrayOfAdjacentList[i] == null) continue;

            AdjacentList temp = arrayOfAdjacentList[i];
            Node sourceNode = temp.getHeadNode();
            Node endNode = sourceNode.getNextNode();

            while (endNode != null) {

                if (endNode.getVertex().getDistance()
                        > (sourceNode.getVertex().getDistance()
                        + dg.getWeightBetween(sourceNode.getVertex(),
                        endNode.getVertex()))){

                    return false;
                }

                endNode = endNode.getNextNode();
            }
        }
        return true;
    }

}
