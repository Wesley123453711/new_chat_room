<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My first project</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body style="background-image: url('img/PAGEPACKGROUND.png');background-repeat:no-repeat;background-size:cover;">
<script>
 $(function(){
 	$("#anotherContent").load("link.html");
 });
</script>
<div id="anotherContent"></div>
<form action="registerServlet" method="post">
姓名:<input type="text" name="name">
電話:<input type="text" name="phone">
性別: 男<input type="radio" name="sex" value="男">
女<input type="radio" name="sex" value="女"><br>
年齡: 20以下<input type="radio" name="age" value="20以下">
21-30歲<input type="radio" name="age" value="21-30">
31-40歲<input type="radio" name="age" value="31-40">
41-50歲<input type="radio" name="age" value="41-50">
51歲以上<input type="radio" name="age" value="51以上"><br>
電郵:<input type="email" name="email">
地址:<input type="text" name="ad"><br>
帳號: <input type="text" name="account">
密碼: <input type="password" name="password">
<input type="submit" value="送出">
</form>
</body>
</html>