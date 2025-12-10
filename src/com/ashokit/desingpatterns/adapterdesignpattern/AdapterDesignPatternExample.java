package com.ashokit.desingpatterns.adapterdesignpattern;

public class AdapterDesignPatternExample {

	public static void main(String[] args) {
		AshokIt as = new AshokIt();
		as.setPaymentType("UPI");
	    as.setDetails("12346789");
	    
	    Paytm paytm = PaymentAdapter.ConvertBillDeskToPaytm(as);
	}
	
}

interface BillDesk{
	void setPaymentType(String paymentType);
	String getPaymentType();
	void setDetails(String data);
	String getDetails();
}

interface Paytm {
	void setTypeOfPayment(String paymentType);
	String getTypeOfPayment();
	void provideDetails(String data);
	String getDetails(); 
}

class PaymentAdapter implements BillDesk{
	static Paytm p = null;
	
	PaymentAdapter(Paytm p){
		this.p = p;
	}

	@Override
	public void setPaymentType(String paymentType) {
		// TODO Auto-generated method stub
		
	}
	
	static Paytm ConvertBillDeskToPaytm(BillDesk b){
		p.setTypeOfPayment(b.getPaymentType());
		p.provideDetails(b.getDetails());
		return p;
	}

	@Override
	public String getPaymentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDetails(String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return null;
	}
}

class AshokIt implements BillDesk{

	String PaymentType = null;
	String data = null;
	@Override
	public void setPaymentType(String paymentType) {
		// TODO Auto-generated method stub
		this.PaymentType = paymentType;
	}

	@Override
	public String getPaymentType() {
		// TODO Auto-generated method stub
		return PaymentType;
	}

	@Override
	public void setDetails(String data) {
		// TODO Auto-generated method stub
		this.data = data;
	}

	@Override
	public String getDetails() {
		// TODO Auto-generated method stub
		return data;
	}
	
	
}
/*
 * 
 */