package net.raabdev.java_practice.scanner;

import java.util.Scanner;

public class InputCalculator {

	public static void main(String[] args) {
       inputThenPrintSumAndAverage();
	}
	

	
	    public static void inputThenPrintSumAndAverage() {
	        Scanner scanner = new Scanner(System.in);
	        int count = 0;
	        int sum = 0;

	        while(true) {
		//		System.out.println("Please input a number: ");
	        	if(scanner.hasNextInt()) {
					sum += scanner.nextInt();
					count++;
				} else {
					break;
				}
				scanner.nextLine();
	        }
	        
	        long avg = 0L;
	        if (count > 0) {
	            avg = Math.round( (double) sum / (double) count);
	        }
	        System.out.println("SUM = " + sum + " AVG = " + avg);
	        scanner.close();
	    }
	

}
