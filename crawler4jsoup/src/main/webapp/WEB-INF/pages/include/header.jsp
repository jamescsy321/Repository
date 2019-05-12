<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Start header area -->
<c:if test="${pageContext.request.requestURI != '/crawler4jsoup/'}">
    <div id="header"></div>
</c:if>
<!-- End header area -->

<!-- Start icon area -->
<div id="icon">
    <img src="<c:url value="/img/logo.png"/>" alt="icon"/>
</div>
<!-- End icon area -->


<!-- Start login button area -->

<!-- before log in --> 
<div id="login-btn"><i class="fa fa-user" ></i><span>Login</span></div>

<!-- after log in -->
<div id="loggedin-icon"><img src="<c:url value="/img/userIcon.png"/>" alt="user icon"/></div>

<div id="loggedin-list">
    <div class="loggedin-list-item" id="user-center-btn">會員中心</div>
    <div class="loggedin-list-item" id="regist-btn">註冊</div>
    <div class="loggedin-list-item" id="logout">登出</div>
</div>
<!-- End login button area -->