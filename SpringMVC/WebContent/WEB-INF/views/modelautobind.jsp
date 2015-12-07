<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 这是Spring MVC提供的表单标签,当然也可以使用HTML的原生标签 -->
	<form:form modelAttribute="accountmodel" method="post">
	用户名：<form:input path="username"/><br >
	密码：<form:password path="password"/><br />
	<input type="submit" value="submit">
	</form:form>
</body>
</html>