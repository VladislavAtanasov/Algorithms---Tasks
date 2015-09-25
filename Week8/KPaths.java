package Week8;

import java.util.Scanner;

public class KPaths {

	private static int[][] graph;
	private static int length = 0;
	private static int sum = 0;
	
	public static int findKPaths(int start, int end, int len){ 
		DFS(start, end, len);
		return length;
	}
	
	private static void DFS(int start, int end, int len){
		for (int i = 0; i < graph[start].length; i++) {
			if (i == end && sum == len) {
				length++;
				sum = 0;
				return;
			}
			if (graph[start][i] == 1) {
				sum += graph[start][i];
				DFS(i, end, len);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		graph = new int[size][size];
		for (int i = 0; i < graph.length; i++) {
			graph[sc.nextInt()][sc.nextInt()] = 1;
		}
		int startIndex = sc.nextInt();
		int endIndex = sc.nextInt();
		int lenght = sc.nextInt();
		System.out.println(KPaths.findKPaths(startIndex, endIndex, lenght));
		sc.close();
	}

}
