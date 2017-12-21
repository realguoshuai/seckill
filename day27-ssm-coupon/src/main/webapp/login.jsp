<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>

	<h1>${errorMessage }</h1>
	<form action='<c:url value="/login"></c:url>' method="post">
		<input type="email" name="email">
		<input type="password" name="password">
		<input type="submit" value="登录">
	</form>

</body>
</html>