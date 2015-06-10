public class Stack {
	private static Queue que = new Queue();
	public void push(int value){
		que.push(value);
	}
	public int pop(){
	    for (int i = 0; i < que.size() - 1; i++) {
			int firstElement = que.pop();
			que.push(firstElement);
		}
	    return que.pop();
	}
	public int peek(){
		for (int i = 0; i < que.size() - 1; i++) {
			int firstElement = que.pop();
			que.push(firstElement);
		}
	    return que.peek();
	}
	public int size(){
		return que.size();
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
		System.out.println(stack.peek());
	}

}
