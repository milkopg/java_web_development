<%@tag import="java.util.Date"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="header_with_title" %>
<%@ attribute name="project_name" %>
<%@ attribute name="version" %>
<%@ attribute name="title" %>
<%@ attribute name="body" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 </head>
 <title>${title }</title>
<body>
	<header>${header_with_title}</header>
		username: ${body} 
	<footer>Project Name: ${project_name} Version: ${version}</footer>
	
</body>
</html>

