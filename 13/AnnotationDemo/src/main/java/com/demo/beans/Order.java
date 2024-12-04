package com.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("o1")
public class Order {
	@Value("1")
	private int oid;
	@Value("Furniture")
	private String oname;
	@Autowired
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
