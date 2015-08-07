package Week6;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RandSet {

	private static Set<Integer> digits = new TreeSet<Integer>();
	
	public static void insert(int num){
		digits.add(num);
	}
	
	public static void remove(int num){
		digits.remove(num);
	}
	
	public static boolean contains(int num){
		return digits.contains(num);
	}
	
	public static int random(){
		Random rand = new Random();
		int[] digit = new int[digits.size()];
		int i = 0;
		for(int d: digits){
			digit[i] = d;
			i++;
		}
		return digit[rand.nextInt(digits.size())];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			if (line.contains("random")) {
				if(digits.size() > 0){
					System.out.println(random());
				}
			}
			else if (line.contains("contains")){
				System.out.println(contains(sc.nextInt()));
			}
			else if(line.contains("insert")){
				insert(sc.nextInt());
			}
			else if(line.contains("remove")){
				remove(sc.nextInt());
			}
		}
		sc.close();
	}

}
