<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My first project</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<% HttpSession account=request.getSession(); 
	String name = (String)account.getAttribute("account");
%>
<script>
 $(function(){
 	$("#anotherContent").load("link.html");
 });
</script>
</head>

<div id="anotherContent"></div>
<frameset rows="1500,*" cols="3000,*" frameborder="no" border="0" framespacing="0">
	
	<frame src="mainroom.jsp" name="mainFrame" scrolling="auto" id="mainFrame">
	
</frameset>


</html>