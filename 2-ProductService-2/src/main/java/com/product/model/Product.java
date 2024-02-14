package com.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	private int companyId;
	private int proId;
	private String proName;
	private double price;
	private int quantity;
	private double discount;
	private double total;
	private int bankId;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int companyId, int proId, String proName, double price, int quantity, double discount, double total,
			int bankId) {
		super();
		this.companyId = companyId;
		this.proId = proId;
		this.proName = proName;
		this.price = price;
		this.quantity = quantity;
		this.discount = discount;
		this.total = total;
		this.bankId = bankId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	@Override
	public String toString() {
		return "Product [companyId=" + companyId + ", proId=" + proId + ", proName=" + proName + ", price=" + price
				+ ", quantity=" + quantity + ", discount=" + discount + ", total=" + total + ", bankId=" + bankId + "]";
	}
	
}
