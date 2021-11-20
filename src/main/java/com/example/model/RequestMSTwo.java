package com.example.model;

public class RequestMSTwo {

	private String itemName;
	private String tokenToValidate;
	
	
	public String getTokenToValidate() {
		return tokenToValidate;
	}

	public void setTokenToValidate(String tokenToValidate) {
		this.tokenToValidate = tokenToValidate;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "RequestMSTwo [itemName=" + itemName + ", tokenToValidate=" + tokenToValidate + "]";
	}
	
	
	
}
