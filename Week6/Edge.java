package Week6;

public class Edge implements Comparable<Edge> {
	
	private int first;
	private int second;
	private int weight;
	
	public Edge(int f, int s, int wei){
		this.first = f;
		this.second = s;
		this.weight = wei;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public int either(){
		return first;
	}
	
	public int other(int vertex){
		if (vertex == first) {
			return second;
		}
		return first;
	}
	
	@Override
	public int compareTo(Edge that){
		return this.weight - that.weight;
	}
	
	public String toString(){
		return String.format("%d %d %d", first, second, weight);
	}
}
