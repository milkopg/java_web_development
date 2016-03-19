<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <spring:url value="/resources/styles.css" var="stylesCSS" />


<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
	<link href="${stylesCSS}" rel="stylesheet" />
	<title>Web Banking Page</title>
	
</head>
<body>
<h1>
	Web Banking Page 
</h1>

<form:form method="POST" action="${contextPath}/register" modelAttribute="account">
	<table>
		<tr>
			<td>
				 <c:forEach  var="error" varStatus="errorStatus" items="${account.errors}">
					<p><c:out value="${error}"></c:out></p>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td>Username</td>
			<td><c:out value="${account.username}"></c:out></td>
		</tr>
		<tr>
			<td>Account number</td>
			<td><c:out value="${account.accountNumber}"></c:out></td>
		</tr>
		<tr>
			<td>Account currency</td>
			<td><c:out value="${account.currency.name}"></c:out></td>
		</tr>
		<tr>
			<td>Current amount</td>
			<td><c:out value="${account.totalAmount}"></c:out></td>
		</tr>
		<tr>
			<td>Created by</td>
			<td><c:out value="${account.user.username}"></c:out></td>
		</tr>
		<tr>
			<td><input type="hidden" name="accountNumber" value="${account.accountNumber}">  </td>
		</tr>
	</table>
	<!-- <input type="submit" id = "btn1" name="Submit" value="Submit"> -->
	
</form:form>
	<sec:authorize access="hasRole('ROLE_BANK_EMPLOYEE')">
		<input type="button" onclick="location= '${contextPath}/account'" value="Register Account">
	</sec:authorize>
	<input type="submit" onclick="location= '${contextPath}/operation'" value="Operation">
	<input type="button" onclick="location= '${contextPath}/logout'" value="Logout">
	
