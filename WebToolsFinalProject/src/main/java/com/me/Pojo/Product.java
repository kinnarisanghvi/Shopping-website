package com.me.Pojo;

import javax.persistence.*;

@Entity
@Table(name="Product")
public class Product {

	@Id
	@Column(name = "ProductID", length = 20, nullable = false)
	private int ID;
	
	
	@Column(name = "ProductName", length = 20, nullable = false)
	private String pName;
	
	@Column(name = "ProductType", length = 20, nullable = false)
	private String pType;
	
	@Column(name = "ProductPrice", length = 20, nullable = false)
	private float pPrice;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public Float getpPrice() {
		return pPrice;
	}
	public void setpPrice(Float pPrice) {
		this.pPrice = pPrice;
	}
	
	 
}
