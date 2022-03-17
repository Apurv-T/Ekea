package com.apurvtripathi.ekea.entity;

import java.util.ArrayList;
import java.util.List;


public class Cart {
	
	private List<Product> products;
	
	public Cart() {
	}
	
	public Cart(List<Product> products) {
		super();
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addProduct(Product product) {
		if(this.products==null) {
			this.products=new ArrayList<Product>();
		}
		this.products.add(product);
		
	}

	@Override
	public String toString() {
		return "Cart [products=" + products + "]";
	}

	public void removeProduct(int theId) {
		for(int i=0;i<this.products.size();i++) {
			if(i==theId) {
				this.products.remove(i);
			}
		}
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
