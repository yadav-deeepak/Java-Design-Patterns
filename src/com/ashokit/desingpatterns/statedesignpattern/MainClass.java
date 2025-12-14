package com.ashokit.desingpatterns.statedesignpattern;

public class MainClass {

	public static void main(String[] args) {
		Policy p = new Policy(new ActivePolicyStatus());
		p.cancelPolicy(p);
		
		Policy p1 = new Policy(new ExpiredPolicyState());
		p1.expirePolicy(p1);
	}
}
