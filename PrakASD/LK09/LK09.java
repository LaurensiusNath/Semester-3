package PrakASD.LK09;

import java.util.*;

class Graph {
    private int vertex;
    private LinkedList<Node>[] adjList;
    private Map<Character, Integer> nodeIndexes;

    Graph(int v) {
        vertex = v;
        adjList = new LinkedList[vertex];
        nodeIndexes = new HashMap<>();

        for (int i = 0; i < vertex; ++i)
            adjList[i] = new LinkedList<>();
    }

    class Node {
        int dest;
        int cost;

        Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    void addEdge(char src, char dest, int cost) {
        int srcIdx = nodeIndexes.get(src);
        int destIdx = nodeIndexes.get(dest);

        adjList[srcIdx].add(new Node(destIdx, cost));
        adjList[destIdx].add(new Node(srcIdx, cost)); // For undirected graph
    }

    int dijkstra(char src, char dest) {
        int srcIdx = nodeIndexes.get(src);
        int destIdx = nodeIndexes.get(dest);

        int[] dist = new int[vertex];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Graph.Node> pq = new PriorityQueue<>(10, new Graph.NodeComparator());
        pq.add(new Node(srcIdx, 0));
        dist[srcIdx] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().dest;

            for (Node node : adjList[u]) {
                int v = node.dest;
                int weight = node.cost;

                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        return dist[destIdx];
    }

    // Method to populate nodeIndexes from outside the class
    public void setNodeIndexes(Map<Character, Integer> indexes) {
        this.nodeIndexes = indexes;
    }

    static class NodeComparator implements Comparator<Node> {
        public int compare(Node node1, Node node2) {
            return Integer.compare(node1.cost, node2.cost);
        }
    }
}

public class LK09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[]jumlah=scan.nextLine().split(" ");
        int v = Integer.parseInt(jumlah[0]);
        int edge = Integer.parseInt(jumlah[1]);

        Graph graph = new Graph(v);
        Map<Character, Integer> nodeIndexes = new HashMap<>();

        String[] inNode = scan.nextLine().split(" ");

        for (int i = 0; i < v; i++) {
            char node = inNode[i].charAt(0);
            nodeIndexes.put(node, i);
        }

        // Set the nodeIndexes in the graph object
        graph.setNodeIndexes(nodeIndexes);

        for (int i = 0; i < edge; i++) {
            String[] input = scan.nextLine().split(" ");
            graph.addEdge(input[0].charAt(0), input[1].charAt(0), Integer.parseInt(input[2]));
        }

        char source = scan.next().charAt(0);
        char destination = scan.next().charAt(0);
        System.out.println(graph.dijkstra(source, destination));
    }
}
