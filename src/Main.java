import java.util.List;

/**
 * Main class demonstrates the usage of graph algorithms in the weighted graph.
 */
public class Main {
    public static void main(String[] args) {
        // Create vertices
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");

        // Create weighted graph
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);
        graph.addVertex(vertexE);

        // Add edges
        graph.addEdge(vertexA, vertexB, 5.0);
        graph.addEdge(vertexA, vertexC, 2.0);
        graph.addEdge(vertexB, vertexD, 1.0);
        graph.addEdge(vertexC, vertexD, 3.0);
        graph.addEdge(vertexC, vertexE, 4.0);
        graph.addEdge(vertexD, vertexE, 6.0);

        // Perform breadth-first search
        Search<String> bfs = new BFS<>(graph);
        List<String> bfsPath = bfs.findPath(vertexA, vertexD);
        System.out.println("Breadth-First Search Path: " + bfsPath);
        ((BFS<String>) bfs).printBFS(vertexA);

        // Perform Dijkstra's algorithm
        Search<String> dijkstra = new DijkstraSearch<>(graph);
        List<String> dijkstraPath = dijkstra.findPath(vertexA, vertexD);
        System.out.println("Dijkstra's Algorithm Path: " + dijkstraPath);
        ((DijkstraSearch<String>) dijkstra).printDijkstra(vertexA);

        // Test other methods
        System.out.println("Vertex A Degree: " + vertexA.getDegree());
        System.out.println("Vertex B Degree: " + vertexB.getDegree());
        System.out.println("Vertex C Degree: " + vertexC.getDegree());
        System.out.println("Vertex D Degree: " + vertexD.getDegree());
        System.out.println("Vertex E Degree: " + vertexE.getDegree());

        System.out.println("Edges in the Graph:");
        for (WeightedGraph<String>.Edge<String> edge : graph.getEdges()) {
            System.out.println("Source: " + edge.getSource().getData());
            System.out.println("Destination: " + edge.getDestination().getData());
            System.out.println("Weight: " + edge.getWeight());
            System.out.println();
        }

        System.out.println("Graph Information:");
        graph.printGraphInformation();
    }
}
