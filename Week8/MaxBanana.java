package Week8;

import java.util.Scanner;

public class MaxBanana {

	public static int findMaxBananas(int[][] grid){
		int right = 0, up = 0;
		for (int row = grid.length - 1; row >= 0; row--) {
			for (int col = 0; col < grid.length; col++) {
				if (row + 1 < grid.length ) {
					up = grid[row + 1][col];
				}
				if (col - 1 >= 0) {
					right = grid[row][col - 1];
				}
				grid[row][col] += Math.max(up, right);
				right = 0;
				up = 0;
			}
		}
		
		return grid[0][grid.length - 1];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[][] matrix = new int[size][size];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		System.out.println(MaxBanana.findMaxBananas(matrix));
		sc.close();
	}

}
