package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bo.UserRegistrationBO;
import com.bo.UserRegistrationBOImpl;
import com.exception.BusinessException;
import com.model.User;

/**
 * Servlet implementation class signupController
 */
public class signupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserRegistrationBO bo = new UserRegistrationBOImpl();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		try {
			user = bo.addUser(user);
			out.println("user have signed up successfully");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		out.println("Bean object received at controller with details below:");
		out.println("<h2>"+user.getUsername()+"</h2>");
//		response.setHeader("refresh", "3;url='/playersearch'");
	}

}
