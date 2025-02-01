import java.util.*;

public class DijkstrasAlgo {
    private Graph graph;

    public DijkstrasAlgo(Graph graph) {
        this.graph = graph;
    }

    public Map<String, Integer> findShortestPath(String source) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<VertexDistance> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(VertexDistance::getDistance));
        Set<String> visited = new HashSet<>();

        for (String vertex : graph.getAdjacencyList().keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        priorityQueue.add(new VertexDistance(source, 0));

        while (!priorityQueue.isEmpty()) {
            VertexDistance current = priorityQueue.poll();
            String currentVertex = current.getVertex();

            if (visited.contains(currentVertex)) continue;
            visited.add(currentVertex);

            for (Edge edge : graph.getAdjacencyList().getOrDefault(currentVertex, new ArrayList<>())) {
                String neighbor = edge.getDestination();
                int newDistance = distances.get(currentVertex) + edge.getWeight();

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    priorityQueue.add(new VertexDistance(neighbor, newDistance));
                }
            }
        }

        return distances;
    }

    private static class VertexDistance {
        private String vertex;
        private int distance;

        public VertexDistance(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public String getVertex() {
            return vertex;
        }

        public int getDistance() {
            return distance;
        }
    }
}