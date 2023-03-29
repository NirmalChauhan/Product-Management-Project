package com.jsp.customer_management.dto;

public class Product {
	
	private int productId;
	private String productName;
	private double productPrice;
	private boolean productAvailable;
	private Dealer dealer;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public boolean getProductAvailable() {
		return productAvailable;
	}
	public void setProductAvailable(boolean productAvailable) {
		this.productAvailable = productAvailable;
	}
	public Dealer getDealer() {
		return dealer;
	}
	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
	
}
