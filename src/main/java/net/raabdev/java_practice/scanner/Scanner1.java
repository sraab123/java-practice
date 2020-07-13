package net.raabdev.java_practice.scanner;

import java.util.Scanner;

public class Scanner1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(namePrompt());
		
		String name = scanner.nextLine();
		
		
		
		System.out.println(response(name));
		
		scanner.close();
		
	}
	
	public static String namePrompt() {
		return "What's your name?";
	}
	
	public static String response(String name) {
		return "Hello, " + name;
	}
	
	

}
