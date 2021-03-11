<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login WEB - Security</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" 
        rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" 
        crossorigin="anonymous">
    <link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/login.css"/>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-sm 8 justify-content-md-center">
                <div class="text-center">
                    <img src="${pageContext.request.contextPath}/resources/img/logo.png"/>
                </div>
                <h2 class="fw-bold text-center">Login Page</h2>
                <form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">
                	<div class="col-xs-15">
                		<c:choose>
                			<c:when test="${param.error != null}">
								<div class="alert alert-danger col-xs-offset-1 col-xs-10">
									Invalid username and password.
								</div>
                			</c:when>
                			<c:when test="${param.logout != null}">
								<div class="alert alert-success col-xs-offset-1 col-xs-10">
									You have been logged out.
								</div>          	
                			</c:when>
                		</c:choose>
                	</div>
                    <div class="mb-4">
                        <label for=username class="form-label">Username</label>
                        <input type="text" class="form-control" name="username"
                        	placeholder="Username"> 
                    </div>
                    <div class="mb-4">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" name="password"
                        	placeholder="Password"> 
                    </div>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary">Login</button>
                    </div>
                    <div class="d-grid">
                        <input class="btn btn-primary" type="submit" value="Register New User"
							onclick="window.location.href='registrationForm'; return false;">	
                    </div>
<%--            	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
                </form:form>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
        crossorigin="anonymous">
    </script>
</body>
</html>