package com.apurvtripathi.ekea.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="image_url")
	private String imageUrl;
	@Column(name="title")
	private String title;
	@Column(name="price")
	private int price;
	
	public Product() {
		
	}

	public Product(String imageUrl, String title, int price) {
		super();
		this.imageUrl = imageUrl;
		this.title = title;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

	@Override
	public String toString() {
		return "Product [id=" + id + ", imageUrl=" + imageUrl + ", title=" + title + ", price=" + price + "]";
	}
	
	
	

}
