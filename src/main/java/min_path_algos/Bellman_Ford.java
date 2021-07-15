package min_path_algos;

import graph.Digraph;
import graph.Vertex;
import graph.exceptions.NonSourceVertexException;
import graph.linked_list.AdjacentList;
import graph.linked_list.Node;
import graph.linked_list.WeightedNode;
import min_path_algos.MinPath;

public class Bellman_Ford {

    public static void BF( Digraph dg, int sourceVertexValue) throws NonSourceVertexException{

        dg.getWeightBetween();
        //initialize single source
        MinPath.initializeSingleSource(dg, sourceVertexValue);

        AdjacentList[] arrayOfAdjacentList = dg.getArrayOfAdjacentLists();

        //o algoritmo faz |V| – 1 passagens pelas arestas do grafo
        for(int i=0; i < arrayOfAdjacentList.length ;i++){

            //se a posição estiver vazia, próximo
            if (arrayOfAdjacentList[i] == null) continue;

            //iteração em cada lista de adjacencia
            for(int j=0; j < arrayOfAdjacentList.length;j++){

                //se a posição estiver vazia, próximo
                if (arrayOfAdjacentList[j] == null) continue;

                AdjacentList temp = arrayOfAdjacentList[j];
                Node sourceNode = temp.getHeadNode();
                Node endNode = sourceNode.getNextNode();

                while (endNode != null){
                     MinPath.relax(dg, sourceNode.getVertex(), endNode.getVertex() );
                     endNode = endNode.getNextNode();
                }


            }


        }
    }
}
