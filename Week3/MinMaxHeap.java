package Week3;

public class MinMaxHeap {
	
	public static class Node{
		public int item;
		public Node left;
		public Node right;
	
		public Node(int item, Node left, Node right){
			this.item = item;
			this.left = left;
			this.right = right;
		}
	}
	
	private static int level = 1;
	
	public boolean isMinMax(Node root) {
		return isMinMaxRange(root, level);
	}
	
	public boolean isMinMaxRange(Node root, int level){
		if (root == null) {
			return true;
		}
		if (level % 2 == 0){
			if (root.left != null && root.item < root.left.item || root.right != null && root.item < root.right.item ) {
				return false;
			}
		}
		else if (level % 2 == 1){
			if (root.left != null && root.item > root.left.item || root.right != null && root.item > root.right.item ) {
				return false;
			}
		}
		return isMinMaxRange(root.left, level + 1) && isMinMaxRange(root.right, level + 1);
	}
	
	public static void main(String[] args) {
		Node left2 = new Node(1, null, null);
		Node right2 = new Node(3, null, null);
		Node left = new Node(5, left2, right2);
		Node left3 = new Node(2, null, null);
		Node right3 = new Node(0, null, null);
		Node right = new Node(6, left3, right3);
		Node root = new Node(4, left, right);
		MinMaxHeap mmHeap = new MinMaxHeap();
		System.out.println(mmHeap.isMinMax(root));
	}

}
