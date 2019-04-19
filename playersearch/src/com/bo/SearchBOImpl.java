package com.bo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.SearchDAO;
import com.dao.SearchDAOImpl;
import com.exception.BusinessException;
import com.to.Player;

public class SearchBOImpl implements SearchBO {

	private SearchDAO searchDAO;

	@Override
	public Player getPlayerById(String id) throws BusinessException {
		Player player = null;
		if (id.matches("[Pp]{1}[a-zA-Z]{2}[0-9]{7}")) {
			// code here for DAO

			searchDAO = getSearchDAO();
			player = searchDAO.getPlayerById(id);

		} else {
			throw new BusinessException("Enter player id " + id + " is invalid");
		}
		return player;
	}

	@Override
	public Player getPlayerByContact(long contact) throws BusinessException {
		Player player = null;

		if (Long.toString(contact).length() == 10) {
			// code here for DAO

			searchDAO = getSearchDAO();
			player = searchDAO.getPlayerByContact(contact);

		} else {
			throw new BusinessException("Enter player id " + contact + " is invalid");
		}
		return player;

	}

	@Override
	public Player getPlayerByEmail(String Email) throws BusinessException {
		Player player = null;

		if (Email.matches(".+\\@.+\\..+")) {
			// code here for DAO

			searchDAO = getSearchDAO();
			player = searchDAO.getPlayerByEmail(Email);

		} else {
			throw new BusinessException("Enter player email " + Email + " is invalid");
		}

		return player;
	}

	@Override
	public List<Player> getPlayerByGender(String gender) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		if(gender.matches("[a-zA-Z]{1}")) {
			searchDAO = getSearchDAO();
			playerList = searchDAO.getPlayerByGender(gender);
		}
		else {
			throw new BusinessException("Entered players gender " + gender + " was not found");
		}

		return playerList;
	}

	@Override
	public List<Player> getPlayerByDOB(Date dob) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String strDOB = dateFormat.format(dob);
		if ((strDOB.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}"))) {
			try {
				dob=dateFormat.parse(strDOB);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			searchDAO = getSearchDAO();
			playerList = searchDAO.getPlayerByDOB(dob);
		} else {
			throw new BusinessException("Entered Player date of birth - " + dob + " not found!");
		}

		return playerList;
	}

	@Override
	public List<Player> getPlayerByName(String name) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		if (name.matches("[a-zA-Z]{3,15}")) {
			searchDAO = getSearchDAO();
			playerList = searchDAO.getPlayerByName(name);
		}
		else {
			throw new BusinessException("Enter players name "+ name + " not found!");
		}
			return playerList;
	}

	@Override
	public List<Player> getPlayerByTeamName(String teamName) throws BusinessException {
		List<Player> playerList = null;
		if (teamName.matches("[a-zA-Z]{6,15}")) {

			searchDAO = getSearchDAO();
			playerList = searchDAO.getPlayerByTeamName(teamName);
		} else {
			throw new BusinessException("Entered Team name - " + teamName + " not found!");
		}
		return playerList;
	}

	private SearchDAO getSearchDAO() {
		if (searchDAO == null) {
			searchDAO = new SearchDAOImpl();
		}
		return searchDAO;
	}

}
