package com.ashokit.desingpatterns.statedesignpattern;

public class Policy {

	private PolicyStatus policyStatus;
	
	public Policy(PolicyStatus policystatus) {
		this.policyStatus= policystatus;
	}
	
	public void setPolicyStatus(PolicyStatus p) {
		this.policyStatus= p;
	}
	
	public void expirePolicy(Policy p) {
		policyStatus.expirePolicy(p);
	}
	
	public void renewPolicy(Policy p) {
		policyStatus.renewPolicy(p);
	}
	
	public void cancelPolicy(Policy p) {
		policyStatus.cancelPolicy(p);
	}
}
