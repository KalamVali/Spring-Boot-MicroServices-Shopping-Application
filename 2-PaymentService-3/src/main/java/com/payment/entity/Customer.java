package com.payment.entity;


public class Customer {

	
	private int cid;
	private String name;
	private String email;
	private long mobile_no;
	private String address;
	private int companyId;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int cid, String name, String email, long mobile_no, String address, int companyId) {
		super();
		this.cid = cid;
		this.name = name;
		this.email = email;
		this.mobile_no = mobile_no;
		this.address = address;
		this.companyId = companyId;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", email=" + email + ", mobile_no=" + mobile_no
				+ ", address=" + address + ", company_id=" + companyId + "]";
	}
	
}
