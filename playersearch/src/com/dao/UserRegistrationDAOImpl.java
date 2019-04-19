package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbutil.OracleDbConnection;
import com.exception.BusinessException;
import com.model.User;

import oracle.net.aso.p;

public class UserRegistrationDAOImpl implements UserRegistrationDAO {

	@Override
	public User addUser(User user) throws BusinessException {
		
		try {
			
			Connection connection = OracleDbConnection.getConnection();
			String sql = "insert into playerlogin values (?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Internal error, kindly contact sysadmin "+e);
		}
		
		return user;
		
	}

}
