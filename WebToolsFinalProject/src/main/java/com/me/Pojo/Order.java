package com.me.Pojo;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Order")
class Order{
	
	@Id
	@Column(name="ID",length=50)
	private String id;
	
	@Column(name="orderDate", nullable=false)
	private Date orderDate;
	
	@Column(name = "Order_Number", nullable = false)
	private int order_number;
	
	@Column(name = "amount", nullable = false)
	private double amount;
	
	@ManyToOne
	@JoinColumn(name = "User_ID", nullable = false, //
    foreignKey = @ForeignKey(name = "User_ID_ORD_FK") )
	private Users user;
	
	public Users getUser() {
		return user;
	}
	
	public void setUsers(Users user) {
		this.user = user;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public int getOrder_number() {
		return order_number;
	}
	
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	    
}
