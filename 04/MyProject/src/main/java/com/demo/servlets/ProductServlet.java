package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ProductService pserv=new ProductServiceImpl();
		List<Product> lst= new ArrayList<>();
		lst=pserv.getAllProduct();
		out.println("<table> <tr><th>Product Id</th><th>Product Name</th><th>Quantity</th><th>Price</th><th>Expiry Date</th></tr></table>");
		for(Product p: lst) {
			out.print("<tr><td>"+ p.getId() +"</td> <td>"+ p.getPname() +"</td> <td>"+p.getQnty()+"</td> <td>"+p.getPrice()+"</td> <td><");
			String date= p.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			out.print(""+date+"</td></tr></table>");
		}
	}

}
