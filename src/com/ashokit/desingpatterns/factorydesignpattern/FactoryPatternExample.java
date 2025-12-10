package com.ashokit.desingpatterns.factorydesignpattern;

public class FactoryPatternExample {

	public static void main(String[] args) {
		Factory f = new Factory();
		Notification n = f.createNotification("SMS");
		n.notifi();
		Notification n1 = f.createNotification("Email");
		n1.notifi();
	}
}

interface Notification{
	public void notifi();
}

class SMSNotification implements Notification {
	
	@Override
	public void notifi() {
		System.out.println("Triggering notification through SMS");
	}
}

class EmailNotification implements Notification {
	
	@Override
	public void notifi() {
		System.out.println("Triggering notification through Email");
	}
}

class Factory {
	public Notification createNotification(String mode) {
		
		if(mode.equalsIgnoreCase("SMS")) {
			Notification n = new SMSNotification();
			return n;
		}
		if(mode.equalsIgnoreCase("Email")) {
			Notification n = new EmailNotification();
			return n;
		}
		return null;
	}
}