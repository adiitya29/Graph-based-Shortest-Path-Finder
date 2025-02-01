import java.util.*;

public class Graph{
    private Map<String, List<Edge>> adjacencyList;

    public Graph(){
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex){
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight){
        addVertex(from);
        addVertex(to);
        adjacencyList.get(from).add(new Edge(to, weight));
    }
    public Map<String, List<Edge>> getAdjacencyList(){
        return adjacencyList;
    }
}