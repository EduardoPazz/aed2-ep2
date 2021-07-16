import graph.Digraph;
import graph.topological_sort.TopologicalSort;
import org.junit.Test;

public class TopologicalSortTest {

    @Test
    public void testaListaLigada() {
        Digraph dg = new Digraph(5);

        dg.insert(1, 2, 1);
        dg.insert(1, 3, 1);
        dg.insert(2, 3, 1);
        dg.insert(3, 1, 1);

        TopologicalSort ts = new TopologicalSort(dg);

        System.out.println(ts);
    }
}
