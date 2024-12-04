package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Product;

public class TestSpringLifeCycle {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		Product p=(Product)ctx.getBean(Product.class);
		System.out.println(p);
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
