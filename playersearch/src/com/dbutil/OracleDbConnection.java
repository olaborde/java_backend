package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDbConnection {
	
	private static Connection connection;
	
	public static Connection getConnection()throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("Driver Loaded");
		//step 2
		String password = "password";
		String user = "lms";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		connection=DriverManager.getConnection(url, user, password);
		
		return connection;
		
	}

//	public static Connection getConnection() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	

}
