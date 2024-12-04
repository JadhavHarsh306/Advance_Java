package com.demo.beans;

public class Order {
	private int oid;
	private int cid;
	private Product p;
	public Order() {
		super();
	}
	public Order(int oid, int cid, Product p) {
		super();
		this.oid = oid;
		this.cid = cid;
		this.p = p;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", cid=" + cid + ", p=" + p + "]";
	}
	
}
