package com.example.demo;

public class ProductInfo {
	
	private int productId;
	private String productInfo;
	
	public ProductInfo() {
		super();
		
		
	}
	
	public ProductInfo(int productId) {
		super();
		this.productId = productId;
		
	}
	
	public ProductInfo(int productId, String productInfo) {
		super();
		this.productId = productId;
		this.productInfo = productInfo;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getproductInfo() {
		return productInfo;
	}
	public void setproductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	
	

}
