package com.payment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payment {

	@Id
	private int bankId;
	private int account_no;
	private String account_name;
	private double balance;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int bankId, int account_no, String account_name, double balance) {
		super();
		this.bankId = bankId;
		this.account_no = account_no;
		this.account_name = account_name;
		this.balance = balance;
	}
	public int getBank_Id() {
		return bankId;
	}
	public void setBank_Id(int bankId) {
		this.bankId = bankId;
	}
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Payment [bank_Id=" + bankId + ", account_no=" + account_no + ", account_name=" + account_name
				+ ", balance=" + balance + "]";
	}
	
}
