package com.capgemini.collectionsexample;

import java.util.Date;

public class Customer {
	
	private int cid;
	private String custname;
	private int age;
	private Date date;
	private String email;
	private long mobileno;
	
	Customer()
	{
		
	}

	public Customer(int cid, String custname, int age, Date date, String email, long mobileno) {
		super();
		this.cid = cid;
		this.custname = custname;
		this.age = age;
		this.date = date;
		this.email = email;
		this.mobileno = mobileno;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}

}
