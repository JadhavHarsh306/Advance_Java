package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.LoginUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Login() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("uname");
		String passwd=request.getParameter("pass");
		LoginService ls= new LoginServiceImpl();
		LoginUser us=ls.validateUser(uname,passwd);
//		System.out.println(us.getUname()+"------"+us.getPass());
		if(us!=null) {
			if(us.getRole().equals("admin") && us.getUname().equals(uname) && us.getPass().equals(passwd)) {
				RequestDispatcher rd= request.getRequestDispatcher("ProductServlet");
				rd.forward(request, response);
			}
			else {
				out.println("<h2>Not Admin</h2>");
				RequestDispatcher rd= request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
