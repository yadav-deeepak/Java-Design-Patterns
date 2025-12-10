package com.ashokit.desingpatterns.strategydesignpattern;

public class StrategyDesignPatternBankExample {

	public static void main(String[] args) {
		Customer c = new Customer(new PreferredCustomer());
		c.showInterest();
		
		Customer c1 = new Customer(new RegularCustomer());
		c1.showInterest();
	}
}

interface CustomerType{
	public void interestRate();
}

class PreferredCustomer implements CustomerType{

	@Override
	public void interestRate() {
		// TODO Auto-generated method stub
		System.out.println("Interest Rate is 9.7%");
	}
	
}

class RegularCustomer implements CustomerType{

	@Override
	public void interestRate() {
		// TODO Auto-generated method stub
		System.out.println("Interest Rate is 10%");
	}
	
}

class Customer {
	
	private CustomerType c;
	public Customer(CustomerType c) {
		
		this.c = c;
		
	}
	
	void showInterest() {
		c.interestRate();
	}
}