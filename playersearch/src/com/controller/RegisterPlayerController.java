package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bo.PlayerBO;
import com.bo.PlayerBOImpl;
import com.exception.BusinessException;
import com.to.Player;

/**
 * Servlet implementation class RegisterPlayerController
 */
public class RegisterPlayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterPlayerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlayerBO playerBO = new PlayerBOImpl();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Player player = (Player) session.getAttribute("player");
		
		try {
			player = playerBO.addPlayer(player);
			out.println("User have been registed succssfully!!");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.println("Bean object received at controller with details below:");
		out.println("<h2>"+player+"</h2>");
		response.setHeader("refresh", "3;url='/playersearch'");
	}
 }
