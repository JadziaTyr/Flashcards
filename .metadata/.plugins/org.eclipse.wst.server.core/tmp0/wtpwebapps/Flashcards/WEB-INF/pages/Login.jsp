<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<title>Log-in</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css"
	href="/Flashcards/resources/css/style.css">
</head>

<body>

	<div class="container">
		<div class="row">
			<c:if test="${ message != null }">
				<div class="alert alert-danger text-center col-md-4 col-md-offset-4">${message}</div>
			</c:if>
		</div>
		<form:form action="login" method="POST" commandName="user"
			class="col-md-4">
	Username: <form:input path="username" class="form-control" />
			<br />
	Password: <form:input path="password" class="form-control" />
			<br />
			<input type="submit" value="Login">
		</form:form>
	</div>
</body>