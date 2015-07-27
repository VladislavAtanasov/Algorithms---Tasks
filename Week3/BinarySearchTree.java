package Week3;

import java.util.Vector;

import Week3.MinMaxHeap.Node;

public class BinarySearchTree<T extends Comparable<T>> {
	
	public static class Node<E>{
		public E item;
		public Node<E> left;
		public Node<E> right;
		
		public Node(E item, Node<E> left, Node<E> right){
			this.item = item;
			this.left = left;
			this.right = right;
		}
	}
		
		private Node<T> root;
		private int size;
		
		public BinarySearchTree(){
			this.setRoot(null);
			this.size = 0;
		}
		
		public int size(){
			return size;
		}
	
		private void insertNode(Node<T> root, Node<T> newNode){
			if (newNode.item.compareTo(root.item) < 0) {
				if (root.left == null) {
					root.left = newNode;
					++size;
				}
				
				else{
					insertNode(root.left, newNode);
				}
			}
			
			else if (newNode.item.compareTo(root.item) > 0) {
				if (root.right == null) {
					root.right = newNode;
					++size;
				}
				
				else {
					insertNode(root.right, newNode);
				}
			}
			
			else {
				root.item = newNode.item;
			}
		}
		
	    private void traverseNodes(Node<T> root) {
	        if (root == null) {
	            return;
	        }
	        
	        traverseNodes(root.left);
	        System.out.println(root.item);
	        traverseNodes(root.right);
	    }
	    
	    private Node<T> findNode(T elem){
	    	Node<T> current = getRoot();
	    	
	    	while(current != null){
	    		if(elem.compareTo(current.item) < 0){
	    			current = getRoot().left;
	    		}
	    		
	    		else if(elem.compareTo(current.item) > 0){
	    			current = getRoot().right;
	    		}
	    		
	    		else{
	    			return current;
	    		}
	    	}
	    	
	    	return null;
	    }
	    
	    private Node<T> leftMostChild(Node<T> root){
	    	Node<T> current = root;
	    	
	    	while (current != null) {
				current = current.left;
			}
	    	
	    	return current;
	    }
	    
	    private boolean hasNoChildren(Node<T> root){
	    	return root.left == null && root.right == null;
	    }
	    
	    private boolean hasOnlyChild(Node<T> node){
	    	return (node.left != null && node.right == null) || (node.left == null && node.right != null);
	    }
	    
	    private Node<T> onlyChild(Node<T> node){
	    	return node.left != null ? node.left : node.right;
	    }
	
	    private Node<T> getParrent(Node<T> node){
	    	Node<T> current = getRoot(), parrent = null;
	    	
	    	while (current != null){
	    		if (node.item.compareTo(current.item) < 0) {
	    			parrent = current;
	    			current = current.left;
				}
	    		
	    		else if (node.item.compareTo(current.item) > 0){
	    			parrent = current;
	    			current = current.right;
	    		}
	    		
	    		else{
	    			break;
	    		}
	    	}
	    	
	    	return parrent;
	    }
	    
	    private void removeFromParrent(Node<T> node){
	    	Node<T> parrent = getParrent(node);
	    	
	    	if (parrent.left == node) {
	    		parrent.left = null;
	    	}
	    	else if (parrent.right == node) {
	    		parrent.right = null;
	    	}
	    }
	    
	    private void replaceInParrent(Node<T> unneeded, Node<T> replacement){
	    	Node<T> parrent = getParrent(unneeded);
	    	
	    	if (parrent.left == unneeded) {
				parrent.left = replacement;
			}
	    	
	    	else if (parrent.right == unneeded) {
	    		parrent.right = replacement;
	    	}
	    }
	    
	    private void removeNode(Node<T> node){
	    	if (node == null) {
				return;
			}
	    	if (hasNoChildren(node)) {
	    		removeFromParrent(node);
			}
	    	
	    	else if(hasOnlyChild(node)){
	    		replaceInParrent(node, onlyChild(node));
	    	}
	    	
	    	else{
	    		Node<T> replacement = leftMostChild(node.right);
	            node.item = replacement.item;
	            removeNode(replacement);
	    	}
	    }
	    
	    public void insert(T elem){
			Node<T> newNode = new Node<T>(elem, null, null);
			
			if (getRoot() == null){
				setRoot(newNode);
				++size;
			}
			else {
				insertNode(getRoot(), newNode);
			}
		}
	    
	    public void traverse() {
	        traverseNodes(getRoot());
	    }
	    
	    public T search(T elem){
	    	Node<T> found = findNode(elem);
	    	return found == null ? null : found.item;
	    }
	    
	    public void remove(T elem){
	    	Node<T> found = findNode(elem);
	    	removeNode(found);
	    	--size;
	    }
	    
	    public Node<T> getRoot() {
			return root;
		}

		public void setRoot(Node<T> root) {
			this.root = root;
		}
	    
		public int countLeftLeaves(Node<T> root){
			Node<T> current = root.left;
			Vector<Node> queue = new Vector<Node>();
			queue.addElement(current);
			for (int i = 0; i < queue.size(); i++) {
				if (queue.get(i).left != null) {
					queue.addElement(queue.get(i).left);
				}
				if (queue.get(i).right != null) {
					queue.addElement(queue.get(i).right);
				}
			}
			return queue.size();
		}
		
		public int countRightLeaves(Node<T> root){
			Node<T> current = root.right;
			Vector<Node> queue = new Vector<Node>();
			queue.addElement(current);
			for (int i = 0; i < queue.size(); i++) {
				if (queue.get(i).left != null) {
					queue.addElement(queue.get(i).left);
				}
				if (queue.get(i).right != null) {
					queue.addElement(queue.get(i).right);
				}
			}
			return queue.size();
		}
		
		public void balanceTree(){
			while (countLeftLeaves(getRoot()) != countRightLeaves(getRoot())){
				if(countLeftLeaves(getRoot()) > countRightLeaves(getRoot())){
					setRoot(getRoot().left);
				}
				else if(countLeftLeaves(getRoot()) < countRightLeaves(getRoot())){
					setRoot(getRoot().right);
				}
			}
			
		}
		
	    public static void main(String[] args) {
			BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
			bst.insert(6);
			bst.insert(5);
			bst.insert(7);
			bst.insert(3);
			bst.insert(4);
			bst.insert(9);
			bst.insert(8);
			//bst.traverse();
			System.out.println(bst.countLeftLeaves(bst.getRoot()));
			//System.out.println(bst.countRightLeaves(bst.getRoot()));
			//bst.balanceTree();
	    }

		
}
