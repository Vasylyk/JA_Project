<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <meta name="description" content="">
    <meta name="author" content="">
    
	<title><spring:message code='registration.registration'/></title>
	
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
    <div id="login-box" class="col-md-12" style = "height: 330px">
    <form:form method="POST" modelAttribute="userForm" class="form-signin form">
        <h2 class="form-signin-heading text-center text-color"><spring:message code='registration.create_account'/></h2>
        
        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<spring:message code='registration.first_name' var='firstName'/>
                <form:input type="text" path="firstName" class="form-control" placeholder="${firstName }"
                            autofocus="true"></form:input>
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>
        
          <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<spring:message code='registration.last_name' var='lastName'/>
                <form:input type="text" path="lastName" class="form-control" placeholder="${lastName }"
                            autofocus="true"></form:input>
                <form:errors path="lastName"></form:errors>
            </div>
        </spring:bind>
        
        
        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<spring:message code='login.email' var='email'/>
                <form:input type="text" path="email" class="form-control" placeholder="${email }"
                            autofocus="true"></form:input>
                <form:errors path="email"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<spring:message code='login.password' var='password'/>
                <form:input type="password" path="password" class="form-control" placeholder="${password }"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

      

        <button class="btn btn-lg btn-color btn-block" type="submit"><spring:message code='registration.create'/></button>
    </form:form>
	</div>
	</div>
	</div>
</div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>