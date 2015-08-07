package Week4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneNumbers {

	private static boolean[] visited;
	
	public PhoneNumbers(int size){
		visited = new boolean[size];
	}
	
	public int findMinimumCalls(int[][] graph){
		int count = 0;
		for (int i = 0; i < graph.length; i++) {
			if (!visited[i]) {
				++count;
				DFS(graph, i);
			}
		}
		return count;
	}
	
	private static void DFS(int[][] graph, int u){
		visited[u] = true;
		for (int i = 0; i < graph[u].length; i++) {
			if (graph[u][i] == 1 && !visited[i]) {
				visited[i] = true;
				DFS(graph, i);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		Scanner sc = new Scanner(System.in);
		int numberOfPeople = sc.nextInt();
		int [] people = new int[numberOfPeople];
		int[][] graph = new int[numberOfPeople][numberOfPeople];
		String[] splitted = sc.nextLine().split(" ");
		for (int i = 0; i < numberOfPeople; i++) {
			people[i] = Integer.parseInt(splitted[i]);
			hash.put(people[i], i);
		}
		for (int j = 0; j < numberOfPeople; j++) {
			int indexOfFriend = sc.nextInt();
			for (int m = 0; m < indexOfFriend; m++) {
				int contact = sc.nextInt();
				graph[j][hash.get(contact)] = 1;
				graph[hash.get(contact)][j] = 1;
			}
		}
		sc.close();
		PhoneNumbers pn = new PhoneNumbers(numberOfPeople);
		System.out.println(pn.findMinimumCalls(graph));
	}

}
