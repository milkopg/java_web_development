<%@tag import="java.util.Date"%>
<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="showDate" %>
<%@ attribute name="header_param" %>
<%@ attribute name="footer" %>
<%@ attribute name="title" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 </head>
 <header>${header_param}</header>
<body>
	<jsp:doBody/>
		${title}
	<footer>${footer}</footer>
	<c:if test="${showDate }">Current date: <%=new Date() %></c:if>
</body>
</html>