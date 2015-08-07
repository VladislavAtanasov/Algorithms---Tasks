package Week6;

import java.util.Scanner;
import java.util.Stack;

public class Navigation {
	
	 
    public static final class Vertex implements Comparable<Vertex> {
        private final int value;
        
        public Vertex(int value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @Override
        public int compareTo(Vertex o) {
            return dist[this.value] - dist[o.value];
        }
    }

    public static Graph graph = new Graph();
    public static int[] dist;
    public static int[] prev;
    public static Heap<Vertex> queue = new Heap<Vertex>();
    
    public static final int INF = 100_000_000;
    
    public static void dijkstra(int start) {
        dist[start] = 0;
        prev[start] = -1;
        for (int vertex : graph.getVerteces()) {
            if (vertex != start) {
                dist[vertex] = INF;
                prev[vertex] = -1;
            }
            queue.insert(new Vertex(vertex));
        }
        
        int neighbourVertex = 0, compoundWeight = 0;
        while (queue.size() != 0) {
            int v = queue.remove().value;
            
            for (Edge neighbourEdge : graph.getEdgesFromVertex(v)) {
                neighbourVertex = neighbourEdge.other(v);
                compoundWeight = dist[v] + neighbourEdge.getWeight();
                if (compoundWeight < dist[neighbourVertex]) {
                    queue.insert(new Vertex(neighbourVertex));
                    dist[neighbourVertex] = compoundWeight;
                    prev[neighbourVertex] = v;
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vertexCount = scanner.nextInt(), edgeCount = scanner.nextInt(), start = scanner.nextInt(),
                end = scanner.nextInt();

        dist = new int[vertexCount + 1];
        prev = new int[vertexCount + 1];
        for (int i = 0; i < edgeCount; ++i) {
            graph.addEdge(new Edge(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }
        
        dijkstra(start);
        
        System.out.println(dist[end]);
        
        Stack<Integer> stack = new Stack<Integer>();
        while (end != start) {
            stack.push(end);
            end = prev[end];
        }
        stack.push(start);
        
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        scanner.close();
    }


}
