package binarysearch;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Root {
	public double findRoot(int number){
		double leftIndex = 0;
		double rightIndex = number + 1;
		double middle = 0;
		double precision = 0.000000001;
		if (number < 0) {
			return -1;
		}
		else if (number == 1){
			return 1;
		}
		else {
			while(rightIndex - leftIndex > precision){
				middle = (rightIndex + leftIndex)/2.0;
				if(middle*middle <= number){
					leftIndex = middle;
				}
				else {
					rightIndex = middle;
				}
			}
			leftIndex = Double.parseDouble(new DecimalFormat("##.#####").format(leftIndex));
			return leftIndex;
		}
	}
	public static void main(String[] args) {
		Root r = new Root();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		System.out.println(r.findRoot(num));
		
	}

}
