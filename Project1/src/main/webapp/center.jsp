<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My first project</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$("#anotherContent").load("link.html");
})
</script>

</head>

<body style="background-image: url('img/PAGEPACKGROUND.png');background-repeat:no-repeat;background-size:cover;">

<div id="anotherContent"></div>
<% String account = (String)session.getAttribute("account");
	if(account!=null){out.print("歡迎^^~"+account+"~");}else{response.sendRedirect("index.html");};
%>
<br>
<h3>已購項目:</h3>
<hr>
<h3>您的聊天室: <a href="room.jsp">40666888</a></h3>
<hr>
</body>
</html>