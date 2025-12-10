package com.ashokit.desingpatterns.builderdesignpattern;

public class UserWithBuilderPattern {
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "FirstName: "+firstName+ " LastName: "+lastName;
	}

	UserWithBuilderPattern(UserBuilder ub){
		this.firstName = ub.firstName;
		this.lastName = ub.lastName;
		this.age = ub.age;
		this.mobile = ub.mobile;
	}

	private String firstName;//required
	private String lastName;//required
	private int age;//not required
	private long mobile;//not required
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public long getMobile() {
		return mobile;
	}	
	
	static class UserBuilder{
		
		private String firstName;
		private String lastName;
		private int age;
		private long mobile;
		
		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}
		
		public UserBuilder mobile(long mobile) {
			this.mobile = mobile;
			return this;
		}
		
		// using the build() we will convert the UserBuilder object to UserWithBuilderPattern object
		UserWithBuilderPattern build() {
			UserWithBuilderPattern u = new UserWithBuilderPattern(this);
			return u;
		}

	
	}
	
	public static void main(String[] args) {
		//Now suppose here we want to create an object with all the fields 
		UserWithBuilderPattern u = new UserWithBuilderPattern.UserBuilder("Deepak", "Yadav").age(24).mobile(80906337).build();
		System.out.println(u);
		//Now for fn,ln
		UserWithBuilderPattern u1 = new UserWithBuilderPattern.UserBuilder("Viper", "Ankur").build();
		System.out.println(u1);
		// fn, ln, age
		UserWithBuilderPattern u2 = new UserWithBuilderPattern.UserBuilder("Suraj","Yadav").age(22).build();
		System.out.println(u2);
		//So hence like this using the builder design pattern we have solved the problem of object creation.
	}

}
/*
 * So what we will do is we will create an object for the required fields 
 * Then we will add the optional field that is provided to that object
 * Eg: firtName and lastName are the required fields so we will create object using these fields 
 * (fn,ln).add(age).add(mobile).build() //like this if user provides age and mobile number then we add it.
 * So this is how we create an object using the builder design pattern.
 * 
 * ## How do we do this ? 
 * -> So we will create an inner class in which i will declare the constructor with the required fileds
 */
