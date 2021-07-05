import graph.Digraph;
import graph.DigraphsGenerator;
import graph.exceptions.RepeatedEdgeException;
import org.junit.Test;

public class DigraphsGeneratorTest {

    @Test
    public void testaGeracaoAleatoriaDeDigrafos() throws RepeatedEdgeException {
        Digraph dg = DigraphsGenerator.genDigraph(10, .1, 10);
        Digraph dag = DigraphsGenerator.genDAG(10, .25, 10);
        dg.print();
        dag.print();
    }
}
