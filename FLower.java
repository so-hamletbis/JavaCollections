package com.capgemini.collectionsexample;

public class FLower {
	private int fid;
	private String fname;
	private double price;
	private int qty;
	
	FLower()
	{
		
	}
	
	FLower(int fid,String fname,double price,int qty)
	{
		 this.fid = fid;
		 this.fname = fname;
		 this.price = price;
		 this.setQty(qty);
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

}
