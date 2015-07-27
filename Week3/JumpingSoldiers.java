package Week3;

import java.util.Collections;
import java.util.Vector;

public class JumpingSoldiers {

	private Vector<Integer> jumps = new Vector<Integer>();
	
	private void swap(int []arr, int f, int  s){
		int temp = arr[s];
		arr[s] = arr[f];
		arr[f] = temp;
	}
	
	public int numberOfJumps(int [][] matrix){
		int count = 0;
		for(int i = 0; i < matrix.length ; i++){
			for(int j = 1 ; j < matrix[i].length ; j++){
				if (matrix[i][j] < matrix[i][j - 1]) {
					swap(matrix[i], j - 1, j);
					j = 1;
					++count;
				}
			}
			jumps.add(count);
		}
		return jumps.indexOf(Collections.max(jumps)) + 1;
	}
	
	public static void main(String[] args) {
		int [][] matrix = {{1, 2, 3},
						   {2, 1, 3},
						   {3, 2, 1}
						};
		JumpingSoldiers js = new JumpingSoldiers();
		System.out.println(js.numberOfJumps(matrix));

	}

}
