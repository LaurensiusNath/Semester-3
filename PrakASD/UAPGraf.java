package PrakASD;

import java.util.*;
class SimpleGraph {
    private int vertex;
    private LinkedList<Integer>[] adjacencyList;

    public SimpleGraph(int vertex) {
        this.vertex = vertex;
        this.adjacencyList = new LinkedList[vertex];
        for (int i = 0; i < vertex; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    public String DFS(int startVertex) {
        boolean[] visited = new boolean[vertex];
        StringBuilder result = new StringBuilder();
        DFSUtil(startVertex, visited, result);
        return result.toString();
    }

    private void DFSUtil(int vertex, boolean[] visited, StringBuilder result) {
        visited[vertex] = true;
        result.append(vertex).append(" ");

        for (Integer neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited, result);
            }
        }
    }

    public String BFS(int startVertex) {
        boolean[] visited = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            result.append(currentVertex).append(" ");

            for (Integer neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return result.toString();
    }

    public boolean isShortestPath(String dfsPath, String bfsPath, int startNode, int endNode) {
        String[] dfsNodes = dfsPath.split(" ");


        int indexStartDFS = -1;
        int indexEndDFS = -1;
        int indexStartBFS = -1;
        int indexEndBFS = -1;
        String[] bfsNodes = bfsPath.split(" ");
        for (int i = 0; i < bfsNodes.length; i++) {
            if (Integer.parseInt(bfsNodes[i]) == startNode) {
                indexStartBFS = i;
            }
            if (Integer.parseInt(bfsNodes[i]) == endNode) {
                indexEndBFS = i;
            }
        }
        int BFS = Math.abs(indexStartBFS - indexEndBFS);

        for (int i = 0; i < dfsNodes.length; i++) {
            if (Integer.parseInt(dfsNodes[i]) == startNode) {
                indexStartDFS = i;
            }
            if (Integer.parseInt(dfsNodes[i]) == endNode) {
                indexEndDFS = i;
            }
        }
        int DFS = Math.abs(indexStartDFS - indexEndDFS);


        return DFS <= BFS;
    }
}

public class UAPGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start, goal, numVertices, numEdges, root;
        start = scanner.nextInt();
        goal = scanner.nextInt();
        numVertices = scanner.nextInt();
        numEdges = scanner.nextInt();
        root = scanner.nextInt();

        SimpleGraph graph = new SimpleGraph(numVertices);

        for (int i = 0; i < numEdges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        String dfsTraversal = graph.DFS(root);
        String bfsTraversal = graph.BFS(root);

        System.out.println("DFS traversal: " + dfsTraversal);
        System.out.println("BFS traversal: " + bfsTraversal);

        if (graph.isShortestPath(dfsTraversal, bfsTraversal, start, goal)) {
            System.out.println("DFS is the shortest path");
        } else {
            System.out.println("BFS is the shortest path");
        }
    }
}