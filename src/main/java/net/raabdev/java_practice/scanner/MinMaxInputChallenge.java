package net.raabdev.java_practice.scanner;

import java.util.Scanner;

public class MinMaxInputChallenge {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int currentNum = 0;
		int maxNum = 0;
		int minNum = 0;
		boolean firstNum = true;
				
		while (true) {
			System.out.println("Please input a number: ");
			
			if(scanner.hasNextInt()) {
				currentNum = scanner.nextInt();
				
				if(firstNum) {
					minNum = currentNum;
					maxNum = currentNum;
					firstNum = false;
				}
				
				if(currentNum > maxNum)
					maxNum = currentNum;
				
				if(currentNum < minNum)
					minNum = currentNum;
				
			} else {
				break;
			}
			
			scanner.nextLine();
			System.out.println("The largest number has been : " + maxNum);
			System.out.println("The smallest number has been: " + minNum);
		}
		
		scanner.close();
	}

}
