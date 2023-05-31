# graph
# Weighted Graph Algorithms
This Java code demonstrates the usage of graph algorithms in a weighted graph. It includes implementations of Breadth-First Search (BFS) and Dijkstra's Algorithm. It also provides examples of how to create vertices, add edges to the graph, and perform various operations on the graph.

## Usage
Create vertices using the Vertex class, providing the desired data for each vertex.

Create a weighted graph using the WeightedGraph class.

Add vertices to the graph using the addVertex method of the WeightedGraph class.

Add edges to the graph using the addEdge method of the WeightedGraph class, specifying the source vertex, destination vertex, and edge weight.

Perform breadth-first search using the BFS class. Create an instance of BFS by passing the graph to its constructor. Use the findPath method to find the shortest path between two vertices. The printBFS method can be used to print the details of the breadth-first search traversal.

Perform Dijkstra's algorithm using the DijkstraSearch class. Create an instance of DijkstraSearch by passing the graph to its constructor. Use the findPath method to find the shortest path between two vertices. The printDijkstra method can be used to print the details of the algorithm.

Access other methods such as getDegree to retrieve the degree of a vertex or getEdges to retrieve all edges in the graph.

To compile and run the code, make sure you have Java installed on your system. Use the Java compiler to compile the Main class, and then run the compiled bytecode.

## Example
The code provided in the main method demonstrates the usage of the weighted graph algorithms. It creates a graph with five vertices (A, B, C, D, and E) and adds weighted edges between them. It then performs breadth-first search and Dijkstra's algorithm to find paths between specified vertices. The code also demonstrates accessing other methods such as retrieving vertex degrees and printing graph information.
```ruby
import java.util.List;

/**
 * Main class demonstrates the usage of graph algorithms in a weighted graph.
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

```
Feel free to modify the code and experiment with different graphs and algorithms according to your needs.
