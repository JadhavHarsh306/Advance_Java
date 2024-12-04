package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Order;
import com.demo.beans.Product;

public class TestConstructorInjection {

	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("springconfig.xml");
		Product pr1=(Product)ctx.getBean("p1");
		System.out.println(pr1);
		Order Ord1=(Order)ctx.getBean("Ord1");
		System.out.println(Ord1);
	}

}
