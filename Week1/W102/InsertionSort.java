package mypackage;

import java.util.Random;

public class InsertionSort {
	private final static int arrayCapacity = 10000;	
	private static int intervalNumbers = 3000;
	public static int[] generateRandomArray(){
	        int array[] = new int[arrayCapacity];
	        Random random = new Random();
	        
	        for (int i = 0; i < array.length; i++) {
	            array[i] = random.nextInt(intervalNumbers);
	        }
	        
	        return array;
	    }
	public void swap(int f,int s, int[] arr){
		int temp = arr[f];
		arr[f] = arr[s];
		arr[s] = temp;
	}
	public int[] insertion(int[] sequence){
		for (int i = 1; i < sequence.length; i++) {
			int currElem = i; 
			for (int j = currElem - 1; j > 0; j--) {
				if (sequence[j] > sequence[currElem]) {
					swap(currElem,j, sequence);
					currElem -= 1;
				}
			}
		}
		return sequence;
	}
	public static void main(String[] args) {
		InsertionSort select = new InsertionSort();
		int[] newarr = InsertionSort.generateRandomArray();
		long startTime = System.currentTimeMillis();
        int[] sortedArray = select.insertion(newarr);
        long endTime = System.currentTimeMillis();
        double elapsedTime = (endTime - startTime) / 1000.0;
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.println(sortedArray[i]);
		}
		System.out.println("This is the elapsed time: " + elapsedTime);
		
	}

}
