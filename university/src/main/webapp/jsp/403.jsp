<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title><spring:message code='403.error'/></title>
</head>
<body>
	<div>
		<div>
				<h3><spring:message code='403.no_access'/></h3>
		
		</div>
		
			<form action="/home" method="post">
				<spring:message code='403.go_home' var='home'/>
				<input type="submit" value="${home }"/>
				<input type="hidden" name="${_csrf.parameterName}" value ="${_csrf.token}"/>
			</form>
		
			<form action="/logout" method="post">
				<spring:message code='403.sign_as' var='sign_as'/>
				<input type="submit" value="${sign_as }"/>
				<input type="hidden" name="${_csrf.parameterName}" value ="${_csrf.token}"/>
			</form>
	
		</div>
</body>
</html>