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

    /**
     * Performs Dijkstra's algorithm to find the shortest distances from the start vertex to all other vertices in the graph.
     *
     * @param startVertex the start vertex
     * @return a map containing the vertices as keys and their respective shortest distances from the start vertex as values
     */
    public Map<Vertex<V>, Double> dijkstraSearch(Vertex<V> startVertex) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        PriorityQueue<DijkstraNode<V>> priorityQueue = new PriorityQueue<>();

        // Initialize distances to infinity for all vertices except the start vertex
        for (Vertex<V> vertex : graph.getVertices()) {
            if (vertex.equals(startVertex)) {
                distances.put(vertex, 0.0);
            } else {
                distances.put(vertex, Double.POSITIVE_INFINITY);
            }
        }

        priorityQueue.offer(new DijkstraNode<>(startVertex, 0.0));

        while (!priorityQueue.isEmpty()) {
            DijkstraNode<V> currentNode = priorityQueue.poll();
            Vertex<V> currentVertex = currentNode.getVertex();
            double currentDistance = currentNode.getDistance();

            // Skip if the current distance is greater than the known distance
            if (currentDistance > distances.get(currentVertex)) {
                continue;
            }

            List<WeightedGraph<V>.Edge<V>> edges = graph.getEdge(currentVertex);
            for (WeightedGraph<V>.Edge<V> edge : edges) {
                Vertex<V> neighborVertex = edge.getDestination();
                double edgeWeight = edge.getWeight();
                double distanceThroughCurrent = currentDistance + edgeWeight;

                // Update the distance if it is shorter than the current known distance
                if (distanceThroughCurrent < distances.get(neighborVertex)) {
                    distances.put(neighborVertex, distanceThroughCurrent);
                    priorityQueue.offer(new DijkstraNode<>(neighborVertex, distanceThroughCurrent));
                }
            }
        }

        return distances;
    }

    /**
     * Prints the results of Dijkstra's algorithm, showing the shortest distances from the start vertex to all other vertices.
     *
     * @param startVertex the start vertex
     */
    public void printDijkstra(Vertex<V> startVertex) {
        Map<Vertex<V>, Double> distances = dijkstraSearch(startVertex);

        System.out.println("Dijkstra's Algorithm Results:");
        for (Vertex<V> vertex : distances.keySet()) {
            Double distance = distances.get(vertex);
            String distanceString = (distance == Double.POSITIVE_INFINITY) ? "Infinity" : String.valueOf(distance);
            System.out.println("Vertex: " + vertex.getData() + ", Distance: " + distanceString);
        }
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

        public Vertex<V> getVertex() {
            return vertex;
        }

        public double getDistance() {
            return distance;
        }

        @Override
        public int compareTo(DijkstraNode<V> other) {
            return Double.compare(distance, other.distance);
        }
    }
}
