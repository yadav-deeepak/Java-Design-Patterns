package com.ashokit.desingpatterns.statedesignpattern;

public class CancelPolicyStatus implements PolicyStatus{

	@Override
	public void expirePolicy(Policy policy) {
		// TODO Auto-generated method stub
		System.out.println("Policy Status change to expire");
	}

	@Override
	public void cancelPolicy(Policy policy) {
		// TODO Auto-generated method stub
		System.out.println("Policy Status is changed to cancel");
	}

	@Override
	public void renewPolicy(Policy policy) {
		// TODO Auto-generated method stub
		policy.setPolicyStatus(new ActivePolicyStatus());
	}

}
