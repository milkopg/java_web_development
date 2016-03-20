<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="pt" tagdir="/WEB-INF/tags/problem7" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<pt:page header_param="Problem7 Test custom title"></pt:page>
</head>

<%-- test it on http://localhost:8080/servletAndPagesHomework/jsp/problem8/table_with_page_tag.jsp --%>
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
				<td> <pt:page title="Web Fundamentals"/> </td>
				<td> <pt:page showDate="true"/></td>
			</tr>
		</tbody>
	</table>
</body>
</html>