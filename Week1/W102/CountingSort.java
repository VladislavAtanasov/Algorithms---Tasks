package mypackage;
import java.util.Arrays;
import java.util.Random;


public class CountingSort {
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
	public static int[] findMinMax(int[] arr){
        int min=arr[0];
        int max=arr[0];
        int []helparr = new int[2];
        for(int ii=0;ii<arr.length;ii++){
            if(arr[ii]<min){
                min=arr[ii];
            }
            else if(arr[ii]>max){
                max=arr[ii];
            }
        }
        helparr[0] = min;
        helparr[1] = max;
        return helparr;
	}
	public static int[] countingSort(int[] a, int low, int high)
	{
	    int[] counts = new int[high - low + 1]; 
	    for (int x : a)
	        counts[x - low]++;

	    int current = 0;
	    for (int i = 0; i < counts.length; i++)
	    {
	        Arrays.fill(a, current, current + counts[i], i + low); 
	        current += counts[i];
	    }
	    return a;
	}
	
	public static void main(String[] args) {
		CountingSort cs = new CountingSort();
		int[] newarr = CountingSort.generateRandomArray();
		int [] minMax = cs.findMinMax(newarr);
		long startTime = System.currentTimeMillis();
        int[] sortedArray = cs.countingSort(newarr, minMax[0], minMax[1]);
        long endTime = System.currentTimeMillis();
        double elapsedTime = (endTime - startTime) / 1000.0;
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.print(sortedArray[i]);
			System.out.print(' ');
		}
		System.out.println();
		System.out.println(elapsedTime + " seconds.");
	}

}
