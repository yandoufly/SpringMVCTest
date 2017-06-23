<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>所有用户列表</title>
<script type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function del(id){
		$.get("/springMVC12/user/delUser?id=" + id, function(data){
			alert(data.result);
			if("success" == data.result){
				alert("删除成功!");
				window.location.reload(); 
			}else{
				alert("删除失败!")
			}
		}
		);
	}
</script>
</head>
<body>
<table border="1">
	<tbody>
		<tr><th>姓名</th><th>年龄</th><th>编辑</th><th>删除</th></tr>
		
		<c:if test="${!empty user }">
			<c:forEach items="${user }" var="u">
				<tr>
					<td>${u.userName }</td>
					<td>${u.age }</td>
					<td><a href="/springMVC12/user/getUser?id=${u.id }">编辑</a></td>
					<td><a href="javascript:del('${u.id }')">删除</a></td>
				</tr>
			</c:forEach>
		</c:if>
		
	</tbody>
</table>
</body>
</html>
