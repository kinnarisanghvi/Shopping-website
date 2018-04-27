package com.me.Pojo;

import javax.persistence.*;

@Entity
@Table(name="Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", length = 20, nullable = false)
	private int ID;
	
	@Column(name = "PName", length = 20, nullable = false)
	private String pName;
	
	@Column(name = "PCode", length = 20, nullable = false)
	private String pCode;
	
	@Column(name = "PPrice", length = 20, nullable = false)
	private float pPrice;
	
	@Column(name = "PDescription", length = 20, nullable = false)
	private String description;
	
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setpPrice(float pPrice) {
		this.pPrice = pPrice;
	}
	@ManyToOne
	@JoinColumn(name="categoryid", nullable=false)
	private Category category;	
	
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
	
	public Float getpPrice() {
		return pPrice;
	}
	public void setpPrice(Float pPrice) {
		this.pPrice = pPrice;
	} 
}
