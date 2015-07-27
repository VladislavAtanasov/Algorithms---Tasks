package Week3;

import java.util.Scanner;
import java.util.Vector;

public class BirthdayRanges {
	  
	  private static Vector<Integer> birthdays;
	
	  public BirthdayRanges(int size){
		  birthdays = new Vector<Integer>(size);
	  }
	

	  public void add(int day, int numberOfPeople) {
	    for (int i = 0; i < numberOfPeople; i++) {
	    	birthdays.add(day);
	    }
	  }

	  public void remove(int day, int numberOfPeople) {
		  int count = 0;
		  
		  while( count < numberOfPeople && birthdays.contains(day)) {
	    	birthdays.remove(birthdays.indexOf(day));
	    	++count;
		  }
	  }

	  public int count(int startDay, int endDay) {
	    int count = 0;
		for (int day : birthdays ) {
			if (day >= startDay && day <= endDay) {
				++count;
			}
		}
		return count;
	  }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String []first = sc.nextLine().split(" ");
		int size = Integer.parseInt(first[0]);
		int commands = Integer.parseInt(first[1]);
		BirthdayRanges br = new BirthdayRanges(size);
		String []digits = sc.nextLine().split(" ");
		for (int i = 0; i < size; i++) {
			br.add(Integer.parseInt(digits[i]), 1);
		}
		for (int i = 0; i < commands; i++) {
			String nextLine = sc.nextLine();
			String[] splitted = nextLine.split(" ");
			if (nextLine.contains("add")) {
				br.add(Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]));
			}
			else if (nextLine.contains("count")) {
				System.out.println("\\>" + br.count(Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2])));
			}
			else if (nextLine.contains("remove")) {
				br.remove(Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]));
			}
		}
		sc.close();
	}

}
