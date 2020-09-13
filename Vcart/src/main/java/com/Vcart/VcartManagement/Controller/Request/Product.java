package com.Vcart.VcartManagement.Controller.Request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "product1")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productid")
	@JsonProperty
	private int productid;
	@NotBlank
	@JsonProperty
	private String productname;
	@NotNull
	@JsonProperty
	private double mrp;
	@NotNull
	@JsonProperty
	private int quantity;
	@NotNull
	@JsonProperty
	private int subcatid;

	public Product() {
	};

	public Product(int productid, String productname, double mrp, int quantity, int subcatid) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.mrp = mrp;
		this.quantity = quantity;
		this.subcatid = subcatid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {

		this.quantity = quantity;
	}

	public int getSubcatid() {
		return subcatid;
	}

	public void setSubcatid(int subcatid) {
		this.subcatid = subcatid;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", mrp=" + mrp + ", quantity="
				+ quantity + ", subcatid=" + subcatid + "]";
	}

}
