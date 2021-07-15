import graph.Digraph;
import min_path_algos.MinPath;
import graph.exceptions.NoVertexFoundException;
import graph.exceptions.NoVertexFoundInAdjacentListException;
import graph.exceptions.NonSourceVertexException;
import graph.exceptions.RepeatedEdgeException;
import min_path_algos.dijkstra.VertexMinPriorityQueue;
import org.junit.Assert;
import org.junit.Test;

public class MinPathTest {

    @Test
    public void testaAInicializacaoDoVerticeFonte() throws RepeatedEdgeException, NonSourceVertexException, NoVertexFoundException {
        Digraph dg = new Digraph(10);
        dg.insert(1, 2, 5);
        dg.insert(1, 5, 5);
        dg.insert(2, 3, 6);
        dg.insert(2, 9, 6);
        dg.insert(2, 7, 6);
        dg.insert(3, 1, 1);
        dg.insert(3, 7, 1);
        dg.insert(5, 7, 1);
        dg.insert(7, 2, 1);

        MinPath.initializeSingleSource(dg, 1);

        Assert.assertEquals(0, dg.getVertex(1).getDistance());
    }

    @Test
    public void testaORelaxamento()
            throws RepeatedEdgeException, NoVertexFoundException, NonSourceVertexException, NoVertexFoundInAdjacentListException {

        Digraph dg = new Digraph(5);
        dg.insert(0, 1, 5);
        dg.insert(1, 2, 5);
        MinPath.initializeSingleSource(dg, 0);
        MinPath.relax(dg, 0, 1);
        MinPath.relax(dg, 1, 2);

        Assert.assertNull(dg.getVertex(0).getPreviousVertex());
        Assert.assertEquals(dg.getVertex(0).getDistance(), 0);
        Assert.assertEquals(dg.getVertex(1).getDistance(), 5);
        Assert.assertEquals(dg.getVertex(1).getPreviousVertex(), dg.getVertex(0));
        Assert.assertEquals(dg.getVertex(2).getDistance(), 10);
        Assert.assertEquals(dg.getVertex(2).getPreviousVertex(), dg.getVertex(1));
    }


    @Test
    public void testaAMinPriorityQueue() {
        Digraph dg = new Digraph(5);
        dg.insert(5, 2, 5);
        dg.insert(2, 1, 10);

        dg.getVertex(5).setDistance(0);
        dg.getVertex(2).setDistance(5);
        dg.getVertex(1).setDistance(15);

        VertexMinPriorityQueue minQueue = new VertexMinPriorityQueue(dg);
        System.out.println(minQueue);
        System.out.println("-------------------");
        System.out.println(minQueue.extractMin().getDistance());
        System.out.println("-------------------");
        System.out.println(minQueue);
        System.out.println("-------------------");
        System.out.println(minQueue.extractMin().getDistance());
        System.out.println("-------------------");
        System.out.println(minQueue);
    }
}
