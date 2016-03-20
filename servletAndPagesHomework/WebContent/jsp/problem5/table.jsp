<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Problem5 Table</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>Topic</th>
				<th>Date</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Web Basics</td>
				<td><%=new Date() %></td>
			</tr>
		</tbody>
	</table>
	
</body>
</html>