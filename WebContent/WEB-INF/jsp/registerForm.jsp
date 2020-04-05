<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/login.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
			<input type="text" id="postcode" name="userPostCode" value="" maxLength="7">
			<input type="button" id="search_btn" value="検索">
			<p>※７桁の半角数字で入力してください</p>
			<div id="zip_result"></div>
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
<script type="text/javascript">
	$(function(){
		//検索ボタンをクリックされたときに実行
		$("#search_btn"),click(function(){
			//入力値をセット
			var param = {postcode: $('#postcode').val()}
			//the url of zipcloud API
			var send_url = "http://zipcloud.ibsnet.co.jp/api/search";
			$.ajax({
				type: "GET",
				cache: false,
				data: param,
				url: send_url,
				dataType: "jsonp",
				success: function(res){
					//結果によって処理を振り分ける
					if(res.status == 200) {
						//処理が成功したとき
						//該当する住所を表示
						var html = '';
						for(var i = 0; i < res.results.length; i++) {
							var result = res.results[i];
							console.log(res.results);
							html += '<h2>住所' + (i + 1) + '</h2>';
							html += '<div>都道府県コード：' + result.prefcode + '</div>';
							html += '<div>都道府県：' + result.address1 + '</div>';
							html += '<div>市町村：' + result.address2 + '</div>';
							html += '<div>町域：' + result.address3 + '</div>';
							html += '<div>都道府県(カナ)：' + result.kana1 + '</div>';
							html += '<div>市区町村：' + result.kana1 + '</div>';
							html += '<div>町村(かな)：' + result.kana1 + '</div>';
						}
						$('#zip_result').html(html);
					} else {
						//エラー内容を表示
						$('#zip_result').html(res.message);
					}
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){
					console.log(XMLHttpRequest);
				}
			});
		});
		
	});
</script>

</body>
</html>