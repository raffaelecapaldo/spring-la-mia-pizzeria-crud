package org.java.app.business.pojo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 100, nullable = false)
	private String name;
	private String description;
	private String imageUrl;
	
	@Column(nullable = false)
	private int price;
	
	public Pizza() { }
	public Pizza(String name, String description, String imageUrl, int price) {
		setName(name);
		setDescription(description);
		setImageUrl(imageUrl);
		setPrice(price);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) throws Exception {
		if (price < 0) 
			throw new Exception("Price can't be less than zero");
			
		this.price = price*100;
	}
	
	@Override
	public String toString() {
		return "[ID]: " + getId() 
				+ "[Name]: " + getName()
				+ "[Description]" + getDescription()
				+ "[Image url]: " + getImageUrl()
				+ "[Price] : " + getPrice()/100;
	}
	
	
	
}
