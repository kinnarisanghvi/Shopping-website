package com.me.Pojo;

import javax.persistence.*;

@Entity
@Table(name="Orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "orderId" , unique = true)
	private int orderID;
	
	@Column(name="prodName")
	private String prodName;
	
	@Column(name="orderDate")
	private String date;
	
	@Column(name="prodQuantity")
	private int prodQuantity;
	
	@ManyToOne
	@JoinColumn(name="userId", nullable = false)
	private Users user;

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getProdQuantity() {
		return prodQuantity;
	}

	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}



}
