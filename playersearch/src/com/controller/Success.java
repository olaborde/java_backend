package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;

/**
 * Servlet implementation class Success
 */
public class Success extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Success() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		if(session!=null) {
			String username = (String) session.getAttribute("username");
			out.print("<center>Hello, "+ username+ " You just logged in successfully!! :-)</center><br>");
			
			out.print("<center><a href='logout'>logout</a></center>");
			response.setHeader("refresh", "3;url='/playersearch'");
		}
		
		
//		out.println("<h2>User wit id" +
//		request.getParameter("username")+
//		"logged in succesfully at " + new Date()+"</h2>");
//		out.print("<a href=login.html>logout</a>");
	}
	
	



}
