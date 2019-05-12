<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List page</title>
</head>
<body>
	This page have ${fn:length(titles)} results<br/>
	<ul>
		<c:forEach	var="bean" items="${titles}">
			<li><a href="<c:url value="/Article?id=${bean.id}&page=1"/>">${bean.title}</a></li>
		</c:forEach>
	</ul>
	<c:if test="${param.page > 1}">
		<a href="<c:url value="/Topic?cat=${param.cat}&page=${param.page - 1}"/>">上一頁</a>
	</c:if>
	<c:if test="${fn:length(titles) eq 10}">
		<a href="<c:url value="/Topic?cat=${param.cat}&page=${param.page + 1}"/>">下一頁</a>
	</c:if>
	<a href="<c:url value="/test/index.jsp"/>">Return to Index</a>
</body>
</html>