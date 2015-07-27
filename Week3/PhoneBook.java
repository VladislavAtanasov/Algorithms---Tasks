package Week3;

import java.util.Scanner;

import Week3.BinarySearchTree;

public class PhoneBook {
	
		  public static final class Contact implements Comparable<Contact> {
			
		    public final String name;
		    public final int number;
		    
		    public Contact(String name, int number){
		    	this.name = name;
		    	this.number = number;
		    }
		  
		    @Override
		    public String toString(){
		    	return name + " " + number;
		    }
		    
		    @Override
		    public int compareTo(Contact con){
		    	return name.compareTo(con.name);
		    }
		  }
		  	
		  private BinarySearchTree<Contact> contacts;
		    public static final int NOT_FOUND = -1;
		    
		    public PhoneBook() {
		    	contacts = new BinarySearchTree<Contact>();
		    }
		    
		    public void insert(Contact con) {
		    	contacts.insert(con);
		    }

		    public int lookup(String name) {
		        Contact result = contacts.search(new Contact(name, 0));
		        return result == null ? NOT_FOUND : result.number;
		    }

		    public void list() {
		    	contacts.traverse();
		    }

		    public void remove(String name) {
		    	contacts.remove(new Contact(name, 0));
		    }

		    public int size() {
		        return contacts.size();
		    }
	
		    public static void main(String[] args) {
		    	Scanner sc = new Scanner(System.in);
		    	System.out.println("Enter");
		    	
		    	PhoneBook Pb = new PhoneBook();
		    	Pb.insert(new Contact("Pesho", 5));
		    	
		    	while(sc.hasNextLine()){
		    		String line = sc.nextLine();
		    		
		    		if (line.contains("insert")) {
		    			String []splitted = line.split(" ");
						Pb.insert(new Contact(splitted[1], Integer.parseInt(splitted[2])));
						splitted = null;
		    		}
		    		if (line.contains("list")) {
						Pb.list();
					}
		    		if (line.contains("remove")) {
		    			String []splitted = line.split(" ");
						Pb.remove(splitted[1]);
						splitted = null;
					}
		    		if (line.contains("lookup")) {
		    			String []splitted = line.split(" ");
						Pb.lookup(splitted[1]);
						splitted = null;
		    		}
		    		if (line == "exit") {
		    			break;
		    		}
		    	}
		    	sc.close();
		    }
}
