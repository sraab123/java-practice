package net.raabdev.java_practice.arrays_and_lists;

import java.util.Scanner;

public class MinElementChallenge {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		 findMin(null);
		 System.out.println("How many integers?");
		 int response = 0; 
	     if(scanner.hasNextInt()) {
    	     response = scanner.nextInt();
	    	 scanner.nextLine();
		     int minInt = findMin(readIntegers(response));
		     System.out.println("The minimum integer you entered is: " + minInt);
	     } else {
	    	 scanner.nextLine();
	    	 System.out.println("You Suck");
	     }
	     
	     scanner.close();
	}
	
	public static int[] readIntegers(int count) {
	    int[] newArray = new int[count];
	    for (int i = 0; i < count; i++) {
	       System.out.println("Enter an integer: ");
           if(scanner.hasNextInt()) {
	    	    newArray[i] = scanner.nextInt();
	    	    scanner.nextLine();  
	       } else {
	    	  scanner.nextLine();    	  
	    	  System.out.println("Not an integer, using zero");
	    	  newArray[i] = 0;
	       }
	    }
	    
	    return newArray;
	}
	
	public static int findMin(int[] in) {
		int min = 0;
		if (in != null && in.length > 0) {
			min = in[0];
			for(int i : in) {
			  if (i < min) {
				  min = i;
			  }
			}		
		}
		return min;
	}

}
