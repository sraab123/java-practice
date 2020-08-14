package net.raabdev.java_practice.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	private double balance;
	private String accountNumber;
	private final ReentrantLock lock = new ReentrantLock();
	
	public BankAccount(double balance, String accountNumber) {
		super();
		this.balance = balance;
		this.accountNumber = accountNumber;
	}
	
	public void  deposit(double amount) {
		boolean status = false;
		try {
			if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
				try {
					balance += amount;
					status = true;
					System.out.println("Amount " + amount + " deposited. New Balance: " + balance);					
				} finally {
					lock.unlock();
				}
			} else {
				System.out.println("Warning, deposit failed. Could not acquire lock on the account.");
			}
		} catch (InterruptedException e) {
			//handle
		}
		
		System.out.println("Status = " + status);
	}
	
	public void withdrawl(double amount) {
	
		boolean status = false;
		try {
			if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
				try {
					if(amount > 0 && amount < balance ) {
						balance -= amount;
						status = true;
						System.out.println("Amount " + amount + " withdrawn. New Balance: " + balance);
					} else {
					  	System.out.println("Insufficient funds to withdraw " + amount);
					}
				} finally {
					lock.unlock();
				}
			} else {
				System.out.println("Warning, deposit failed. Could not acquire lock on the account.");
			}
		} catch (InterruptedException e) {				
			//handle
		}

		System.out.println("Status = " + status);

	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
}
