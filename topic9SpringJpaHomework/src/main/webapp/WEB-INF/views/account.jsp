<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <spring:url value="/resources/styles.css" var="stylesCSS" />

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="${stylesCSS}" rel="stylesheet" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Topic 7 Spring Security HomeWork - Web Banking Page</title>
	</head>
	<body>
		<body>
			<form:form method="POST" action="${contextPath}/addAccount" modelAttribute="account">
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
						<td><input  type="text" id="username" name="username" value='${account.username}'></td>
					</tr>
					<tr>
						<td>Account number</td>
						<td><input  type="text" id="accountNumber" name="accountNumber" value='${account.accountNumber}'></td>
					</tr>
					<tr>
						<td>Initial amount</td>
						<td><input  type="text" id="initialAmount" name="initialAmount" value='${account.initialAmount}'></td>
					</tr>
					<tr>
						<td>
							<c:out value="${account.currency.name}">${account.currency.name}</c:out>
							<select name="account.currency.name">
								<c:forEach items="${account.currencies}" var="currency">
									 <%-- <option value="${currency.key}"  <c:if test="${sessionScope.selected == currency.key}">selected="selected"</c:if> >${currency.key} ${currency.value} </option> --%>
									 <option value="${currency.name}"> ${currency.name} ${currency.rate} </option>
							    </c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td><input  type="hidden" id="createdBy" name="createdBy" value="${customer.username}"></td>
					</tr>
					
				</table>
				<input type="submit" id = "btn1" name="Submit" value="Submit">
				<input type="button" onclick="location= '${contextPath}/home'" value="Back">
		</form:form>
	</body>
	</body>
</html>