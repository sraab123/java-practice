package net.raabdev.java_practice.scanner;

import java.util.Scanner;

public class ReadingUserInputChallenge {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int currentNumber = 1;
		int currentSum = 0;
		
		while (currentNumber <= 10) {
			System.out.println("Input number #" + currentNumber);
			
			
			if(scanner.hasNextInt()) {
				currentSum += scanner.nextInt();
				currentNumber++;
				System.out.println("The current sum is:" + currentSum);
			} else {
				System.out.println("That was invalid");
			}
			scanner.nextLine();
		}

		scanner.close();
	}

}
