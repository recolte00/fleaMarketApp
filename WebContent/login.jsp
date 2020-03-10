<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/login.css">
<meta charset="UTF-8">
<title>Market</title>
</head>
<body>
<h1>Welcome to the Market</h1>
<form action="/fleaMarketApp/Login" method="post">
<div class="login">
	<div class="login-triangle"></div>
  		<h2 class="login-header">Enter Your Detail</h2>
		<p><input type="text" name="loginUser" placeholder="loginUser"></p>
		<p><input type="password" name="password" placeholder="Password"></p>
		<p><input type="button" value="to a Registration Page" onclick="location.href='/fleaMarketApp/ToRegistration'"></p>
		<p><input type="submit" value="Login"></p>
	</div>
</form>
</body>
</html>