package Week3;

public class BST {

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
	
	public boolean isBST(Node root){
		return isBSTRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBSTRange(Node root, int min, int max){
		if (root == null) {
			return true;
		}
		
		if (root.item > min && root.item < max) {
			return isBSTRange(root.left, min, root.item) && isBSTRange(root.right, root.item, max);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Node left = new Node(1, null, null);
		Node right = new Node(3, null, null);
		Node root = new Node(5, left, right);
		BST my_bst = new BST();
		System.out.println(my_bst.isBST(root));
	}

}
