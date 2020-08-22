<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%
User registerUser = (User) session.getAttribute("registerUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>
<p>Use this details below?
</p>
<p>
ID:<%=registerUser.getUserId()%><br>
Name:<%=registerUser.getUserName()%><br>
Password:<%=registerUser.getPass()%><br>
PostCode:<%=registerUser.getUserPostCode()%><br>
Address:<%=registerUser.getUserAddress()%><br>
Gender:<%=registerUser.getUserGender()%>

</p>
<a href="/fleaMarketApp/RegisterUser">Back</a>
<a href="/fleaMarketApp/RegisterUser?action=done">Confirm</a>
</body>
</html>