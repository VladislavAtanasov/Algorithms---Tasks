package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import week7.Trie;

public class WordDictionary {

	private static Trie tree;
	
	public WordDictionary(){
		tree = new Trie();
	}
	
	public void insert(String word){
		tree.insert(word);
	}
	
	public boolean contains(String word){
		return tree.contains(word);
	}
	
	
	public static void main(String[] args) throws IOException {
		WordDictionary wd = new WordDictionary();
		Scanner sc = new Scanner(System.in);
		int lines = sc.nextInt();
		for (int i = 0; i<lines + 1; i++) {
			String line = sc.nextLine();
			if (line.contains("insert")) {
				wd.insert(line.substring(line.indexOf(' ') + 1));
			}
			else if (line.contains("contains")) {
				System.out.println(wd.contains(line.substring(line.indexOf(' ') + 1)));
			}
		}
		sc.close();
	}

}
