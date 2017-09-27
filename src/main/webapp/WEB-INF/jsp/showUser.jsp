<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"> 
	<title>用户管理系统</title>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#search").click(function(){
				alert(1);
					var name =  $("#name").val();
				location.href="queryLike?name="+name+"&pageNo=1"; 		
			
			})	
			
		}) 
	
	</script>
	
	
</head>
<body>

<button type="button" class="btn btn-default btn-sm" style="margin-left:470PX">
    <span class="glyphicon glyphicon-user"></span> 增加User
</button>
<input type="text" id="name"/>
<button type="button" id="search">根据用户名进行查询</button>
<table class="table table-hover table-bordered" style="width:500px" align="center">
	
	<thead>
		<tr>
			<th>用户编号</th>
			<th>用户名称</th>
			<th>用户密码</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
	
	 <c:forEach items="${list}" var="user">
	    <tr>
			<td>${user.userid}</td>
			<td>${user.username}</td>
			<td>${user.userpwd}</td>
			<td><a href="" class="glyphicon glyphicon-edit"></a>&nbsp;&nbsp;&nbsp;
			    <a href="" class="glyphicon glyphicon-remove"></a></td>
		</tr>
	 </c:forEach>	
	</tbody>
	
</table>
<button id="lastpage">上一页</button><button id="nextpage">下一页</button>
</body>
</html>
