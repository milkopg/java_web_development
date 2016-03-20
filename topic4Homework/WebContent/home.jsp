<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="ct" uri="http://softuni.bg/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web banking page</title>
<link rel="stylesheet" type="text/css" href="<c:url value="css/styles.css" />"/>
</head>
<body>
	<ct:header title="Problem 2 - Web banking page"/>
	<ct:page>
		<form action="bank" method="post">
			<table>
				<tr>
					<td>
						<c:forEach  var="error" varStatus="errorStatus" items="${sessionScope.customer.errors}">
							<p><c:out value="${error}"></c:out></p>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<td>
						<c:out value="${sessionScope.selected}">${sessionScope.selected}</c:out>
						<select name="currencies">
							<c:forEach items="${sessionScope.currencies}" var="currency">
								 <option value="${currency.key}"  <c:if test="${sessionScope.selected == currency.key}">selected="selected"</c:if> >${currency.key} ${currency.value} </option>
						    </c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>Customer name</td>
					<td><input  type="text" id="fullName" name="fullName" value='${sessionScope.customer.fullName}'></td>
				</tr>
				<tr>
					<td>Customer account number</td>
					<td><input  type="text" id="accountNumber" name="accountNumber" value='${sessionScope.customer.accountNumber}'></td>
				</tr>
				<tr>
					<td>Deposit/Withdraw</td>
					<td>
						<input type="radio" name="depositType" value="deposit">
						<input type="radio" name="depositType" value="withdraw">
					</td>
				</tr>
				<tr>
					<td>Amount to change</td>
					<td><input  type="text" id="amount" name="amount" value='${sessionScope.customer.amount}'></td>
				</tr>
				<tr>
					<td>Total Amount</td>
					<td><c:out value="${sessionScope.customer.totalAmount}"></c:out>
				</tr>
				<tr> 
					<td></td>
					<td><input type="submit" value="Submit" style=""></td>
				</tr>
			</table>
		</form>
	</ct:page>
	<ct:footer version="1.0.0" project_name="${pageContext.request.contextPath}"></ct:footer>
</body>
</html>