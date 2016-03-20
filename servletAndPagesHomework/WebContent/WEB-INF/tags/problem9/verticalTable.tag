<%@ tag dynamic-attributes="dynattrs" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pt" tagdir="/WEB-INF/tags/problem7" %>

<table border="1">
		<tr>
			<th>Topic</th>
			<th>Date</th>
		</tr>
		<tr>
			<td><pt:page title= "${dynattrs.title}" /></td>
			<td><pt:page showDate = "${dynattrs.showDate}"/></td>
			
		</tr>
</table>