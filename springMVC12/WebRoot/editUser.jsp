<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>更新用户</title>

</head>
<body>
<h1>编辑用户</h1>
<form action="/springMVC12/user/updateUser" method="post">
	<input type="hidden" name="id" value="${user.id }">
	姓名：<input type="text" name="userName" value="${user.userName }"><br>
	年龄：<input type="text" name="age" value="${user.age }"><br>
	<input type="submit" value="提交">
</form>
</body>
</html>
