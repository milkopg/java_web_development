<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
	<title>Web Banking Page</title>
</head>
<body>
<h1>
	Web Banking Page 
</h1>

<form:form method="GET" action="${contextPath}/addCustomer" modelAttribute="operation">
	<table>
		<tr>
			<td>
				<c:forEach  var="error" varStatus="errorStatus" items="${operation.customer.errors}">
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
			<td><input  type="text" id="fullName" name="fullName" value='${operation.customer.fullName}'></td>
		</tr>
		<tr>
			<td>Customer account number</td>
			<td><input  type="text" id="accountNumber" name="accountNumber" value='${operation.customer.accountNumber}'></td>
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
			<td><input  type="text" id="amount" name="amount" value='${operation.customer.amount}'></td>
		</tr>
		<tr>
			<td>Total Amount</td>
			<td><c:out value="${operation.customer.totalAmount}"></c:out>
		</tr>
		<tr> 
			<td></td>
			<td><input type="submit" value="Submit" style=""></td>
		</tr>
	</table>
</form:form>