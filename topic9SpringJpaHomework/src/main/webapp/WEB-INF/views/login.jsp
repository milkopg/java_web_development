<html>
	<head>
		<title>Login</title>
	</head>
	<body>
		<form name="login" action="/banking/login" method="POST">
			<label>Username</label>
			<input id="username" name="username" type="text"/><br>
			<label>Password</label>
			<input id="password" name="password" type="password" /><br>
			<input name="submit" type="submit" value="Login" />
<%-- 			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
		</form>
	</body>
</html>