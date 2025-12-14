package com.ashokit.desingpatterns.statedesignpattern;

public class ExpiredPolicyState implements PolicyStatus{

	@Override
	public void expirePolicy(Policy policy) {
		// TODO Auto-generated method stub
		System.out.println("Policy Status is Expired");
	}

	@Override
	public void cancelPolicy(Policy policy) {
		// TODO Auto-generated method stub
		System.out.println("Policy Status is Cancel");
	}

	@Override
	public void renewPolicy(Policy policy) {
		// TODO Auto-generated method stub
		policy.setPolicyStatus(new ActivePolicyStatus());
	}
	
	

}
