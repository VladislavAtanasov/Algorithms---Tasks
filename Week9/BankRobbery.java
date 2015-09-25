package Week8;

import java.util.Scanner;


public class BankRobbery {

	private static int [][] graph;
	private static int[] pathsLen;
	private static int sum = 0;
	
	public static int findMinMinutesToStayAtBank(int bank, int police, int helicopter){
		pathsLen = new int[graph.length];
		DFS(police, helicopter);
		int policeRoadLength = pathsLen[helicopter];
		pathsLen = new int[graph.length];
		DFS(bank, helicopter);
		int robberRoadLength = pathsLen[helicopter];
		if (policeRoadLength <= robberRoadLength) {
			return 0;
		}
		return policeRoadLength - robberRoadLength;
	}
	
	private static void DFS(int start, int end){
		for (int i = 0; i < graph[start].length; i++) {
			if (i == end) {
				if (pathsLen[end] != 0 && pathsLen[end] > sum) {
					pathsLen[end] = sum;
				}
				else{
					pathsLen[end] = sum;
				}
				sum = 0;
				return;
			}
			if (graph[start][i] == 1 || graph[i][start] == 1) {
				sum += graph[start][i];
				DFS(i, end);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		graph = new int[size + 1][size + 1];
		int streets = sc.nextInt();
		for (int i = 0; i < streets; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			graph[first][second] = 1;
			graph[second][first] = 1;
		}
		int bank = sc.nextInt();
		int police = sc.nextInt();
		int helicopter = sc.nextInt();
		System.out.println(BankRobbery.findMinMinutesToStayAtBank(bank, police, helicopter));
		sc.close();
	}

}
