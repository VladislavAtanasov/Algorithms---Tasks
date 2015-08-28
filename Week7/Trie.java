package week7;

public class Trie {

	public static class Node{
	   private static final int ALPHA_SIZE = 26;
	   public Node[] next;
	   public boolean isWord;
	   
	   public Node()
	   {
		   this.next = new Node[ALPHA_SIZE];
		   this.isWord = false;
	   }
	}
	
	private Node root;
	
	public Trie(){
		root = new Node();
	}
	

	public void insert(String word){
		   if (word.length() == 0) {
			   root.isWord = true;
			   return; 
		   }
		   
		   Node current = root;
		   int index = 0;
		   for (int i = 0; i < word.length() - 1; ++i) {
			   index = word.charAt(i) - 'a'; 
			   if (current.next[index] == null) {
				   current.next[index] = new Node();
			   }
			   current = current.next[index];
		   }
		   current.isWord = true;
    }
	
	public boolean contains(String word){
		if (word.length() == 0){
			return root.isWord;
		}
		Node current = root;
		int index = 0;
		for (int i = 0; i < word.length() - 1; ++i) {
			index = word.charAt(i) - 'a';
			if (current.next[index] != null) {
				current = current.next[index];
			}
			else{
				return false;
			}
		}
		return current.isWord;
	}
	   
	public static void main(String[] args) {
		

	}
}
