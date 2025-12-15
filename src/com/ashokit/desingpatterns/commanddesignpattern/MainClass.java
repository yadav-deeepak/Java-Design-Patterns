package com.ashokit.desingpatterns.commanddesignpattern;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Account a = new Account();
		Command deposit = new DepositCommand(a, 1000);
		deposit.execute();
		//So here client does not know which execute method will be called 
		
		Command withdraw = new WithdrawCommand(a,100);
		withdraw.execute();
	}

}
