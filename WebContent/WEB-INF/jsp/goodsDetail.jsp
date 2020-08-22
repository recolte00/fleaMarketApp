<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.GoodsDetail"%>
<%
GoodsDetail goods = (GoodsDetail) session.getAttribute("goodsDetail");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Goods Detail</title>
</head>
<body>
	<form>
		<table>
			<tr>
				<td>No:<%=goods.getGoodsNo()%></td>
				<td>Name:<%=goods.getGoodsName()%></td>
			</tr>
			<tr>
				<td>Image:<%=goods.getGoodsImage()%></td>
			</tr>
			<tr>
				<td>Price:<%=goods.getPrice()%></td>
				<td>Quantity:<%=goods.getQuantity()%></td>
			</tr>
			<tr>
				<td>Introduction:<%=goods.getIntroduction()%></td>
			</tr>
			<tr>
				<td>RegisterDate:<%=goods.getRegisterDate()%></td>
				<td>User:<%=goods.getUserId()%></td>
			</tr>
		</table>
	</form>
	<a href="/fleaMarketApp/Goods">Back to List</a>
</body>
</html>