package com.ashokit.desingpatterns.chainofresponsibility;

import java.util.Scanner;

public class ChainOfResATMExamp {

	DispenceChain d;
	ChainOfResATMExamp() {
	
		this.d=new Notes2000Rack();
		DispenceChain d1 = new Notes500Rack();
		DispenceChain d2 = new Notes100Rack();
		d.chain(d1);
		d1.chain(d2);
	}
	
	public static void main(String[] args) {
		
		ChainOfResATMExamp c = new ChainOfResATMExamp();
		while(true) {
			System.out.println("Please enter the amount to be withdrawn");
			Scanner s = new Scanner(System.in);
			int amount = s.nextInt();
			if(amount!=0) {
				if(amount % 100 != 0) {
					System.out.println("Please enter multiples of 100");
					return;
				}else {
					c.d.dispence(new Currency(amount));
				}
			}
		}
	}
}

class Currency{
	private int amount;
	
	Currency(int amt){
		this.amount = amt;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}

interface DispenceChain{
	void dispence(Currency current);
	void chain(DispenceChain d);
}

class Notes2000Rack implements DispenceChain{

	DispenceChain chain;
	
	@Override
	public void dispence(Currency current) {
		// TODO Auto-generated method stub
		int noOf2000Notes = current.getAmount()/2000;
		System.out.println("Dispencing " +noOf2000Notes +" 2000 notes ");
		int remainder = current.getAmount()%2000;
		if(remainder != 0) {
			chain.dispence(new Currency(remainder));
		}
		
	}

	@Override
	public void chain(DispenceChain chain) {
		// TODO Auto-generated method stub
		this.chain=chain;
	}
	
}

class Notes500Rack implements DispenceChain{

	DispenceChain chain;
	
	@Override
	public void dispence(Currency current) {
		// TODO Auto-generated method stub
		int noOf500Notes = current.getAmount()/500;
		System.out.println("Dispencing " +noOf500Notes +" 500 notes ");
		int remainder = current.getAmount()%500;
		if(remainder != 0) {
			chain.dispence(new Currency(remainder));
		}
		
	}

	@Override
	public void chain(DispenceChain chain) {
		// TODO Auto-generated method stub
		this.chain=chain;
	}
	
}

class Notes100Rack implements DispenceChain{

	DispenceChain chain;
	
	@Override
	public void dispence(Currency current) {
		// TODO Auto-generated method stub
		int noOf100Notes = current.getAmount()/100;
		System.out.println("Dispencing " +noOf100Notes +" 100 notes ");
		int remainder = current.getAmount()%100;
		if(remainder != 0) {
			chain.dispence(new Currency(remainder));
		}
		
	}

	@Override
	public void chain(DispenceChain chain) {
		// TODO Auto-generated method stub
		this.chain=chain;  
	}
	
}