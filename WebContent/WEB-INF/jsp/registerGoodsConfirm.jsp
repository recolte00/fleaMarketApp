<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Goods" %>
<% 
Goods goods = (Goods) request.getAttribute("goods");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Goods Registration</title>
</head>
<body>
<form action="/fleaMarketApp/ToRegiGoodsDone" method="post">
<p>Use This Details Below?</p>
<table>
	<tr>
		<td>
			<input type="text" name="goodsNo" value=<%=goods.getGoodsNo()%>>
		</td>
	</tr>
	<tr>
		<td>
			<input type="text" name="userNo" value=<%=goods.getUserNo()%>>
		</td>
	</tr>
	<tr>
		<td>
			<input type="text" name="goodsName" value=<%=goods.getGoodsName()%>>
		</td>
	</tr>
	<tr>
		<td>
			<input type="text" name="goodsImage" value=<%=goods.getGoodsImage()%>>
		</td>
	</tr>
	<tr>
		<td>
			<input type="text" name="price" value=<%=goods.getPrice()%>>
		</td>
	</tr>
	<tr>
		<td>
			<input type="text" name="quantity" value=<%=goods.getQuantity()%>>
		</td>
	</tr>
	<tr>
		<td>
			<input type="text" name="introduction" value=<%=goods.getIntroduction()%>>
			<input type="hidden" name="registerDate" value=<%=goods.getRegisterDate()%>>
		</td>
	</tr>
</table>
<a href="/fleaMarketApp/ToGoodsRegi">Back</a>
<input type="submit" value="Confirm">
</form>
</body>
</html>