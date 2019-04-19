package com.bo;

import com.dao.TeamsDAO;
import com.dao.TeamsDAOImpl;
import com.exception.BusinessException;
import com.to.Teams;

public class TeamsBOImpl implements TeamBO {
	private TeamsDAO teamsDAO;
	@Override
	public Teams addTeams(Teams teams) throws BusinessException {
		
		System.out.println("Inside of TeamsBOImpl");
		if( isValidCoachName(teams.getCoachName()) && isValidTeamName(teams.getTeamName()) == true) {
			teamsDAO = getTeamsDAO();
			teams = teamsDAO.addTeams(teams);
			System.out.println("if");
		}
		return teams;
	}
	
	


	public boolean isValidTeamName(String teamName) {
		if (teamName.matches("[a-zA-Z]{6,15}")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isValidCoachName(String coachName) {
		if(coachName.matches("[a-zA-Z]{1,20}")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private TeamsDAO getTeamsDAO() {
		if(teamsDAO == null) {
			teamsDAO = new TeamsDAOImpl();
		}
		return teamsDAO;
	}


}
