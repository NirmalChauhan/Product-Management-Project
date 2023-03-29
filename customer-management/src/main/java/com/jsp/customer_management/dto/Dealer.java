package com.jsp.customer_management.dto;

public class Dealer {
	
	private int dealerId;
	private String dealerName;
	private String dealerEmail;
	private Long dealerPhone;
	
	
	public int getdealerId() {
		return dealerId;
	}
	public void setdealerId(int dealerId) {
		this.dealerId = dealerId;
	}
	public String getdealerName() {
		return dealerName;
	}
	public void setdealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public String getdealerEmail() {
		return dealerEmail;
	}
	public void setdealerEmail(String dealerEmail) {
		this.dealerEmail = dealerEmail;
	}
	public Long getdealerPhone() {
		return dealerPhone;
	}
	public void setdealerPhone(Long dealerPhone) {
		this.dealerPhone = dealerPhone;
	}

}
