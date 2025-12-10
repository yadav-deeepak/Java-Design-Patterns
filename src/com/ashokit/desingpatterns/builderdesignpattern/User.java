package com.ashokit.desingpatterns.builderdesignpattern;

public class User {

	private String firstName;
	private String lastName;
	private int age;
	private long mobile;
	
	public User(String firstName, String lastName, int age, long mobile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.mobile = mobile;
	}
	
	public static void main(String[] args) {
		//fn,ln,age,mobile
		//fn,ln
		//fn,ln,age
		//fn,ln,mobile
		//Suppose we want to provide information like this fn and ln are required field so it should be present but age and mobile number may or may not be present 
		//So for this we have to create 4 constructors because if use use the all args constructor then we have to give the value 0 or null for age and mobile which is not correct
		//So if we have more fields then we have to create more constructors this is one of the problems that will occur
		//Another problem is while passing the data user might make a mistake and pass wrong data in wrong field like in place of firstName he gives lastName these problems are called as object creation problems.
	}
	
}
/*
-> If I want to make the above class immutable then we will declare the class as final and its member variable as final.

 */
 