import java.util.*;
public class MainFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Graph graph = new Graph();

        System.out.println("enter the number of edges in a graph");

        int edges = scanner.nextInt();
        scanner.nextLine();

        System.out.println("enter the edges in the format 'from to weight':");

        for(int i = 0;i<edges;i++){
            String[] edgeInput = scanner.nextLine().split(" ");
            String from = edgeInput[0];
            String to = edgeInput[1];
            int weight = Integer.parseInt(edgeInput[2]);
            graph.addEdge(from, to, weight);
        }

        System.out.println("Graph representation (Adjacency List): ");
        for(Map.Entry<String, List<Edge>> entry: graph.getAdjacencyList().entrySet()){
            System.out.println(entry.getKey() + "-> ");
            for(Edge edge: entry.getValue()){
                System.out.print("("+edge.getDestination()+", "+edge.getWeight()+") ");
            }
            System.out.println();
        }

        System.out.println("enter the source vertex for shortest path computation: ");
        String source = scanner.nextLine();
        DijkstrasAlgo dijkstra = new DijkstrasAlgo(graph);
        Map<String, Integer> shortestPaths = dijkstra.findShortestPath(source);

        System.out.println("Shortest paths from source vertex '" + source + "':");
        for(Map.Entry<String,Integer> entry : shortestPaths.entrySet()){
            System.out.println("To "+entry.getKey() + ": "+ entry.getValue());
        }
        scanner.close();
    }
}
