package Week4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class BuildScripts {
	
	private static boolean[] visited;
	private static Vector<Integer> queue;
	private static final String ERROR = "BUILD ERROR";
	
	public static String buildProject(String project, String[] names, int[][] graph){
		visited = new boolean[graph.length];
		queue = new Vector<Integer>();
		String string = "";
		int projectIndex = Arrays.asList(names).indexOf(project);
		for (int i = 0; i < graph[projectIndex].length - 1; i++) {
			int index = DFS(graph, projectIndex);
			if (index == -1) {
				return ERROR;
			}
		}
		for (int i = 0; i < queue.size(); i++) {
			string += names[queue.get(i)];
			string += " ";
		}
		string += project;
		return string;
	}
	
	private static int DFS(int[][]graph, int start){
		int i = 0;
		int count = 0;
		for (i=0; i < graph[start].length; i++) {
			if (!visited[i] && graph[start][i] == 1 ) {
				++count;
				return DFS(graph, i);
			}
		}
		if (count == 0) {
			return noDependent(start, graph);
		}	
		return -1;
	}
	
	private static int noDependent(int start, int[][] graph){
		for (int j = 0; j < graph[start].length; j++) {
			graph[j][start] = 0;
		}
		queue.add(start);
		visited[start] = true;
		return start;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int projects = sc.nextInt();
		String[] names = new String[projects];
		int[][] graph = new int[projects][projects];
		Map<String, Integer> hash = new HashMap<String, Integer>(projects);
		for (int i = 0; i < projects; i++) {
			names[i] = sc.next();
			hash.put(names[i], i);			
		}
		String Project = sc.next();
		for (int j = 0; j < projects; j++) {
			int dependence = sc.nextInt();
			if (dependence > 0) {	
				for (int m = 0; m < dependence; m++) {
					String name = sc.next();
					graph[j][hash.get(name)] = 1;	
				}
			}
		}
		sc.close();
		System.out.println(BuildScripts.buildProject(Project, names, graph));
		
	}

}
