package com.ashokit.desingpatterns.templatedesignpattern;

public class TemplateDesignPatternExample {

	public static void main(String[] args) {
		Account a = new Account("Karthik", 1000);
		Transaction t = new DebitTransaction(a);
		t.templateMethod(2000);
		Transaction t1 = new CreditTransaction(a);
		t1.templateMethod(3000);
	}
	
}

//The template method should be final otherwise any of the class implementing the Transaction class will be able to override this 
//We don't want that we want that this order should be followed so we will make it final.

abstract class Transaction{
	
	public final void templateMethod(double amt) {
		if(authenticate() && validateInput() && updateLogsDB() && perfromTransaction(amt)) {  
			notifyUser();
		}
	}
	
	public abstract boolean authenticate();
	public abstract boolean validateInput();
	public boolean updateLogsDB() {
		System.out.println("DB updates/Log");
		return true;
	}
	public abstract boolean perfromTransaction(double amt);  
	public boolean notifyUser() {
		System.out.println("Successfull transaction");
		return true;
	}
	
}

class DebitTransaction extends Transaction {

	Account a;
	DebitTransaction(Account a){
		this.a = a;
	}
	@Override
	public boolean authenticate() {
		// TODO Auto-generated method stub
		System.out.println("Debit authenticate");
		return true;
	}

	@Override
	public boolean validateInput() {
		// TODO Auto-generated method stub
		System.out.println("Validated and amount is not negative");
		return true;
	}

	@Override
	public boolean perfromTransaction(double amt) {
		// TODO Auto-generated method stub
		a.debitTransaction(amt);
		return true;
	}
	
}

class CreditTransaction extends Transaction {

	Account a;
	CreditTransaction(Account a){
		this.a = a;
	}
	@Override
	public boolean authenticate() {
		// TODO Auto-generated method stub
		System.out.println("Debit authenticate");
		return true;
	}

	@Override
	public boolean validateInput() {
		// TODO Auto-generated method stub
		System.out.println("Validated and amount is not negative");
		return true;
	}

	@Override
	public boolean perfromTransaction(double amt) {
		// TODO Auto-generated method stub
		a.creditTransaction(amt);
		return true;
	}
	
}

class Account {
	String accountHolderName;
	double accountBalance;
	
	public Account(String name, double balance) {
		this.accountHolderName = name;
		this.accountBalance = balance;
	}
	
	public void debitTransaction(double amtToBeDebited) {
		accountBalance = accountBalance-amtToBeDebited;
	}
	
	public void creditTransaction(double amtToBeDebited) {
		accountBalance = accountBalance+amtToBeDebited;
	}
}