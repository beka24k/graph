import java.util.HashMap;
import java.util.Map;

/**
 * Represents a vertex in a graph.
 *
 * @param <V> the type of data stored in the vertex
 */
public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjVertex;

    /**
     * Constructs a vertex with the specified data.
     *
     * @param data the data associated with the vertex
     */
    public Vertex(V data) {
        this.data = data;
        this.adjVertex = new HashMap<>();
    }

    /**
     * Returns the data associated with the vertex.
     *
     * @return the data of the vertex
     */
    public V getData() {
        return data;
    }

    /**
     * Adds an adjacent vertex with the specified weight.
     *
     * @param destination the adjacent vertex
     * @param weight      the weight of the edge to the adjacent vertex
     */
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjVertex.put(destination, weight);
    }

    /**
     * Returns a map of adjacent vertices and their corresponding weights.
     *
     * @return a map of adjacent vertices and weights
     */
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjVertex;
    }

    /**
     * Removes the specified adjacent vertex.
     *
     * @param vertex the adjacent vertex to remove
     */
    public void removeAdjacentVertex(Vertex<V> vertex) {
        validateVertex(vertex);
        adjVertex.remove(vertex);
    }


    /**
     * Validates if the specified vertex is adjacent to this vertex.
     *
     * @param vertex the vertex to validate
     * @throws IllegalArgumentException if the vertex is not adjacent to this vertex
     */
    private void validateVertex(Vertex<V> vertex) {
        if (!adjVertex.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex + " is out of the range");
        }
    }

    /**
     * Clears all the adjacent vertices of the vertex.
     */
    public void clearAdjacentVertices() {
        adjVertex.clear();
    }


}
