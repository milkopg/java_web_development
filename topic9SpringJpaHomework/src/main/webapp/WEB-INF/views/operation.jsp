<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
		<form:form method="POST" action="${contextPath}/addOperation" modelAttribute="operation">
			<table>
				<tr>
					<td>
						<c:forEach  var="error" varStatus="errorStatus" items="${operation.account.errors}">
							<p><c:out value="${error}"></c:out></p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td>Account number</td>
					<td><input  type="text" id="account.accountNumber" name="account.accountNumber" value='${operation.account.accountNumber}'></td>
				</tr>
				<tr>
					<td>Deposit/Withdraw</td>
					<td>
						<input type="radio" name="depositType" value="deposit" <c:if test="${operation.depositType == 'deposit'}">checked="checked"</c:if>>
						<input type="radio" name="depositType" value="withdraw" <c:if test="${operation.depositType == 'withdraw'}">checked="checked"</c:if>>
					</td>
				</tr>
				<tr>
					<td>Amount</td>
					<td><input  type="text" id="amount" name="amount" value='${operation.amount}'></td>
				</tr>
				<tr>
					<td>Currency:</td>
					<td>
						<c:out value="${sessionScope.activeCurrency}">${sessionScope.activeCurrency}</c:out>
						<select name="activeCurrency">
							<c:forEach items="${operation.currencies}" var="currency">
								 <option value="${currency.name}"  >${currency.name} ${currency.rate} </option>
						    </c:forEach>
						</select>
					</td>
				</tr>
			</table>
			<input type="submit" id = "btn1" name="Submit" value="Submit">
			<input type="button" onclick="location= '${contextPath}/home'" value="Back">
		</form:form>
	</body>
</html>