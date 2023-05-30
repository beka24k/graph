import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A weighted graph implementation that stores vertices and edges with associated weights.
 *
 * @param <V> the type of vertex in the graph
 */
public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Edge<V>>> list;

    /**
     * Constructs an empty weighted graph.
     */
    public WeightedGraph() {
        list = new HashMap<>();
    }

    /**
     * Represents an edge in the weighted graph.
     *
     * @param <V> the type of vertex in the graph
     */
    public class Edge<V> {
        private Vertex<V> source;
        private Vertex<V> destination;
        private double weight;

        /**
         * Constructs an edge with the specified source, destination, and weight.
         *
         * @param source      the source vertex of the edge
         * @param destination the destination vertex of the edge
         * @param weight      the weight associated with the edge
         */
        public Edge(Vertex<V> source, Vertex<V> destination, double weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        /**
         * Returns the source vertex of the edge.
         *
         * @return the source vertex
         */
        public Vertex<V> getSource() {
            return source;
        }

        /**
         * Returns the destination vertex of the edge.
         *
         * @return the destination vertex
         */
        public Vertex<V> getDestination() {
            return destination;
        }

        /**
         * Returns the weight of the edge.
         *
         * @return the weight of the edge
         */
        public double getWeight() {
            return weight;
        }
    }

    /**
     * Adds a vertex to the graph.
     *
     * @param vertex the vertex to add
     */
    public void addVertex(Vertex<V> vertex) {
        list.put(vertex, new ArrayList<>());
    }


}
