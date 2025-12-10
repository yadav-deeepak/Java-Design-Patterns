package com.ashokit.desingpatterns.singletondesignpattern;

public class Thread1 extends Thread{

	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread1 t2 = new Thread1();
		//Thread is nothing but a independent path of execution within a program
		
		t1.setName("Thread1");
		t2.setName("Thread2");
		
		t1.start();
		t2.start();
		
		//So here what will happen is both thread will go to the getInstance() and will create 2 objects hence breaking the singleton design pattern
		//So we have to stop this for this we will stop the threads to access the getInstance() at the same time
		//When t1 is accessing then t2 should not be able to access the getInstance() 
		//So we will make the getInstance() synchronized by using synchronized keyword.
		//This will solve the problem now the object will be created by the first thread and then when the second thread calls getInstance() then object is already present so it will not create another object 
		//Since the object is already present so for thread2 no new object will be created hence the singleton design pattern is achieved.
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		SingletonDesignPattern s = SingletonDesignPattern.getInstance();
		System.out.println(Thread.currentThread().getName());
		
	}
	
	
}
