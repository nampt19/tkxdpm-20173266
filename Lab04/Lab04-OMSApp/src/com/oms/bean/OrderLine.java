package com.oms.bean;

public class OrderLine {
	private String productId;
	private String productTitle;
	private float productCost;
	private int productQuantity;
	private float weight;
	public OrderLine(){
	}
	
	public OrderLine(String productId, String productTitle, int productQuantity, float productCost,float weight) {
		super();
		this.productId = productId;
		this.productTitle = productTitle;
		this.productCost = productCost;
		this.productQuantity = productQuantity;
		this.weight = weight;
	}
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public float getProductCost() {
		return productCost;
	}

	public void setProductCost(float productCost) {
		this.productCost = productCost;
	}

	public int getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "OrderLine{" +
				"productId='" + productId + '\'' +
				", productTitle='" + productTitle + '\'' +
				", productCost=" + productCost +
				", productQuantity=" + productQuantity +
				", weight=" + weight +
				'}';
	}
}
