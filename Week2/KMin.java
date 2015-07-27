package binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KMin {
	 public int kthMinimum(List<Integer> numbers, int k) {
		    Heap<Integer> hp = new Heap<Integer>();
		    hp.heapify(numbers, numbers.size());
	        Integer min = null;
	        
	        for (int i = 0; i < k; ++i) {
	            min = hp.extractMin();
	        }
	        
	        return min;
	}
	public static void main(String[] args) {
		KMin km = new KMin();
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		List<Integer> intList = new ArrayList<Integer>();
		
		for (int i = 0; i < size; i++) {
			intList.add(sc.nextInt());
		}
		int k = sc.nextInt();
		System.out.println(km.kthMinimum(intList, k));
		sc.close();
	}

}
