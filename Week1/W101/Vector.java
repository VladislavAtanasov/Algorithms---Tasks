import java.util.Arrays;


public class Vector {
	private int[] arr = {};
	private int size;
	private int Capacity;
	private static final int cap = 10;
	
	public Vector(){
		size = 0;
		Capacity = cap;
		arr = new int[Capacity];
	}
	private int[] EnsureCapacity(int[] arr){
		Capacity *= 2;
		arr = Arrays.copyOf(arr, Capacity);
		return arr;
	}
	public int get(int index){
		if(index < 0 && index > size){
			try {
				throw new Exception("Cannot insert");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return arr[index];
	}
	public void insert(int index, int value) {
		if(index < arr.length && index >= 0){
		arr[index] = value;
		}else{
			try {
				throw new Exception("Cannot insert");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void add(int value){
		if(size == Capacity){
			arr = EnsureCapacity(arr);
		}
		if(size < Capacity){
			arr[size] = value;
			size++;
		}
	}
	public int size(){
		return size;
	}
	public int capacity(){
		return Capacity;
	}
	public void pop(){
		
		if(size > 0){
			size--;
		}else{
			try {
				throw new Exception("Cannot remove");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void remove(int index){
		if(index < 0 || index > size){
			try {
				throw new Exception("Cannot insert");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			for(int i = index; i<size; i++){
				arr[i] = arr[i+1];
			}
			size--;
		}
	}
	public static void main(String[] args) {
		Vector v1 = new Vector();
		//System.out.println(v1.get(3));
		v1.add(21);
		//v1.insert(5, 22);
		v1.remove(0);
		System.out.println(v1.size());
		//System.out.println(v1.get(4));
	}
}
