<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.dbutil.OracleDbConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<sql:setDataSource var = "dataSource" driver = "oracle.jdbc.OracleDriver"
         url = "jdbc:oracle:thin:@localhost:1521:xe"
         user = "lms"  password = "password" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<sql:setDataSource var = "dataSource" driver = "oracle.jdbc.OracleDriver"
         url = "jdbc:oracle:thin:@localhost:1521:xe"
         user = "lms"  password = "password" scope="session"/>
<title>Update</title>
</head>
<body>

<h1>Update</h1>




<form method="post" action="update-process.jsp">
<label>ID</label><br>
<input name="id" value="<%= request.getParameter("id")%>"> <br>
<label>Contact</label><br>
<input name="contact" value="<%= request.getParameter("contact")%>"> <br>
<input type="submit" name="update" value="Update">
</form>


</body>
</html>