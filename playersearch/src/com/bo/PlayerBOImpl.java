package com.bo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.dao.PlayerDAO;
import com.dao.PlayerDAOImpl;
import com.exception.BusinessException;
import com.to.Player;

public class PlayerBOImpl implements PlayerBO {

	private PlayerDAO playerDAO;

	@Override
	public Player addPlayer(Player player) throws BusinessException {
		
		if(player.getGender().equals("on")) {
			player.setGender("F");
		}
		else {
			player.setGender("M");
		}
		System.out.println("Your are **-->"+player.getGender());
		
		if( isValidName(player.getName()) && isValidDOB(player.getDob()) && isValidGender(player.getGender()) && isValidContact(player.getContact()) && isValidTeamname(player.getTeamname()) == true) {
			playerDAO = getPlayerDAO();
			player = playerDAO.addPlayer(player);
		}
		
		return player;
		
		
		
	}

	@Override
	public Player viewPlayers(Player player) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player deletePlayer(Player player) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isValidName(String name) {
		if(name.matches("[a-zA-Z]{1,20}")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isValidDOB(Date dob) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String strDOB = dateFormat.format(dob);
		if ((strDOB.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}"))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isValidGender(String gender) {
		
		
	
		System.out.println("You are ---> "+gender);
		
		if(gender.matches("[a-zA-Z]{1}")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isValidContact(Long contact) {
		if (Long.toString(contact).length() == 10) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isValidTeamname(String teamName) {
		if (teamName.matches("[a-zA-Z]{6,15}")) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isValidEmail(String Email) {
		if (Email.matches(".+\\@.+\\..+")) {
			return true;
		}
		else {
			return false;
		}
	}
	

	
	private PlayerDAO getPlayerDAO() {
		if(playerDAO == null) {
			playerDAO = new PlayerDAOImpl();
		}
		return playerDAO;
	}



}
