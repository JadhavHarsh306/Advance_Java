package com.demo.beans;

import java.time.LocalDate;

public class Product {
	private int id;
	private String pname;
	private int qnty;
	private int price;
	private LocalDate date;
	public Product() {
		super();
	}
	public Product(int id, String pname, int qnty, int price, LocalDate date) {
		super();
		this.id = id;
		this.pname = pname;
		this.qnty = qnty;
		this.price = price;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQnty() {
		return qnty;
	}
	public void setQnty(int qnty) {
		this.qnty = qnty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", qnty=" + qnty + ", price=" + price + ", date=" + date
				+ "]";
	}
	
}
