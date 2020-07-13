package net.raabdev.java_practice.arrays_and_lists;

import java.util.ArrayList;

public class Bank {
	public static ArrayList<Bank> branches = new ArrayList<Bank>();
	
	public static void listBranches() {
		System.out.println("Branch Names: ");
		for (Bank bank:branches) {
			System.out.println(bank.getBranchName());
		}
	}

	private ArrayList<Customer> customers;
	private String branchName;
	
	public String getBranchName() {
		return branchName;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	private Bank(String branchName) {
		this.branchName = branchName;
		this.customers = new ArrayList<Customer>();
	}

	public static boolean addBranch(String branchName) {
		boolean branchExists = findBranch(branchName);
		if(branchExists) {
			return false;
		} else {
			branches.add(new Bank(branchName));
			return true;
		}
			
	
	}
	
	public static boolean findBranch(String branchName) {
		for(Bank bank:branches) {
			if (bank.getBranchName().equals(branchName)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Bank getBank(String branchName) {
	for(Bank bank:branches) {
		if (bank.getBranchName().equals(branchName)) {
			return bank;
		}
	}
	
	return null;
}

	
}


