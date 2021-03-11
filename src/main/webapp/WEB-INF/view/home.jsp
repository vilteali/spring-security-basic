<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@	taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Security</title>
</head>
<body>
	<h1>Hola spring security</h1>
	<hr>
	<p>Welcome to the com.ali.springsecurity home page!</p>
	<hr>
	<p>
		User:
		<security:authentication property="principal.username" />
		<br> Role(s):
		<security:authentication property="principal.authorities" />
	</p>
	<hr>
	<security:authorize access="hasRole('ADMINISTRATOR')">
		<p>
			<a href="${pageContext.request.contextPath}/administrators">Administration</a>
		</p>
	</security:authorize>
	<security:authorize access="hasAnyRole('DEVELOPER', 'QA')">
		<p>
			<a href="${pageContext.request.contextPath}/development">Development</a>
		</p>
	</security:authorize>
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>