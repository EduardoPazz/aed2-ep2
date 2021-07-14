package min_path_algos.dijkstra;

import graph.Digraph;
import graph.exceptions.NonSourceVertexException;
import min_path_algos.MinPath;

public class Dijkstra {
    public void apply(Digraph dg, int sourceVertexValue) throws NonSourceVertexException {
        MinPath.initializeSingleSource(dg, sourceVertexValue);

    }
}
