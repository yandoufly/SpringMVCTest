<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>显示所有人信息</title>
<!-- 
	springmvc 处理静态资源：
	1. 若将DispatcherServlet请求映射配置为/，则Springmvc将捕获WEB容器的所有请求，包括静态资源的请求
	2.解决：在Springmvc的配置文件中配置：<mvc:default-servlet-handler />的方式解决静态资源问题
 -->
<script type="text/javascript" src="../scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	/* $(document).ready(function(){
		alter("hello jquery");
		
		$(".delete").click(function(){
			var href = $(this).attr("href");
			$("form").attr("action", href).submit();			
			return true;
		});
	}) */
	function del(id){
		alter("hello jquery");
		$(".delete").click(function(){
			var href = $(this).attr("href");
			$("form").attr("action", href).submit();			
			return true;
		});
	}
</script>
</head>
<body>
	<form action="" method="POST">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>

	<c:if test="${empty requestScope.employees }">
		没有任何员工信息！
	</c:if>
	<c:if test="${!empty requestScope.employees }">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
			<th>ID</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Department</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${requestScope.employees }" var="emp">
			<tr>
				<td>${emp.id }</td>
				<td>${emp.lastName }</td>
				<td>${emp.email }</td>
				<td>${emp.gender == 0 ? 'Female' : 'Male' }</td>
				<td>${emp.department.departmentName }</td>
				<td><a href="emp/${emp.id }">Edit</a></td>
				<%-- <td><a class="delete" href="emp/${emp.id}">Delete</a></td> --%>
				<td><a href="javascript:del('${emp.id }')">Delete</a></td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
	
	<br><br>
	<a href="emp">Add New Employee</a>
</body>
</html>
