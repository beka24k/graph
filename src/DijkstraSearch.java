import java.util.*;

/**
 * DijkstraSearch implements the Search interface using Dijkstra's algorithm to find the shortest path
 * and distances in a weighted graph.
 *
 * @param <V> the type of vertex in the graph
 */
public class DijkstraSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    /**
     * Constructs a DijkstraSearch object with the specified weighted graph.
     *
     * @param graph the weighted graph to perform Dijkstra's algorithm on
     */
    public DijkstraSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }







    @Override
    public List<V> findPath(Vertex<V> source, Vertex<V> destination) {
        return null;
    }

    private static class DijkstraNode<V> implements Comparable<DijkstraNode<V>> {
        private Vertex<V> vertex;
        private double distance;

        public DijkstraNode(Vertex<V> vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }



        @Override
        public int compareTo(DijkstraNode<V> other) {
            return Double.compare(distance, other.distance);
        }
    }
}
