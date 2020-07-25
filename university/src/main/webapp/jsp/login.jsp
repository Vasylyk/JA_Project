<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang = "en">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <meta name="description" content="">
    <meta name="author" content="">

	<title>Login</title>
	
	<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="../css/login.css">
</head>
<body>
	<div id="login">
	<div class="container">
	
		
		<div id="login-row" class="row justify-content-center align-items-center">
        <div id="login-column" class="col-md-6">
        <div id="login-box" class="col-md-12">
	    <form method="POST" action="${contextPath}/login" class="form-signin form" id="login-form" style = "height: 350px">
	        <h2 class="form-heading text-center text-info" >Log in</h2>
	
	        <div class="form-group ${error != null ? 'has-error' : ''}">
	            <span>${message}</span>
	            <div class="form-group">
	            <input name="email" type="text" class="form-control" placeholder="Email "
	                   autofocus="true" />
	            </div>
	            
	            <div class="form-group">
	            <input name="password" type="password" class="form-control" placeholder="Password"/>
				</div>
				
				<div class="form-group">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	            <button class="btn btn-lg btn-primary btn-block" class="btn btn-info btn-md" type="submit" >Log In</button>
	            </div>
	            
	            <div id="register-link" class="form-group" style = "padding-top: 80px; text-align: center">
                     <a href="${contextPath}/registration">Create an account</a>
                </div>
	        </div>
	    </form>
	    </div>
	    </div>
	    </div>

	</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>