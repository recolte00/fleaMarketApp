<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/login.css">
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>
<form action="/fleaMarketApp/RegisterUser" method="post">
<table>
	<tr>
		<td>
			Your ID:
		</td>
		<td>
			<input type="text" name="userId">
		</td>
	</tr>
	<tr>
		<td>
			Your Name:
		</td>
		<td>
			<input type="text" name="name">
		</td>
	</tr>
	<tr>
		<td>
			Password:
		</td>
		<td>
			<input type="password" name="pass">
		</td>
	</tr>
	<tr>
		<td>
			Postcode:
		</td>
		<td>
			<input type="text" name="userPostCode">
		</td>
	</tr>
	<tr>
		<td>
			Address:
		</td>
		<td>
			<input type="text" name="userAddress">
		</td>
	</tr>
	<tr>
		<td>
			Gender:
		</td>
		<td>
			<input type="radio" name="userGender" value="0">Others
			<input type="radio" name="userGender" value="1">Male
			<input type="radio" name="userGender" value="2">Female
		</td>
	</tr>
	<tr>
		<td>
			BirthDate:
		</td>
		<td>
			<input type="date" name="userBirthDate">
		</td>
	</tr>
</table>
	<p><input type="submit" value="Sign Up"></p>
	<a href="/fleaMarketApp/Logout">Log out</a>
</form>
</body>
</html>