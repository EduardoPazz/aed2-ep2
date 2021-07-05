import graph.Digraph;
import graph.MinPath;
import graph.exceptions.NoVertexFoundException;
import graph.exceptions.NonSourceVertexException;
import graph.exceptions.RepeatedEdgeException;
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
}
