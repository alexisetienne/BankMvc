<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8" />
<title>Authentification</title>

<link rel="stylesheet" type="text/css" th:href="@{/css/bootstrap.css}"
	href="../static/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" th:href="@{/css/myStyle.css}"
	href="../static/css/myStyle.css" />
</head>
<body>
	<div class="col-md-4 col-md-offset-3 espace ">
		<div class="panel panel-primary">
			<div class="panel-heading">Authentification</div>
			<div class="panel-body">
				<div th:if="${param.error}" class="red">Incorrect Username or
					password</div>
				<div th:if="${param.logout}" class="red">You have been logged
					outs</div>
				21. 20
				<form th:action="@{/login}" method="post">
					<div>
						<label>Utilisateur :</label> <input type="text" name="username" />
					</div>
					<div>
						<label>Password :</label> <input type="password" name="password" />
					</div>
					<button type="submit">Login</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>