package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbutil.OracleDbConnection;
import com.exception.BusinessException;
import com.model.User;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public boolean isValidUser(User user) throws BusinessException {
		
		Boolean b = false;
		
		String sql = "select username from playerlogin where username=? and password=?";
		try(Connection connection = OracleDbConnection.getConnection();) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				b = true;
			}
			else {
				throw new BusinessException("Invalid login credentials");
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error"+ e);
		}
		
		return b;
	}
	
public boolean updateUser(String id, long newContact) throws BusinessException {
		
		Boolean b = false;
		
		String sql = "update player set contact = ? where id = ? ";
		try(Connection connection = OracleDbConnection.getConnection();) {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setLong(1, newContact);
			
			b = preparedStatement.execute();
			
		
		} catch (ClassNotFoundException | SQLException e) {
			throw new BusinessException("Internal error"+ e);
		}
		
		return b;
	}
	
	
	
	

}
