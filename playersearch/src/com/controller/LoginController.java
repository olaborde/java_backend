package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.bo.LoginBOImpl;
import com.exception.BusinessException;
import com.model.User;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		
		try {
			if(new LoginBOImpl().isValidUser(user)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", user.getUsername());
				
				response.sendRedirect("success");
				
			
				
//				rd=request.getRequestDispatcher("success");
//				rd.forward(request, response);
				
				//change url create new request, do not get the value
//				response.sendRedirect("success");
				
			}
			
		} catch (BusinessException e) {
			rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
			out.println("<div align='center' style='color:red' >"+ e.getMessage());
		}
		
	}

}
