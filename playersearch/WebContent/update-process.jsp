<%@page import="com.dbutil.OracleDbConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
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
String contact = request.getParameter("contact");

try(Connection connection = OracleDbConnection.getConnection()){

String sql1 = " UPDATE  player set contact=? where id = ? ";
PreparedStatement st1 = connection.prepareStatement(sql1);

st1.setString(1, contact);
st1.setString(2, id);
st1.execute();
out.println("Data updated Successfully!");
	
	
}
catch(Exception e)
{
System.out.print(e);

}

%>
</body>
</html>