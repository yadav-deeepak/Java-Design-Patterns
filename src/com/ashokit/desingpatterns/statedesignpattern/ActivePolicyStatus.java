package com.ashokit.desingpatterns.statedesignpattern;

public class ActivePolicyStatus implements PolicyStatus{

	@Override
	public void expirePolicy(Policy policy) {
		// TODO Auto-generated method stub
		policy.setPolicyStatus(new ExpiredPolicyState());
	}

	@Override
	public void cancelPolicy(Policy policy) {
		// TODO Auto-generated method stub
		policy.setPolicyStatus(new CancelPolicyStatus());
	}

	@Override
	public void renewPolicy(Policy policy) {
		// TODO Auto-generated method stub
		policy.setPolicyStatus(new ActivePolicyStatus());
	}
	
	

}
