//package com.ashokit.desingpatterns.abstactfactorypatterrn;
//
//public class EcommerceAbstractFactory {
//
//	public static void main(String[] args) {
//		
//	}
//}
//
//interface ProductFamily{
//	
//	Product createProduct();
//	
//}
//
//interface Product{
//	public void info();
//	public void price();
//}
//
//class ProductFactory{
//	 
//	Product getProduct(String type){
//		if("Mobile".equalsIgnoreCase(type)) {
//			return new Mobile();
//		}
//		if("Television".equalsIgnoreCase(type)) {
//			return new Television();
//		}
//		if("Dishwasher".equalsIgnoreCase(type)) {
//			return new Television();
//		}
//		return null;
//	}
//}
//
//class Mobile implements Product{
//
//	@Override
//	public void info() {
//		// TODO Auto-generated method stub
//		System.out.println("Mobile Phone");
//	}
//
//	@Override
//	public void price() {
//		// TODO Auto-generated method stub
//		System.out.println("Mobile Phone Price is 10000");
//	}
//	
//}
//
//class DishWasher implements Product{
//
//	@Override
//	public void info() {
//		// TODO Auto-generated method stub
//		System.out.println("DishWasher");
//	}
//
//	@Override
//	public void price() {
//		// TODO Auto-generated method stub
//		System.out.println("DishWasher Price is 30000");
//	}
//	
//}
//
//class Television implements Product{
//
//	@Override
//	public void info() {
//		// TODO Auto-generated method stub
//		System.out.println("Television");
//	}
//
//	@Override
//	public void price() {
//		// TODO Auto-generated method stub
//		System.out.println("TV price is 20000");
//	}
//	
//}
//
//class AbstractProductFamily{
//	Product getProductFamily(String category){
//		if("Electronics".equalsIgnoreCase(category)) {
//			switch(key) {
//			case value: "Mobile";
//			break;
//			}
//		}
//		if("KitchenAppliances".equalsIgnoreCase(category)) {
//			return new KitchenAppliances();
//		}
//		return null;
//	}
//}
//
//class Electronic implements ProductFamily{
//
//	Product p;
//	Electronic(Product p){
//		this.p = p;
//	}
//	
//	@Override
//	public Product createProduct() {
//		// TODO Auto-generated method stub
//		return p;
//	}
//		
//}
//
//class KitchenAppliances implements ProductFamily{
//
//	Product p;
//	
//	KitchenAppliances(Product p){
//		this.p = p;
//	}
//	@Override
//	public Product createProduct() {
//		// TODO Auto-generated method stub
//		return p;
//	}
//		
//}
//
//
