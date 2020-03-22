<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="model.User" %>

<html>
<head>
<meta charset="UTF-8">
<title>Goods Registration</title>
</head>
<body>
<form action="/fleaMarketApp/RegisterGoods" method="post">
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
</body>
</html>