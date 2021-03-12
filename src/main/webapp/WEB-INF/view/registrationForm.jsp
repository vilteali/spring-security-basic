<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Register WEB - Security</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" 
        rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" 
        crossorigin="anonymous">
   <link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/registrationForm.css"/>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm 8 justify-content-md-center">
				<div class="text-center">
					<img
						src="${pageContext.request.contextPath}/resources/img/logo.png" />
				</div>
				<h2 class="fw-bold text-center">Register Page</h2>
				<form:form action="${pageContext.request.contextPath}/processRegistrationForm"
					modelAttribute="crmUser" method="POST">
					<div class="mb-4">
						<label for=username class="form-label">Username (*)</label> <input
							type="text" class="form-control" name="username"
							placeholder="Username">
					</div>
					<div class="mb-4">
						<label for="password" class="form-label">Password (*)</label> <input
							type="password" class="form-control" name="password"
							placeholder="Password">
					</div>
					<div class="mb-4">
						<label for="matchingPassword" class="form-label">Confirm password (*)</label> 
							<input type="password" class="form-control" name="matchingPassword"
							placeholder="Confirm password">
					</div>
					<div class="mb-4">
						<label for="firstName" class="form-label">First Name (*)</label> <input
							type="text" class="form-control" name="firstName"
							placeholder="First Name">
					</div>
					<div class="mb-4">
						<label for="lastName" class="form-label">Last Name (*)</label> <input
							type="text" class="form-control" name="lastName"
							placeholder="Last Name">
					</div>
					<div class="mb-4">
						<label for="text" class="form-label">Email(*)</label> <input
							type="text" class="form-control" name="email"
							placeholder="Email">
					</div>
					<div class="d-grid">
						<button type="submit" class="btn btn-primary">Register</button>
					</div>
				</form:form>
				<p>
					<a href="${pageContext.request.contextPath}/loginPage">Back to home</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>