<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${goods.name }</title>
</head>
<body>
	<h1>${goods.name }</h1>
	<img src='<c:url value="/upload/${goods.image }.png"></c:url>'>
	<h3>${goods.info }</h3>
	<h2>单价：￥${goods.price }</h2>
	<h2>余量：${goods.count }</h2>
	
	<form action='<c:url value="/goods/seckill"></c:url>'>
		<input type="hidden" name="goodsId" value="${goods.id }">
		<input type="number" name="count" min="1" max="${goods.count }" value="1">
		<input type="submit" value="购买">
	</form>

	<br><br><br>

	<table border="1">
		<c:forEach items="${goods.userGoods }" var="userGoods">
			<tr>
				<td>${userGoods.user.email }</td>
				<td>${userGoods.time }</td>
				<td>${userGoods.count }</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>