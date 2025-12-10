package com.ashokit.desingpatterns.decorateddesignpattern;

public class DecoratorPatternExample {

	public static void main(String[] args) {
		BasicPlan kartikPolicy = new BasePolicy();
		System.out.println(kartikPolicy.getPremium());
		System.out.println(kartikPolicy.policyDetails());
		
		BasicPlan surajPolicy = new BasePolicy();
		System.out.println(surajPolicy.getPremium());
		System.out.println(surajPolicy.policyDetails());
		
		//Suppose Suraj doesn't want to take the same policy he wants to add some more things to this base policy 
		//If we add anything in the BasePolicy class then it will affect every other object of the class  so for doing this we will be using decorator design pattern
		
		surajPolicy = new AccidentalBenefit(surajPolicy);
		System.out.println(surajPolicy.getPremium());
		System.out.println(surajPolicy.policyDetails());
		
		surajPolicy = new CriticalBenefit(surajPolicy);
		System.out.println(surajPolicy.getPremium());
		System.out.println(surajPolicy.policyDetails());
		
		//So like this here by using AccidentalBenefit class i am able to modify the behaviour of the single object of the class without affecting the another objects.
	}
}

interface BasicPlan{
	int getPremium();
	String policyDetails();
}

class BasePolicy implements BasicPlan{

	@Override
	public int getPremium() {
		// TODO Auto-generated method stub
		return 1566;
	}

	@Override
	public String policyDetails() {
		// TODO Auto-generated method stub
		return "This is a basic plan";
	}
	
}

abstract class PolicyDecorator implements BasicPlan{
	BasicPlan basicPlan;
	
	PolicyDecorator(BasicPlan basicPlan){
		this.basicPlan = basicPlan;
	}

	@Override
	public int getPremium() {
		// TODO Auto-generated method stub
		return basicPlan.getPremium();
	}

	@Override
	public String policyDetails() {
		// TODO Auto-generated method stub
		return basicPlan.policyDetails();
	}
		
}

class AccidentalBenefit extends PolicyDecorator{
	
	AccidentalBenefit(BasicPlan basicPlan){
		super(basicPlan);
	}

	@Override
	public int getPremium() {
		// TODO Auto-generated method stub
		return super.getPremium()+58;
	}

	@Override
	public String policyDetails() {
		// TODO Auto-generated method stub
		return super.policyDetails()+" Accidental Cover is provided ";
	}	
	
}

class CriticalBenefit extends PolicyDecorator{
	
	CriticalBenefit(BasicPlan basicPlan){
		super(basicPlan);
	}

	@Override
	public int getPremium() {
		// TODO Auto-generated method stub
		return super.getPremium()+650;
	}

	@Override
	public String policyDetails() {
		// TODO Auto-generated method stub
		return super.policyDetails()+"and Critical Cover is provided ";
	}	
	
}
/*
 * So for doing this we will write another class decorator which will implement the BasicPlan interface
 * Using that class we will create another class called AccidentalBenefit  
 * */
