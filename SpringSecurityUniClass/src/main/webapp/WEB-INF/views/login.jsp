<html>
	<head>
		<title>Login</title>
	</head>
	<body>
		<form name="login" action="/uni/login" method="POST">
			<label>Username</label>
			<input id="username" name="username" type="text"/>
			<label>Password</label>
			<input id="password" name="password" type="password" />
			<input name="submit" type="submit" value="Login" />
<%-- 			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
		</form>
	</body>
</html>