<!-- login.jsp -->
<html>
<head>
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<form action="${pageContext.request.contextPath}/loginPage" method="post">
		Username: <input type="text" name="username" required autocomplete="username"><br>
		Password: <input type="password" name="password" required><br> <input
			type="submit" value="Login">
		<c:if test="${not empty error}">
			<div style="color: red">${error}</div>
		</c:if>
	</form>

</body>
</html>
