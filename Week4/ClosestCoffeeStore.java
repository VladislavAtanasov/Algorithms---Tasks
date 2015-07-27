package Week4;

import java.util.LinkedList;
import java.util.Queue;

public class ClosestCoffeeStore {
	
	public static final int SIZE = 6;

    public static final boolean[][] graph = { { false, true, false, true, false, false },
            { true, false, true, false, false, false }, { false, true, false, false, true, false },
            { true, false, false, false, false, false }, { false, false, true, false, false, true },
            { false, false, false, false, true, false }, };

    public static final boolean[] isCoffeeStore = { false, false, true, false, false, true };
	
	public static int closestCoffeeStore(boolean[][] graph, boolean[] isCoffeStore, int startingPoint) {
		  Queue<Integer> queue = new LinkedList<Integer>();
		  boolean []visited = new boolean[SIZE];
		  
		  queue.add(startingPoint);
		  
		  while(!queue.isEmpty()){
			  int neighbour = queue.remove();
			  visited[neighbour] = true;
			  for (int i = 0; i < SIZE; i++) {
				  if (graph[neighbour][i] == true && visited[i] == false) {
					  if (isCoffeStore[i] == true)  {
						  return i;
					  }
					  queue.add(i);
				  }
			  } 
		  }
		  return -1;
		  
	}
	
	public static void main(String[] args) {
		 int result = closestCoffeeStore(graph, isCoffeeStore, 0);
	     System.out.println(result);
	}

}
