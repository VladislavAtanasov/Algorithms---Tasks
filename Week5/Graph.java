package Week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

	private int edgeCount;
	private Map<Integer, List<Edge>> graph;
	
	public Graph(){
		graph = new HashMap<Integer, List<Edge>>();
		edgeCount = 0;
	}
	
	public int vertexCount(){
		return graph.size();
	}
	
	public int edgeCount(){
		return edgeCount;
	}
	
	public List<Edge> getEdgesFromVertex(int vertex){
		return graph.get(vertex);
	}
	
	public Set<Integer> getVerteces(){
		return graph.keySet();
	}
	
	public Map<Integer, List<Edge>> getGraph(){
		return graph;
	}

	private void addEdgeToGraph(int vertex, Edge edge){
		if (!graph.containsKey(vertex)) {
			graph.put(vertex, new ArrayList<Edge>());
		}
		graph.get(vertex).add(edge);
	}
	
	public void addEdge(Edge edge){
		int vertex1 = edge.either();
		int vertex2 = edge.other(vertex1);
		addEdgeToGraph(vertex1, edge);
		addEdgeToGraph(vertex2, edge);
		++edgeCount;
	}
	
	@Override
	public String toString(){
		return graph.toString();
	}
	
}
