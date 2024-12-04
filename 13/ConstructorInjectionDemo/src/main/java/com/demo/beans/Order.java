package com.demo.beans;

public class Order {
	private int oid;
	private String oname;
	private Product p;
	public Order() {
		super();
	}
	public Order(int oid, String oname, Product p) {
		super();
		this.oid = oid;
		this.oname = oname;
		this.p = p;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", oname=" + oname + ", p=" + p + "]";
	}
	
}
