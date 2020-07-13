package net.raabdev.java_practice.arrays_and_lists;

import java.util.ArrayList;

public class Customer {
	private ArrayList<Double> transactions;
	private String name;
	
	public Customer(String name) {
		this.name = name;
		transactions = new ArrayList<Double>();
	}

	public ArrayList<Double> getTransactions() {
		return transactions;
	}
	
	public boolean addTransaction(double amount) {
		transactions.add(amount);
		return true;
	}
	
	public void listTransactions() {
		System.out.println("Transaction List for " + name + ": ");
		for(int i = 0; i < transactions.size(); i++) {
			System.out.println(transactions.get(i));
		}
	}
	
	

}
