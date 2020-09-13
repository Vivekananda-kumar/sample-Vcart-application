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

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="category")
public class Category {

	@NotBlank
	@Column(name = "categoryname")
	@JsonProperty
	private String categoryname;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryid")
	@JsonProperty
	private int categoryid;
	
	@JsonProperty
	@OneToOne(cascade = CascadeType.ALL, targetEntity = Items.class)
	@JoinColumn(name = "categoryid")
	private Items type;

	public String getCategory() {
		return categoryname;
	}

	public void setCategory(String category) {
		this.categoryname = category;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public Items getType() {
		return type;
	}

	public void setType(Items type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Category [category=" + categoryname + ", categoryid=" + categoryid + ", type=" + type + "]";
	}
	
}
