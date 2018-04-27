package com.me.Pojo;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "categoryId", length = 20, nullable=false)
	private int ID;
	
	@Column(name="categoryName")
	private String categoryName;
	
	
	@OneToMany(mappedBy="category")
	private List<Product> products;
	
    public void addProduct(Product p) {
    	
    	products.add(p);
    }
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setID(int iD) {
		ID = iD;
	}


	public int getID() {
		return ID;
	}

	public void setCategoryId(int ID) {
		this.ID = ID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
