package com.Vcart.VcartManagement.Controller.Request;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "subcategory")
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subcatid")
	@NotNull
	private int subcatid;

	@NotBlank
	@JsonProperty("subcatname")
	private String subcatname;

	@JsonProperty
	@OneToOne(cascade = CascadeType.ALL, targetEntity = Product.class)
	@JoinColumn(name = "subcatid")
	private Product product;

	@NotBlank
	@JsonProperty
	private String category;

	@NotNull
	@JsonProperty
	private int quantity;

	public Items() {
	};

	public Items(@NotEmpty int subcatid, @NotBlank String subcatname, Product product, @NotBlank String category) {
		super();
		this.subcatid = subcatid;
		this.subcatname = subcatname;
		this.product = product;
		this.category = category;
	}

	public int getSubcatid() {
		return subcatid;
	}

	public void setSubcatid(int subcatid) {
		this.subcatid = subcatid;
	}

	public String getSubcatname() {
		return subcatname;
	}

	public void setSubcatname(String subcatname) {
		this.subcatname = subcatname;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Items [subcatid=" + subcatid + ", subcatname=" + subcatname + ", product=" + product + ", category="
				+ category + "]";
	}

}
