package com.to;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dbutil.OracleDbConnection;
import com.exception.BusinessException;
import com.to.Player;

public class SearchDAOImpl implements SearchDAO {

	@Override
	public Player getPlayerById(String id) throws BusinessException {
		Player player = null;
		try (Connection connection = OracleDbConnection.getConnection()) {

			String sql = "select p.id,p.name,p.dob,p.email,p.gender,p.contact,t.teamName "
					+ "from player p join teams t on p.team_id= t.team_id where p.id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id.toUpperCase());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				player = new Player();
				player.setId(id);
				player.setName(resultSet.getString("name"));
				player.setEmail(resultSet.getString("email"));
				player.setTeamname(resultSet.getString("teamname"));
				player.setGender(resultSet.getString("gender"));
				player.setContact(resultSet.getLong("contact"));
				player.setDob(resultSet.getDate("dob"));

			} else {
				throw new BusinessException("Player wiht id" + id + " not found");
			}

		} catch (ClassNotFoundException | SQLException e) {

			throw new BusinessException("Internal error occured kindly contact your sysadmin " + e);
		}
		return player;
	}

	@Override
	public Player getPlayerByContact(long contact) throws BusinessException {
		Player player = null;

		try (Connection connection = OracleDbConnection.getConnection()) {

			String sql = "select p.id,p.name,p.dob,p.email,p.gender,p.contact,t.teamName "
					+ "from player p join teams t on p.team_id= t.team_id where p.contact = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, contact);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				player = new Player();
				player.setContact(contact);
				player.setId(resultSet.getString("id"));
				;
				player.setName(resultSet.getString("name"));
				player.setEmail(resultSet.getString("email"));
				player.setTeamname(resultSet.getString("teamname"));
				player.setGender(resultSet.getString("gender"));
				player.setDob(resultSet.getDate("dob"));

			} else {
				throw new BusinessException("Player with contact" + contact + " not found");
			}

		} catch (ClassNotFoundException | SQLException e) {

			throw new BusinessException("Internal error occured kindly contact your sysadmin " + e);
		}
		return player;

	}

	@Override
	public Player getPlayerByEmail(String Email) throws BusinessException {
		Player player = null;
		
		
		try (Connection connection = OracleDbConnection.getConnection()) {

			String sql = "select p.id,p.name,p.dob,p.email,p.gender,p.contact,t.teamName "
					+ "from player p join teams t on p.team_id= t.team_id where p.email = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,  Email);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				player = new Player();
				player.setEmail(Email);
				player.setContact(resultSet.getLong("contact"));
				player.setId(resultSet.getString("id"));
				player.setName(resultSet.getString("name"));
				player.setEmail(resultSet.getString("email"));
				player.setTeamname(resultSet.getString("teamname"));
				player.setGender(resultSet.getString("gender"));
				player.setDob(resultSet.getDate("dob"));

			} else {
				throw new BusinessException("Player with email " + Email + " not found");
			}

		} catch (ClassNotFoundException | SQLException e) {

			throw new BusinessException("Internal error occured kindly contact your sysadmin " + e);
		}
		
		
		return player;
	}

	@Override
	public List<Player> getPlayerByGender(String gender) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		try (Connection connection = OracleDbConnection.getConnection()) {

			String sql = "select p.id,p.name,p.dob,p.email,p.gender,p.contact,t.teamName "
					+ "from player p join teams t on p.team_id= t.team_id where t.gender = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, teamName);
			preparedStatement.setString(1, gender);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Player player = new Player();
				player.setId(resultSet.getString("id"));

				player.setName(resultSet.getString("name"));
				player.setEmail(resultSet.getString("email"));
//				player.setTeamname(teamName);
				player.setGender(gender);
				player.setGender(resultSet.getString("gender"));
				player.setContact(resultSet.getLong("contact"));
				player.setDob(resultSet.getDate("dob"));
				player.setTeamname(resultSet.getString("teamName"));
				playerList.add(player);

			}
			if (playerList.size() == 0) {
				throw new BusinessException("Player teamname" + gender + " not found");
			}

		} catch (ClassNotFoundException | SQLException e) {

			throw new BusinessException("Internal error occured kindly contact your sysadmin " + e);
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayerByDOB(Date dob) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		
		try (Connection connection = OracleDbConnection.getConnection()) {

			String sql = "select p.id,p.name,p.dob,p.email,p.gender,p.contact,t.teamName "
					+ "from player p join teams t on p.team_id= t.team_id where p.dob = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDate(1, new java.sql.Date(dob.getTime()));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Player player = new Player();
				player.setDob(dob);
				player.setId(resultSet.getString("id"));
				player.setName(resultSet.getString("name"));
				player.setEmail(resultSet.getString("email"));
				player.setTeamname(resultSet.getString("teamname"));
				player.setGender(resultSet.getString("gender"));
				player.setContact(resultSet.getLong("contact"));
				playerList.add(player);

			}
			if (playerList.size() == 0) {
				throw new BusinessException("Player date of birth" + dob + " not found");
			}

		} catch (ClassNotFoundException | SQLException e) {

			throw new BusinessException("Internal error occured kindly contact your sysadmin " + e);
		}
		
		return playerList;
	}

	@Override
	public List<Player> getPlayerByName(String name) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		
		try (Connection connection = OracleDbConnection.getConnection()) {

			String sql = "select p.id,p.name,p.dob,p.email,p.gender,p.contact,t.teamName "
					+ "from player p join teams t on p.team_id= t.team_id where t.name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Player player = new Player();
				player.setId(resultSet.getString("id"));

				player.setName(resultSet.getString("name"));
				player.setEmail(resultSet.getString("email"));
				player.setName(name);
				player.setGender(resultSet.getString("gender"));
				player.setContact(resultSet.getLong("contact"));
				player.setDob(resultSet.getDate("dob"));
				player.setTeamname(resultSet.getString("teamNName"));
				playerList.add(player);

			}
			if (playerList.size() == 0) {
				throw new BusinessException("Player's name" + name + " not found");
			}

		} catch (ClassNotFoundException | SQLException e) {

			throw new BusinessException("Internal error occured kindly contact your sysadmin " + e);
		}
		
		return playerList;
	}

	@Override
	public List<Player> getPlayerByTeamName(String teamName) throws BusinessException {
		List<Player> playerList = new ArrayList<>();
		try (Connection connection = OracleDbConnection.getConnection()) {

			String sql = "select p.id,p.name,p.dob,p.email,p.gender,p.contact,t.teamName "
					+ "from player p join teams t on p.team_id= t.team_id where t.teamName = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, teamName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Player player = new Player();
				player.setId(resultSet.getString("id"));

				player.setName(resultSet.getString("name"));
				player.setEmail(resultSet.getString("email"));
				player.setTeamname(teamName);
				player.setGender(resultSet.getString("gender"));
				player.setContact(resultSet.getLong("contact"));
				player.setDob(resultSet.getDate("dob"));
				playerList.add(player);

			}
			if (playerList.size() == 0) {
				throw new BusinessException("Player teamname" + teamName + " not found");
			}

		} catch (ClassNotFoundException | SQLException e) {

			throw new BusinessException("Internal error occured kindly contact your sysadmin " + e);
		}
		return playerList;
	}

}
