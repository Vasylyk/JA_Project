<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
	<div>
		<div>
				<h3>Error!!!</h3>
		</div>
			<form action="/logout" method="post">
				<input type="submit" value="Sign in as different user"/>
				<input type="hidden" name="${_csrf.parameterName}" value ="${_csrf.token}"/>
			</form>
	
	</div>
</body>
</html>