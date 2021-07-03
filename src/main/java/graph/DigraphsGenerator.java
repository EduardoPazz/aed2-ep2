package graph;

import graph.exceptions.RepeatedEdgeException;

import java.util.Random;

public class DigraphsGenerator {

    private interface Condition {
        boolean test(int i, int j, double probability);
    }

    /**
     * Método intermediário usado para chamar a função de geração de digrafos. Passa um teste Condition
     * mais genérico.
     * @param maxValue o máximo valor que um vértice pode alcançar
     * @param probability a probabilidade de uma combinação formar um arco
     * @param maxWeight o peso máximo que um arco pode ter
     * @throws RepeatedEdgeException
     * */
    public static Digraph genDigraph(int maxValue, double probability, int maxWeight) throws RepeatedEdgeException {
        Condition condition = (int i, int j, double p) -> (i != j) && (Math.random() <= p);
        return genGenericDigraph(maxValue, probability, maxWeight, condition);
    }

    /**
     * Método intermediário usado para chamar a função de geração de DAG. Passa um teste Condition
     * mais específico.
     * @param maxValue o máximo valor que um vértice pode alcançar
     * @param probability a probabilidade de uma combinação formar um arco
     * @param maxWeight o peso máximo que um arco pode ter
     * @throws RepeatedEdgeException
     * */
    public static Digraph genDAG(int maxValue, double probability, int maxWeight) throws RepeatedEdgeException {
        Condition condition = (int i, int j, double p) -> (i < j) && (Math.random() <= p);
        return genGenericDigraph(maxValue, probability, maxWeight, condition);
    }

    /**
     * Método que gera um digrafo e popula-o de acordo com o método anônimo condition.
     * @param maxValue o máximo valor que um vértice pode alcançar
     * @param probability a probabilidade de uma combinação formar um arco
     * @param maxWeight o peso máximo que um arco pode ter
     * @param condition método anônimo que testa se um arco irá ser adicionado
     * @throws RepeatedEdgeException
     * */
    private static Digraph genGenericDigraph(int maxValue, double probability, int maxWeight, Condition condition) throws RepeatedEdgeException {
        Digraph dg = new Digraph(maxValue);

        for (int i = 0; i < maxValue; i++)
            for (int j = 0; j < maxValue; j++)
                if (condition.test(i, j, probability)) dg.insert(i, j, new Random().nextInt(maxWeight+1));


        return dg;
    }
    
}
