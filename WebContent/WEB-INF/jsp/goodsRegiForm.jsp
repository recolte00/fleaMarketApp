<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page import="model.User" %>

<html>
<head>
<meta charset="UTF-8">
<title>Goods Registration</title>
</head>
<body>
<form action="/fleaMarketApp/RegisterGoods" enctype="multipart/form-data" method="post">
	<table>
	<tr>
		<td>
			Goods Name:
		</td>
		<td>
			<input type="text" name="goodsName">
		</td>
	</tr>
	<tr>
		<td>
			Goods Image:
		</td>
		<td>
			<input type="file" name="goodsImage" >
		</td>
	</tr>
	<tr>
		<td>
			Price
		</td>
		<td>
			<input type="text" name="price">
		</td>
	</tr>
	<tr>
		<td>
			Quantity:
		</td>
		<td>
			<input type="text" name="quantity">
		</td>
	</tr>
	<tr>
		<td>
			Introduction:
		</td>
		<td>
			<input type="text" name="introduction">
			<input type="hidden" name="userNo" value= <%= request.getAttribute("userNo") %>>
		</td>
	</tr>
</table>
	<p><input type="submit" value="Register"></p>
	<a href="/fleaMarketApp/Goods">Goods List</a>
</form>

<img src="${relativePath}"><br>
<img src="https://picsum.photos/200/300"><br>
<img src="http://localhost:8080/uploaded/${relativePath}">
</body>
</html>