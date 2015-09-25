package Week8;

import java.util.Scanner;

public class LongestSubsequence {
	
	public static void findSubSeq(int[] seq){
		int[] sizes = new int[seq.length];
		String[] paths = new String[seq.length];
		for (int i = 0; i < seq.length; i++) {
			sizes[i] = 1;
			paths[i] = seq[i] + " ";
		}
		int maxLength = 1;
		for (int i = 1; i < seq.length; i++) {
			for (int j = 0; j < i; j++) {
				if (seq[i] > seq[j] && sizes[i] > sizes[j] + 1) {
					sizes[i] = sizes[j] + 1;
					paths[i] = paths[j] + seq[i] + " ";
					if (maxLength < sizes[i]) {
						maxLength = sizes[i];
					}
				}
			}
		}
		for (int i = 1; i < seq.length; i++) {
			if (maxLength == sizes[i]) {
				System.out.println(paths[i]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] sequence = new int[N];
		for (int i = 0; i < N; i++) {
			sequence[i] = sc.nextInt();
		}
		findSubSeq(sequence);
		//for (int i = 0; i < resultarr.length; i++) {
		//	System.out.println(resultarr[i] + " ");
		//}
		sc.close();
	}

}
