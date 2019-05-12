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
	This page have ${fn:length(articles)} results<br/>
	<ul>
		<c:forEach	var="bean" items="${articles}">
			<article>
				<table border="1">
					<tr>
						<th colspan="3"></th> <!-- title -->
					</tr>
					<tr>
						<td>${bean.author}</td>
						<td>${bean.date}</td>
					</tr>
				</table>
				<div>
					${bean.content}
				</div>
			</article>
		</c:forEach>
	</ul>
	<c:if test="${param.page > 1}">
	
		<a href="<c:url value="/Article?id=${param.id}&page=${param.page - 1}"/>">上一頁</a>
	</c:if>
	<c:if test="${fn:length(articles) eq 10}">
		
		<a href="<c:url value="/Article?id=${param.id}&page=${param.page + 1}"/>">下一頁</a>
	</c:if>
	<a href="Topic?cat=LKY&page=1">Return to the List</a>
</body>
</html>