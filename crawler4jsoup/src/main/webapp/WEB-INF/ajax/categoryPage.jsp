<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:forEach var="bean" items="${categoryList}">
	<c:url value="/article.html" var="articleURL">
		<c:param name="cat" value="${bean.subCategory.category}"/>
	</c:url>
	<a href="${articleURL}">
        <div class="cat">
            <img src="<c:url value="${bean.subCategory.imgSrc}"/>" alt="${bean.subCategory.category}"/>
        </div>
   	</a>
</c:forEach>
