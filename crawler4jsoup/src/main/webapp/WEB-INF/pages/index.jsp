<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html lang="zh-tw">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>MotoZone</title>

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <!-- Bootstrap -->
    <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">
    <!-- main style -->
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- jQuery UI library -->
    <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"
            integrity="sha256-eGE6blurk5sHj+rmkfsGYeKyZx3M4bG+ZlFyA7Kns7E="
            crossorigin="anonymous"></script>
    <!-- Off-canvas Menu -->   
    <script src="<c:url value="/js/classie.js"/>"></script>
    <!-- main js -->
    <script src="<c:url value="/js/main.js"/>"></script>
    
</head>
<body>
    <!-- BEGAIN PRELOADER -->
    <div id="preloader">
            <div id="status">&nbsp;</div>
    </div>
    <!-- END PRELOADER -->

    <!-- Start menu area -->
    <%@ include file="include/menu.jsp" %>
    <!-- End menu area -->
    
    
	<!-- Start header area -->
	<%@ include file="include/header.jsp" %>
	<!-- End header area -->
	

    <!-- login and regist pop up windows (with shadow) -->
   	<%@ include file="include/loginArea.jsp" %>

    
</body>
</html>