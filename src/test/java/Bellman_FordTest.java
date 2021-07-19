import graph.Digraph;
import min_paths_algos.Bellman_Ford;
import min_paths_algos.MinPaths;
import org.junit.Test;

public class Bellman_FordTest {

    @Test
    public void testaBellmanFord() {
        Digraph dg = new Digraph(5);
        /*
         * s 0
         * t 1
         * x 2
         * y 3
         * z 4
         * */

        dg.insert(0, 1, 6);
        dg.insert(0, 3, 7);
        dg.insert(1, 2, 5);
        dg.insert(1, 3, 8);
        dg.insert(1, 4, -4);
        dg.insert(2, 1, -2);
        dg.insert(3, 2, -3);
        dg.insert(3, 4, 9);
        dg.insert(4, 2, 7);

        Bellman_Ford.BF(dg, 0);
        dg.print();
        MinPaths.printMinPathReport(dg);
    }
}
