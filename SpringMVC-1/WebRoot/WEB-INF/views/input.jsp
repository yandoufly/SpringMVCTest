<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加雇员</title>

</head>
<body>
    <!-- 
    	1.why 使用form标签？ k'y更快速的开发出表单页面，而且可以更方便进行表单值回显
    	2.注意：
    	可以通过modelAttribute属性指定绑定的模型属性，若没有指定则默认从request域对象中读取command的表单bean，
    	如果该属性不存在则发生错误
     -->
     <form:form action="${pageContext.request.contextPath }/emp" method="POST" modelAttribute="employee">
     	<!-- path属性对应html表单标签的name属性 -->
    	<c:if test="${employee.id == null }">
     		LastName:<form:input path="lastName"/><br>
     	</c:if>
     	<c:if test="${employee.id != null }">
     		<form:hidden path="id"/>
     		<input type="hidden" name="_method" value="PUT">
     	</c:if>
     	Email:<form:input path="email"/><br>
     	<%
     		Map<String,String> genders = new HashMap();
     		genders.put("1", "Male");
     		genders.put("0", "Female");
     	
     		request.setAttribute("genders", genders);
     	 %>
     	Gender: <form:radiobuttons path="gender" items="${genders }"/><br>
     	Department:<form:select path="department.id"
     		items="${departments }" itemLabel="departmentName" itemValue="id"></form:select><br>
     	<input type="submit" value="submit" />
     </form:form>
</body>
</html>
