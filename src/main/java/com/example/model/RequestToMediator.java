package com.example.model;

public class RequestToMediator {
	
	private String itemName;
	private String tokenToValidate;
	private String isValidToken;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getTokenToValidate() {
		return tokenToValidate;
	}
	public void setTokenToValidate(String tokenToValidate) {
		this.tokenToValidate = tokenToValidate;
	}
	public String getIsValidToken() {
		return isValidToken;
	}
	public void setIsValidToken(String isValidToken) {
		this.isValidToken = isValidToken;
	}
	@Override
	public String toString() {
		return "RequestToMediator [itemName=" + itemName + ", tokenToValidate=" + tokenToValidate + ", isValidToken="
				+ isValidToken + "]";
	}
	
}
