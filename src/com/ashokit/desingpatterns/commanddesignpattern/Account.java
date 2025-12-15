package com.ashokit.desingpatterns.commanddesignpattern;

public class Account {

	public double balance;
	
	void withdraw(double amount) {
		if(balance < 0) {
			System.out.println("Insufficient funds");
		}else {
			balance = balance - amount;
		}
		System.out.println("Balance amount is "+balance+" after withdraw");
	}
	
	void deposit(double amount) {
		balance = balance+amount;
		System.out.println("Balance amount is "+balance+" after deposit");
	}
}
