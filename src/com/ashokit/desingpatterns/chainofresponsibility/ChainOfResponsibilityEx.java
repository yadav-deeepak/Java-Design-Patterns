package com.ashokit.desingpatterns.chainofresponsibility;

public class ChainOfResponsibilityEx {

	public static void main(String[] args) {
		m1();
	}
	
	static void m1() {
		try {
			m2();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	static void m2() {
		m3();
	}
	static void m3() {
		int c = 10/0;
	}
}
/*The above code will throw the exception 
=> How JVM is throwing the exception ? 
=> Call stack is used to store the method calls so whenever exception occurs jvm will create exception object 
=> Then jvm will look in the call stack where the exception has occurred in the call stack in m3 it has occurred so it will throw ArithmeticException 
=> So it will look from where m3() is called then it will throw error there also and then like this whole call stack will throw the error 
=> If we have handled the exception in the m3() using try catch block then there wouldn't have any problem it would have thrown only ArithmeticException
=> Basically if we don't handle the exception it will throw the exception object in the calling method this is nothing but chain of responsibility design pattern */

