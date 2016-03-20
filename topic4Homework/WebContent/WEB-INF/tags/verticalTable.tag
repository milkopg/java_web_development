<%@ tag dynamic-attributes="dynattrs" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1">
	<c:set var="attributesCount" value="${dynattrs.size()/2}" />
	<c:forEach var="i" begin="1" end="${attributesCount}">
		<c:set var="titleKey" value="row${i}-title" />
		<c:set var="valueKey" value="row${i}-value" />

		<c:if test="${dynattrs[titleKey] != null}">
			<tr>
				<th>${dynattrs[titleKey]}</th>
				<td>${dynattrs[valueKey]}</td>
			</tr>
		</c:if>
	</c:forEach>
</table>