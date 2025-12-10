package com.ashokit.desingpatterns.singletondesignpattern;

import java.io.Serializable;

public class SingletonDesignPattern implements Serializable {

	String name = "Deepak";

//	static SingletonDesignPattern s = new SingletonDesignPattern();//Eager Initialization
	// The problem with eager initialization is even when you don't want the object
	// you are getting the object
	// The object will be created when the class is loaded means even before calling
	// the get instance method the object is created at class level.

	// In order to overcome this problem we will use lazy initialization here we
	// will initialize the object as null
	// When the getInstance() is called then only the object will be created.
	static SingletonDesignPattern s = null;

	private SingletonDesignPattern() {
		// DB connection
		// Reading the data from the property file
		// getProperties.getInstance(); in your project if you want to know where you
		// are using the instance the use this method.
	}

	// In java Runtime class is following the singleton design pattern

	static SingletonDesignPattern getInstance() {

		System.out.println("Hi");

		if (s == null) {// Doubled checked Locking

			synchronized (SingletonDesignPattern.class) {
				if (s == null) {
					s = new SingletonDesignPattern();
				}
				return s;
			}
		}
		return s;
	}
	// Lets say there are 100 lines of code present in our getInstance() and we want
	// to synchronize only few line of code then we will use synchronized block
	// Now lock will be put only on the code that is present inside the synchronized
	// block remaining code will can be run freely.

	Object readResolve() {
		return s;
	}
	// Now the readResolve() is returning the same object so again singleton design
	// pattern is followed.

} 
