<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Goods" %>
<%@ page import="java.util.List" %>
<% 
// セッションスコープからユーザ情報を取得
List<Goods> goodsList = (List<Goods>) session.getAttribute("goodsList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Goods List</title>
</head>
<body>
<form>
	<h1>Goods Page</h1>
	<p>Goods</p>
	<table>
		<c:forEach var="val" items="${goodsList}" varStatus="st">
			<tr>
				<td><c:out value="${val.goodsNo}"/><td/>
				<td><c:out value="${val.userNo}"/></td>
				<td><c:out value="${val.goodsName}"/></td>
				<td><c:out value="${val.goodsImage}"/></td>
				<td><c:out value="${val.price}"/></td>
				<td><c:out value="${val.quantity}"/></td>
				<td><c:out value="${val.introduction}"/></td>
				<td><c:out value="${val.registerDate}"/></td>
			</tr>
			<tr>
				<td><a href="
						<c:url value="/GoodsDetail">
  							<c:param name="goodsNo" value="${val.goodsNo}"/>
  							<c:param name="userNo" value="${val.userNo}"/>
  							<c:param name="goodsName" value="${val.goodsName}"/>
  							<c:param name="goodsImage" value="${val.goodsImage}"/>
  							<c:param name="price" value="${val.price}"/>
  							<c:param name="quantity" value="${val.quantity}"/>
  							<c:param name="introduction" value="${val.introduction}"/>
  							<c:param name="soldoutFlag" value="${val.soldoutFlag}"/>
  							<c:param name="registerDate" value="${val.registerDate}"/>
						</c:url>">
						Goods Detail
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p><input type="button" value="to a Goods Registration Page" onclick="location.href='/fleaMarketApp/ToGoodsRegi'"></p>
	<p><a href="/fleaMarketApp/Logout">Log out</a></p>
</form>
</body>
</html>