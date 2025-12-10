package com.ashokit.desingpatterns.singletondesignpattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SingletonDesignPattern s = SingletonDesignPattern.getInstance();
		SingletonDesignPattern s1 = SingletonDesignPattern.getInstance();
		
		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());
		
		FileOutputStream f = new FileOutputStream("C:\\Users\\deepa\\OneDrive\\Desktop\\serializableDocs.txt");
		ObjectOutputStream obj = new ObjectOutputStream(f);
		obj.writeObject(s);
		
		//Object s is converted into a series of bytes using this writeObject() and then it is written to serializableDocs text file
		//To read this file we need to write the DeSerialization code 
		
		FileInputStream f1 = new FileInputStream("C:\\\\Users\\\\deepa\\\\OneDrive\\\\Desktop\\\\serializableDocs.txt");
		ObjectInputStream in = new ObjectInputStream(f1);
		SingletonDesignPattern s4 = (SingletonDesignPattern)in.readObject();
		System.out.println(s4.name);
		System.out.println(s4.hashCode());
		
		//If we use this we can see that the singleton design pattern is broken because readObject() is internally calling the readResolve().
		//readResolve() is responsible for creating the new object so what we will do is we will override the readResolve() method.
		//When we override it we will return the same object s
		
	}
	//During run it checks magical number(In this it will check if the class code is correct or not)
	//Then it will load the class -> Class Loader 
	//Load, Link, Initialize 
	
	// Different ways in which we can break the singleton design pattern 
	// 1. Reflection : For this we will check if s == null means object is not created then we will created the object else we will return the same object s
	// 2. Cloning : For cloning we have to override the clone method and there return the object then it will follow the singleton pattern
	// 3. Serialization : For this we have to override the readResolve() and there we will return the object s 
	// 4. MultiThreading
	
}
//To make a class follow singleton design pattern we need to make: 
//1. Constructor private so that its variable can't be created outside the class
//2. Then either using eager initialization we will create a global object of the class inside the class or we can do lazy initialization 
// In lazy initialization we will create a getInstance method inside which we will create the object of the class and we will create a global reference variable
// and assign it to null in getInstance method we will first check if the s == null then only the new object should be created else it should return the same object s.

