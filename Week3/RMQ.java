package Week3;

import java.util.Scanner;

public class RMQ {

    int[] tree;
    int[] values;

    public RMQ(int[] values) {
        int size = (int) Math.pow(2, Math.ceil(Math.log(values.length) / Math.log(2)));
        tree = new int[2 * size];
        initTree(values);
        this.values = values;
    }

    private void initTree(int[] values) {
        int i = 0;

        for (i = 0; i < values.length; ++i) {
            tree[tree.length / 2 + i] = values[i];
        }

        for (int j = i; j < tree.length / 2; ++j) {
            tree[tree.length / 2 + j] = Integer.MAX_VALUE;
        }

        for (i = tree.length / 2 - 1; i > 0; --i) {
            tree[i] = Math.min(tree[left(i)], tree[right(i)]);
        }
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }

    private int parent(int i) {
        return i / 2;
    }
    
    public int min(int l, int r) {
        l += tree.length / 2;
        r += tree.length / 2;
        int lMin = tree[l], rMin = tree[r], temp = 0;
        
        while (l < r) {
            if (l % 2 == 0) { 
                l = parent(l);
                lMin = Math.min(lMin, tree[l]);
            } else {      
                temp = tree[l];
                l = parent(l + 1);
                lMin = Math.min(temp, tree[l]);
            }
            
            if (r % 2 == 0) {   
                temp = tree[r];
                r = parent(r - 1);
                rMin = Math.min(temp, tree[r]);
            } else {       
                r = parent(r);
                rMin = Math.min(rMin, tree[r]);
            }
        }
        
        return lMin;
    }
    
    public void printState() {
        for (int i = 0; i < tree.length; ++i) {
            System.out.print(tree[i] + " ");
        }
    }
    
    public void set(int index, int value){
    	int size = (int) Math.pow(2, Math.ceil(Math.log(values.length) / Math.log(2)));
        tree = new int[2 * size];
    	values[index] = value;
    	initTree(values);
    }
    
    public static void main(String[] args) {      
        Scanner sc = new Scanner(System.in);
		String []first = sc.nextLine().split(" ");
		int size = Integer.parseInt(first[0]);
		int commands = Integer.parseInt(first[1]);
		String []digits = sc.nextLine().split(" ");
		int []numbers = new int[size];
		for (int i = 0; i < size; i++) {
			numbers[i] = Integer.parseInt(digits[i]);
		}
		RMQ rmq = new RMQ(numbers);
		for (int i = 0; i < commands; i++) {
			String nextLine = sc.nextLine();
			String[] splitted = nextLine.split(" ");
			if (nextLine.contains("set")) {
				rmq.set(Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]));
			}
			else if (nextLine.contains("min")) {
				System.out.println(rmq.min(Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2])));
			}
		}
		sc.close();
    }
    
}
