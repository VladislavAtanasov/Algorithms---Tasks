public class Stack {
	private static Vector vec = new Vector();
	public void push(int value){
		vec.add(value);
	}
	public int pop(){
		int lastElement = vec.get(vec.size() - 1);
		vec.remove(vec.size() - 1);
		return lastElement;
	}
	public int peek(){
		return vec.get(vec.size() - 1);
	}
	public int size(){
		return vec.size();
	}
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(11);
		stack.push(51);
		stack.push(22);
		stack.push(31);
		stack.push(41);
		System.out.println(stack.pop());
		System.out.println(stack.size());
	}

}
