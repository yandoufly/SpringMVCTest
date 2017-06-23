<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加用户</title>

<script type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	function addUser(){
		var form = document.forms[0];
		form.action = "/springMVC12/user/addUser";
		form.method = "post";
		form.submit();
	}
</script>
</head>
<body>
    <h1>添加用户</h1>
    <form action="" name="userForm">
    	姓名：<input type="text" name="userName"><br>
    	年龄：<input type="text" name="age"><br>
    	
    	<input type="button" value="添加" onclick="addUser()">
    </form>
</body>
</html>
