<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>${posts[0].id.title}</h2>
<c:forEach var="bean" items="${posts}">
    <div class="single-post">
        <hr/>
        <div class="post-header">
            ${bean.author}
            <br/>
            ${bean.date}
        </div>
        <div class="post-body">${bean.content}</div>
    </div>
</c:forEach>
