package com.ashokit.desingpatterns.observerdesignpattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverDesignPatternExample {

	public static void main(String[] args) {
		Follower karthik = new Follower("Kartik");
		Follower babu = new Follower("Babu");
		Follower suraj = new Follower("Suraj");
		Follower deepak = new Follower("Deepak");
		Follower viper = new Follower("Viper");
		Follower arnab = new Follower("Arnab");
		Follower rashid = new Follower("Rashid");
		
		InsuranceCompany LIC = new InsuranceCompany("LIC");
		InsuranceCompany TATA = new InsuranceCompany("TATA AIA");
		
		LIC.addSubscriber(karthik);
		LIC.addSubscriber(viper);
		LIC.addSubscriber(suraj);
		LIC.addSubscriber(deepak);
		LIC.addSubscriber(babu);
		
		TATA.addSubscriber(arnab);
		TATA.addSubscriber(rashid);
		
		LIC.broadcastMessage("Hi Everyone -> new policy called Jeevan anand is introduced");
		TATA.broadcastMessage("Hey tata website is not available from 12am to 1pm");
	}
}

interface FollowerNotification{
	void notification(String tweet);
}

class Follower implements FollowerNotification{
	String name;
	
	Follower(String name){
		this.name = name;
	}

	@Override
	public void notification(String tweet) {
		// TODO Auto-generated method stub
		System.out.println(name+" has notification received "+ tweet);
	}
	
}

interface ManageSubscriberAndNotify{
	
	public void addSubscriber(FollowerNotification r);
	public void removeSubscriber(FollowerNotification r);
	public void notifyAllSubscriber(String tweet);
}

class InsuranceCompany implements ManageSubscriberAndNotify{

	String name;
	InsuranceCompany(String name){
		this.name = name;
	}
	
	List<FollowerNotification> subscriberList = new ArrayList<>();
	
	@Override
	public void addSubscriber(FollowerNotification r) {
		// TODO Auto-generated method stub
		subscriberList.add(r);
	}

	@Override
	public void removeSubscriber(FollowerNotification r) {
		// TODO Auto-generated method stub
		subscriberList.remove(r);
	}

	@Override
	public void notifyAllSubscriber(String tweet) {
		// TODO Auto-generated method stub
		subscriberList.forEach(f -> f.notification(tweet));
	}
	
	public void broadcastMessage(String tweet) {
		notifyAllSubscriber(tweet);
	}
	
	
}