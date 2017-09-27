<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Bootstrap 实例 - 水平表单</title>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
</head>
<body>

<form  action="register" method="POST">

	<input type="text"  id="username" name="username" placeholder="请输入名字"> 
	<input type="text"  id="userpwd" name="userpwd" placeholder="请输入密码">
		
	<button type="submit" >注册</button>

</form>

</body>
</html>
