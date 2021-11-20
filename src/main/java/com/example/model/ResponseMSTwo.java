package com.example.model;

public class ResponseMSTwo {

	private RequestMSTwo requestMSTwo;
	private String itemDescription;
	
	public RequestMSTwo getRequestMSTwo() {
		return requestMSTwo;
	}
	public void setRequestMSTwo(RequestMSTwo requestMSTwo) {
		this.requestMSTwo = requestMSTwo;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	@Override
	public String toString() {
		return "ResponseMSTwo [requestMSTwo=" + requestMSTwo + ", itemDescription=" + itemDescription + "]";
	}
	
}
