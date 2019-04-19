package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.dbutil.OracleDbConnection;
import com.exception.BusinessException;
import com.to.Teams;

public class TeamsDAOImpl implements TeamsDAO {

	@Override
	public Teams addTeams(Teams teams) throws BusinessException {
		
		try {
			Connection connection = OracleDbConnection.getConnection();
			String sql = "{call REGISTERTEAMS(?,?,?) }";
			CallableStatement callableStatement = connection.prepareCall(sql);
			callableStatement.registerOutParameter(1, java.sql.Types.NUMERIC);
			callableStatement.setString(2, teams.getTeamName());
			callableStatement.setString(3, teams.getCoachName());
			System.out.println("dao");
			callableStatement.executeQuery();
			teams.setTeam_id(callableStatement.getInt(1));
			System.out.println("executed");
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("err "+e);
			
			throw new BusinessException("Internal error, kindly contact sysadmin "+e);
		}
		
		
		return teams;
	}

}
