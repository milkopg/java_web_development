<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="pt" tagdir="/WEB-INF/tags/problem7" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<pt:page header_param="Problem7 Test custom header"></pt:page>
</head>

<%--test with as request parameter
	http://localhost:8080/servletAndPagesHomework/jsp/problem7/page.jsp?showDate=true
	http://localhost:8080/servletAndPagesHomework/jsp/problem7/page.jsp?showDate=false
 --%>
 
<body>
	<pt:page showDate = "${param['showDate']}"/>
</body>
<pt:page footer="Version is: 2.0.0"></pt:page>
</html>