package net.raabdev.java_practice.arrays_and_lists;

import java.util.Scanner;

public class BankingMain {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		boolean exit = false;
		String name;
		while (!exit) {
			optionMenu();
			if (scanner.hasNextInt()) {

				switch (scanner.nextInt()) {
				case 1:
					System.out.println("New branch name: ");
					scanner.nextLine();
					name = scanner.nextLine();
					boolean added = Bank.addBranch(name);
					if (added) {
						System.out.println("Branch " + name + " added");
					} else {
						System.out.println("Error, new branch not added");
					}
					break;
				}
			}

		}
	}

	private static void optionMenu() {
		System.out.println("Bank Menu: ");
		System.out.println("1: Add a new branch ");
		System.out.println("2: Search for branch");
		System.out.println("3: Show all branches");
		System.out.println("4: Add new customer");
		System.out.println("5: Show all customers");
		System.out.println("6: Add new transaction");
		System.out.println("6: Show all transactions");
		System.out.println("7: Quit");
	}

}
