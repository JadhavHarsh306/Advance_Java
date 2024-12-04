package com.demo.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Product implements BeanNameAware,ApplicationContextAware,BeanFactoryAware,InitializingBean,DisposableBean{
	private int pid;
	private String pname;
	private String expdate;
	private int cid;
	public Product() {
		super();
	}
	public Product(int pid, String pname, String expdate, int cid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.expdate = expdate;
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getExpdate() {
		return expdate;
	}
	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", expdate=" + expdate + ", cid=" + cid + "]";
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("In Destory Method");
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("In After Properties Set Method");
		
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("In Set Bean Factory Method");
		
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("Set Application Context Method");
	}
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("Set Bean Name Method"+name);
	}
	
	public void MyInit() {
		System.out.println("In Custom Init Method");
	}
	public void MyDestroy() {
		System.out.println("In Custom Destory Method");
	}
	
}
