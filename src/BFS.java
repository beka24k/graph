import java.util.*;

/**
 * Implementation of Breadth-First Search algorithm for a weighted graph.
 *
 * @param <V> the type of vertex in the graph
 */
public class BFS<V> implements Search<V> {
    private WeightedGraph<V> graph;

    /**
     * Constructs a BFS object with the specified weighted graph.
     *
     * @param graph the weighted graph to perform BFS on
     */
    public BFS(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public List<V> findPath(Vertex<V> source, Vertex<V> destination) {
        return null;
    }
}
