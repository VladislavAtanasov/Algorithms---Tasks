public class Queue {
	private static Vector vec = new Vector();
	public void push(int value){
		vec.add(value);
	}
	public int pop(){
		int firstElement = vec.get(0);
		vec.remove(0);
		return firstElement;
	}
	public int peek(){
		return vec.get(0);
	}
	public int size(){
		return vec.size();
	}
	
	public static void main(String[] args) {
		Queue my_queue = new Queue();
		my_queue.push(17);
		my_queue.push(6);
		my_queue.push(21);
		my_queue.push(1);
		my_queue.pop();
		System.out.println(my_queue.size());
	}

}
