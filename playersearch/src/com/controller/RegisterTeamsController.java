package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bo.TeamBO;
import com.bo.TeamsBOImpl;
import com.exception.BusinessException;
import com.to.Teams;

/**
 * Servlet implementation class RegisterTeamsController
 */
public class RegisterTeamsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterTeamsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeamBO teamBO = new TeamsBOImpl();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Teams teams = (Teams) session.getAttribute("teams");
		
		try {
			teams = teamBO.addTeams(teams);
			out.println("Team have been registed successfully!!");
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		out.println("Bean object received at controller with details below:");
		out.println("<h2>"+teams+"</h2>");
		response.setHeader("refresh", "3;url='/playersearch'");
		
	
	}

}
