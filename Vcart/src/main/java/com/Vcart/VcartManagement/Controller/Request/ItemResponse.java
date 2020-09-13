package com.Vcart.VcartManagement.Controller.Request;

import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonProperty;


@Provider
public class ItemResponse {

	@JsonProperty
	private String productname;

	@JsonProperty
	private int productid;

	@JsonProperty
	private int categoryid;

	@JsonProperty
	private String categoryname;

	@JsonProperty
	private int subcategoryid;

	@JsonProperty
	private String subcategoryname;

	@JsonProperty
	private double amount;

	@JsonProperty
	private int quantity;

	public ItemResponse() {
	};

	public ItemResponse(String productname, int productid, int categoryid, String categoryname, int subcategoryid,
			String subcategoryname, int amount, int quantity) {
		super();
		this.productname = productname;
		this.productid = productid;
		this.categoryid = categoryid;
		this.categoryname = categoryname;
		this.subcategoryid = subcategoryid;
		this.subcategoryname = subcategoryname;
		this.amount = amount;
		this.quantity = quantity;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public int getSubcategoryid() {
		return subcategoryid;
	}

	public void setSubcategoryid(int subcategoryid) {
		this.subcategoryid = subcategoryid;
	}

	public String getSubcategoryname() {
		return subcategoryname;
	}

	public void setSubcategoryname(String subcategoryname) {
		this.subcategoryname = subcategoryname;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double d) {
		this.amount = d;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int i) {
		this.quantity = i;
	}

	@Override
	public String toString() {
		return "ItemResponse [productname=" + productname + ", productid=" + productid + ", categoryid=" + categoryid
				+ ", categoryname=" + categoryname + ", subcategoryid=" + subcategoryid + ", subcategoryname="
				+ subcategoryname + ", amount=" + amount + ", quantity=" + quantity + "]";
	}

}
