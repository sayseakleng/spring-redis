package com.kdemo.redis.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {
	private static final long serialVersionUID = -2618466647210537356L;
	
	private String productId;
	private String productName;
	
	public ProductDto() {
	
	}
	
	public ProductDto(String productId, String productName) {
		this.productId = productId;
		this.productName = productName;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + "]";
	}
}
