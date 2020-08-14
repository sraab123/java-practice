package net.raabdev.java_practice.concurrency;

public class Main_Challenge1 {

	public static void main(String[] args) {
		BankAccount acct1 = new BankAccount(2000.00, "12345-XXX");

		new Thread(new Runnable() {
			@Override
			public void run() {
				acct1.deposit(300.00);
				acct1.withdrawl(50.00);
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				acct1.deposit(203.75);
				acct1.withdrawl(100.00);
			}
		}).start();;

	};

}
