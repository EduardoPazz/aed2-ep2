import graph.Digraph;
import graph.exceptions.RepeatedVertexException;
import org.junit.Test;

public class DigraphTest {

    @Test
    public void testaInsercaoNoDigrafo() throws Exception {
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
        dg.print();
    }

    @Test(expected = RepeatedVertexException.class)
    public void testaInsercaoRepetidaNoDigrafo() throws Exception {
        Digraph dg = new Digraph(10);
        dg.insert(0, 1, 0);
        dg.insert(0, 1, 0);
    }
}
