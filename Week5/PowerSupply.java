package Week5;

import java.util.Scanner;

public class PowerSupply {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int digit = sc.nextInt();
		Graph graph = new Graph();
		for (int i = 0; i < digit; i++) {
			graph.addEdge(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		MST mstree = new MST(graph);
		sc.close();
		System.out.println(mstree.totalWeight());
	}

}
