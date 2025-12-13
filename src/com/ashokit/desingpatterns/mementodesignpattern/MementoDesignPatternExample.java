package com.ashokit.desingpatterns.mementodesignpattern;

public class MementoDesignPatternExample {

	public static void main(String[] args) {
		FeedbackForm form = new FeedbackForm("Kartik","karthik.abc@gmail.com","Food is good");
		FeedbackCaretaker careTaker = new FeedbackCaretaker();
		careTaker.saveState(form);
		
		form.setName("ABC");
		form.setEmail("abc@gmail.com");
		form.setComment("Form is filled");
		
		careTaker.restoreState(form);
	}
}

class FeedbackForm{ //originator 
	private String name;
	private String email;
	private String comment;
	public FeedbackForm(String name, String email, String comment) {
		this.name = name;
		this.email = email;
		this.comment = comment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	 
	FeedbackMemento save(FeedbackForm form){
		FeedbackMemento memento = new FeedbackMemento(form.getName(), form.getEmail(), form.getComment());
		return memento;
	}
	
	void restore(FeedbackMemento form) {
		this.name = form.getName();
		this.email = form.getEmail();
		this.comment = form.getComment();
		System.out.println("Name is "+name+" email id is "+email+" comment is "+comment);
	}
}

class FeedbackMemento{ //Memento 
	private String name;
	private String email;
	private String comment;
	public FeedbackMemento(String name, String email, String comment) {
		this.name = name;
		this.email = email;
		this.comment = comment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}

class FeedbackCaretaker{
	FeedbackMemento memento; 
	
	public void saveState(FeedbackForm form) {
		 memento = form.save(form);
	}
	
	public void restoreState(FeedbackForm form) {
		form.restore(memento);
	}
}