package mypackage;
import java.util.Random;

public class SelectionSort {
private final static int arrayCapacity = 1000;	
private static int intervalNumbers = 30000;
public static int[] generateRandomArray(){
        int array[] = new int[arrayCapacity];
        Random random = new Random();
        
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(intervalNumbers);
        }
        
        return array;
    }
public int[] Selection(int[] arr){
	 for (int i = 0; i < arr.length - 1; i++)
     {
         int min = i;
         for (int j = i + 1; j < arr.length; j++)
             if (arr[j] < arr[min])
                 min = j;
   
         int temp = arr[min]; 
         arr[min] = arr[i];
         arr[i] = temp;
     }
     return arr;
 }
	public static void main(String[] args) {
		SelectionSort select = new SelectionSort();
		int[] newarr = SelectionSort.generateRandomArray();
		long startTime = System.currentTimeMillis();
        int[] sortedArray = select.Selection(newarr);
        long endTime = System.currentTimeMillis();
        double elapsedTime = (endTime - startTime) / 1000.0;
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.println(sortedArray[i]);
		}
		System.out.println("This is the elapsed time: " + elapsedTime);
	}

}
