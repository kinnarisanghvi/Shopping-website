package com.me.Pojo;

import javax.persistence.*;

@Entity
@Table(name="Order_details")
public class OrderDetail {

	@Id
	@Column(name="ID", nullable=false)
	private String id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false,
    foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK") )
	private Order order;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false, //
    foreignKey = @ForeignKey(name = "ORDER_DETAIL_PROD_FK") )
	private Product product;
	
    @Column(name = "Quanity", nullable = false)
	private int quantity;
    
    @Column(name = "Price", nullable = false)
	private double price;
    
	@Column(name = "Amount", nullable = false)
	private double amount;
	    

    public Order getOrder() {
			return order;
		}

    public void setOrder(Order order) {
			this.order = order;
		}
	
    public int getQuantity() {
			return quantity;
		}
	
    public void setQuantity(int quantity) {
			this.quantity = quantity;
		}    
	    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
