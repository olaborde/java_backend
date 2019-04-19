<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.exception.BusinessException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.dbutil.OracleDbConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


</head>
<body>

<%
	String id = request.getParameter("id");
	
	try(Connection connection = OracleDbConnection.getConnection()){
		String sql1 = "DELETE FROM playerlogin where USERNAME = ?";
		String sql2 = "DELETE FROM player where ID= ?";
		
		
		PreparedStatement st1 = connection.prepareStatement(sql1);
		PreparedStatement st2 = connection.prepareStatement(sql2);
		
		st1 = connection.prepareStatement(sql1);
		st2 = connection.prepareStatement(sql2);
		
		st1.setString(1, id);
		st2.setString(1, id);
		
		st1.execute();
		st2.execute();
		out.println("Data Deleted Successfully!");
	}
	catch(Exception e)
	{
	System.out.print(e);
	
	}

%>

</body>
</html>