<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<html>
	<head>
		<title>Student Registry</title>
	</head>
	<body>
		<h1>
			Student Registry  
		</h1>
		<button type="button" onclick="location='${contextPath}${addStudentUrl}'">Add Student</button>
		<table border="1">
			<thead>
				<tr>
					<td>Faculty Number</td>
					<td>Name</td>
				</tr>
			</thead>
			<c:if test="${not empty students }">
				<c:forEach var="s" items="${students }">
					<tr>
						<td>${s.facultyNo }</td>
						<td>${s.name }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</body>
</html>
