package com.bo;

import java.util.Date;
import java.util.List;

import com.exception.BusinessException;
import com.to.Player;

public interface SearchBO {

	public Player getPlayerById(String id) throws BusinessException;

	public Player getPlayerByContact(long contact) throws BusinessException;

	public Player getPlayerByEmail(String Email) throws BusinessException;

	public List<Player> getPlayerByGender(String gender) throws BusinessException;

	public List<Player> getPlayerByDOB(Date dob) throws BusinessException;

	public List<Player> getPlayerByName(String name) throws BusinessException;

	public List<Player> getPlayerByTeamName(String teamName) throws BusinessException;

}
