<%@page import="java.sql.SQLException"%>
<%@page import="com.exam.connection.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>connTest.jsp</title>
</head>
<body>
	<%
		try(Connection conn = ConnectionProvider.getConnection()){
			out.println("<h2>connection success</h2>");
		}catch(SQLException e){
			out.println("<h2>connection failed</h2>");
			out.println(e.getMessage());			
		}
	
	%>

</body>
</html>