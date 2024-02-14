package com.product.entity;

import java.util.List;

import com.product.model.Product;

public class RequiredResponse {

	private Product product;
	private List<Customer> customer;
	public RequiredResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequiredResponse(Product product, List<Customer> customer) {
		super();
		this.product = product;
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "RequiredResponse [product=" + product + ", customer=" + customer + "]";
	}
	
}
