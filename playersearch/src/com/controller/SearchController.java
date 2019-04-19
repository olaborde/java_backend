package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bo.SearchBO;
import com.bo.SearchBOImpl;
import com.exception.BusinessException;
import com.to.Player;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private SearchBO searchBO;;

	private SearchBO getSearchBO() {
		if (searchBO == null) {
			searchBO = new SearchBOImpl();
		}
		return searchBO;
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int choice = Integer.parseInt(request.getParameter("criteria"));
		try {
			searchBO = getSearchBO();
			String headers[] = { "Player Id", "Name", "DOB", "Gender", "Contact", "Email", "TeamName" };
			switch (choice) {
			case 1:
				System.out.println("IDDDD");
				String id = request.getParameter("searchValue");

				Player player = searchBO.getPlayerById(id);
				if (player != null) {

					List<Player> playerList = new ArrayList<>();
					playerList.add(player);
					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("playerList", playerList);
					response.sendRedirect("results.jsp");

				}

				break;
			case 2:
				System.out.println("Nameeeeee");
				String name = request.getParameter("searchValue");

				List<Player> playerListName = searchBO.getPlayerByName(name);
				if (playerListName != null && playerListName.size() > 0) {

					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("playerList", playerListName);
					response.sendRedirect("results.jsp");

				}
//		case 2:
//			System.out.println("Please enter the player contact");
//			Long contact = request.getParameter("searchValue");
//			try {
//				Player player = searchBO.getPlayerByContact(contact);
//				if (player != null) {
//					System.out.println("Player found with contact " + contact);
//					System.out.println("Player details" + player);
//				}
//			} catch (BusinessException e1) {
//				// TODO Auto-generated catch block
//				System.out.println(e1.getMessage());
//			}
//
//			break;
//		case 3:
//			System.out.println("Please enter your email");
//			String Email =request.getParameter("searchValue");
//
//			try {
//				Player player = searchBO.getPlayerByEmail(Email);
//				if (player != null) {
//					System.out.println("Player found with contact " + Email);
//					System.out.println("Player details" + player);
//				}
//			} catch (BusinessException e1) {
//				// TODO Auto-generated catch block
//				System.out.println(e1.getMessage());
//			}
//
//			break;
//		case 4:
//			System.out.println("Please enter the player date of birth (dd-mm-yyyy) ");
//
//			String s = br.readLine();
//
//			SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
//			formatDate.setLenient(false);
//
//			try {
//
//				Date dob = formatDate.parse(s);
//
//				System.out.println("testt " + dob);
//				try {
//					List<Player> playerList = searchBO.getPlayerByDOB(dob);
//					if (playerList != null && playerList.size() > 0) {
//						System.out.println("you found" + playerList.size() + " mo of players");
//						System.err.println("Player/s Details: ");
//						for (Player p : playerList) {
//							System.out.println(p);
//						}
//					}
//				} catch (BusinessException e) {
//					System.out.println(e.getMessage());
//				}
//
//			} catch (ParseException1 e1) {
//				System.out.println("cant parse this shit " + e1);
//			}
//
//			break;
//		case 5:
//			System.out.println("Please enter the name of the player");
//			String name =request.getParameter("searchValue");
//
//			try {
//				List<Player> playerList = searchBO.getPlayerByName(name);
//				if (playerList != null && playerList.size() > 0) {
//					System.out.println("you found" + playerList.size() + " mo of players");
//					System.err.println("Player/s Details: ");
//					for (Player p : playerList) {
//						System.out.println(p);
//					}
//				}
//			} catch (BusinessException e) {
//				System.out.println(e.getMessage());
//			}
//
//			break;
//		case 6:
//			System.out.println("Please enter the gender of the player");
//			String gender = request.getParameter("searchValue");
//			try {
//				List<Player> playerList = searchBO.getPlayerByGender(gender);
//				if (playerList != null && playerList.size() > 0) {
//					System.out.println("you found" + playerList.size() + " mo of players");
//					System.err.println("Player/s Details: ");
//					for (Player p : playerList) {
//						System.out.println(p);
//					}
//				}
//			} catch (BusinessException e) {
//				System.out.println(e.getMessage());
//			}
//
//			break;
			case 7:
				System.out.println("Teamnammmeeee");
				String teamName = request.getParameter("searchValue");

				List<Player> playerList = searchBO.getPlayerByTeamName(teamName);
				if (playerList != null && playerList.size() > 0) {
					HttpSession session = request.getSession();
					session.setAttribute("headers", headers);
					session.setAttribute("playerList", playerList);
					response.sendRedirect("results.jsp");

				}

				break;

			default:
				throw new BusinessException("Invalid search criteria");

			}

		} catch (BusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("home.jsp").include(request, response);
		}

	}

}
