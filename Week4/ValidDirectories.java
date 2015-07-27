package Week4;

import java.util.LinkedList;
import java.util.Queue;

public class ValidDirectories {

	public static final int SIZE = 6;

    public static final int FOLDER = 1;
    public static final int FILE = 2;

    public static final int[][] graph = { { 0, 1, 0, 1, 0, 2 }, { 0, 0, 2, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
            { 1, 0, 0, 0, 2, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };

    public static boolean[] visited = new boolean[SIZE];

    private static boolean Validation(int graph[][], int start){
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.add(start);
    	boolean inPath[] = new boolean[SIZE];
    	
    	while(!queue.isEmpty()){
    		int current = queue.remove();
    		visited[current] = true;
    		inPath[current] = true;
    		
    		for (int i = 0; i < SIZE; i++) {
				if (graph[current][i] == FOLDER) {
					if (visited[i] == true) {
						return false;
					}
					if (!inPath[i]) {
						queue.add(i);
					}
				}
			}
    	}
    	return true;
    }
    
    public static boolean isValid(int[][] graph){
    	for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				boolean Valid = Validation(graph, i);
				if (!Valid) {
					return false;
				}
			}
		}
    	return true;
    }

	
	public static void main(String[] args) {
		boolean result = isValid(graph);
        System.out.println(result);
	}

}
