package net.raabdev.java_practice.scope;

import java.util.Scanner;

public class X {
	public int x;
	public X(Scanner x) {
		System.out.println("Please give an integer: ");
		this.x = x.nextInt();
	}
	
	public void x() {
		System.out.println("Times tables for " + x );
		for(int x = 0; x <= 12; x++) {
			System.out.println(x + " times " + this.x + " is " + x * this.x);	 
	 }
	}
}
