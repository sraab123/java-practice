package net.raabdev.java_practice.arrays_and_lists;

import java.util.Arrays;

public class ReverseArrayChallenge {

	public ReverseArrayChallenge() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] a = {9,2,6,2,4,1,1};
		
		System.out.println(Arrays.toString(a));
		
		reverseArray(a);
		
		System.out.println(Arrays.toString(a));
		
	}
	
	public static void reverseArray(int[] b) {
		if (b == null || b.length <= 0) {
			return;
		}
		
		int[] tempA = new int[b.length];
		for(int i = 0; i < b.length; i++) {
			tempA[i] = b[i];
		}
		
		for(int j = 0; j < b.length ; j++) {
			b[j] = tempA[b.length - j - 1];
		}
		
	}

}
