<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach var="bean" items="${postList}">
	<section class="content-area">
			<a href="#article-content" onclick="displayPosts(${bean.id},1)">
            <div class="content-img">
            ${bean.imgSrc}
            </div>
            <div class="content">
                <h3>${bean.title}</h3>
<%--                 <p>${bean.content}</p> --%>
            </div>
            </a>
    </section>
</c:forEach>
