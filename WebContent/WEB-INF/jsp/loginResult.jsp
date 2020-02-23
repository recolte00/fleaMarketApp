<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.User" %>
<%
// セッションスコープからユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Market</title>
</head>
</head>
<body>
<h1>Market</h1>
<% if(loginUser != null) { %>
<p>Login is succeed</p>
<p>Welcome! <%= loginUser.getUserId() %></p>
<a href="/fleaMarketApp/Goods">Look for Goods</a>
<% } else { %>
<p>Login is failed</p>
<a href="/fleaMarketApp/ToLoginPage">to the Login Page</a>
<% } %>
</body>
</html>