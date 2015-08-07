package Week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KIntersect {

	public static List<Integer> intersection(List<List<Integer>> matrix){
		for (int i = 1; i < matrix.size(); i++) {
			matrix.get(0).retainAll(matrix.get(i));
		}
		return matrix.get(0);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int listsNum = sc.nextInt();
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> temp;
		for (int i = 0; i < listsNum; i++) {
			int listSize = sc.nextInt();
			temp = new ArrayList<Integer>();
			for (int j = 0; j < listSize; j++) {
				temp.add(sc.nextInt());
			}
			lists.add(temp);
			temp = null;
		}
		sc.close();
		List<Integer> result = intersection(lists);
		for (int i : result) {
			System.out.println(i);
		}
	}

}
