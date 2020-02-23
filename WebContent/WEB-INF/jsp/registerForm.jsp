<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Register</title>
</head>
<body>
<form action="/fleaMarketApp/RegisterUser" method="post">
Your ID:<input type="text" name="id"><br>
Password:<input type="password" name="pass"><br>
Your Name:<input type="text" name="name"><br>
Postcode<input type="text" name="userPostCode"><br>
Address<input type="text" name="userAdress"><br>
<p>Gender
<input type="radio" name="userGender" value="0">Others
<input type="radio" name="userGender" value="1">Male
<input type="radio" name="userGender" value="2">Female
</p>
<br>
BirthDate<input type="date" name="userBirthDate">

</form>
</body>
</html>