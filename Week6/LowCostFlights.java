package Week6;

import java.util.Scanner;

public class LowCostFlights {

	public static int[][] matrix;
	public static final int NDF = -1;
	
	public static void warshallShortestPaths(){
		for (int k = 0; k < matrix.length; k++) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][k] != NDF && matrix[k][j] != NDF) {
                        if (matrix[i][j] != NDF && matrix[i][j] > matrix[i][k] + matrix[k][j] || matrix[i][j] == NDF) 
                        	matrix[i][j] = matrix[i][k] + matrix[k][j];
					}
				
				}	
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		matrix = new int [N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int input = sc.nextInt();
				if(input == 0){
					if (i == j) {
						matrix[i][j] = 0;
					}
					else{
						matrix[i][j] = NDF;
					}
				}
				else{
					matrix[i][j] = input;
				}
			}
		}
		warshallShortestPaths();
		
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			System.out.println(matrix[start][end] == NDF ? "NO WAY" : matrix[start][end]);
		} 
		sc.close();
	}

}
