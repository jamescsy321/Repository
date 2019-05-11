<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- <link rel="stylesheet" type="text/css" href="../css/main.css" /> -->

<title>Login</title>
</head>
<body>

<h3>Login</h3>
<!-- 以POST觸發 -->
<form action="<c:url value="/login.controller" />" method="POST">
<table>
	<tr>
		<td>Userid : </td>
		<td><input type="text" name="userid" value=""></td>
		<td><span class="error">${errors.username}</span></td>
	</tr>
	<tr>
		<td>password : </td>
		<td><input type="text" name="userpwd" value=""></td>
		<td><span class="error">${errors.password}</span></td>
	</tr>
	<tr>
		<td>　</td>
		<td align="right"><input type="submit" value="Login"></td>
	</tr>
</table>
</form>

</body>
</html>