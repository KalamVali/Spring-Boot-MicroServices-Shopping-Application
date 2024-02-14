package com.payment.entity;

import java.util.List;

import com.payment.model.Payment;

public class RequiredResponse {

	private Payment payment;
	private Product products;
	private List<Customer> customers;
	public RequiredResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequiredResponse(Payment payment, Product products, List<Customer> customers) {
		super();
		this.payment = payment;
		this.products = products;
		this.customers = customers;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Product getProducts() {
		return products;
	}
	public void setProducts(Product products) {
		this.products = products;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	@Override
	public String toString() {
		return "RequiredResponse [payment=" + payment + ", products=" + products + ", customers=" + customers + "]";
	}
	
	
}
