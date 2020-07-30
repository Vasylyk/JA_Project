<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang = "en">
<head>
 	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <meta name="description" content="">
    <meta name="author" content="">
    
	<title><spring:message code='rating.rating'/></title>
	
	<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<style>
		.all-abiturients,
		.all-abiturients td,
		.all-abiturients th { border: 1px solid black; }
		
		table {border-collapse: collapse;}
	</style>
</head>

<body>
	<div class="container">
	
		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 11%">
			<h3 class="w3-bar-item"><spring:message code='sidebar.menu'/></h3>
			<a href="/home" class="w3-bar-item w3-button"><spring:message code='sidebar.home'/></a> 
			<a href="/faculties" class="w3-bar-item w3-button"><spring:message code='sidebar.registration_faculty'/></a>
			<a href="/ratingFaculties" class="w3-bar-item w3-button"><spring:message code='sidebar.rating'/></a>
			<security:authorize access="hasRole('ADMIN')">
				<a href="/statements" class="w3-bar-item w3-button"><spring:message code='sidebar.statements'/></a>
				<a href="/create-faculty" class="w3-bar-item w3-button"><spring:message code='sidebar.create_faculty'/></a> 
			</security:authorize>
		</div>
		
		<!-- Page Content -->
		<div style="margin-left: 11%">
				<div class="w3-container w3-teal">
					<h2 style="float: left"><spring:message code='rating.rating'/></h2>
					<div style="text-align: end">
						<c:if test="${pageContext.request.userPrincipal.name != null}">
	        				<form id="logoutForm" method="POST" action="${contextPath}/logout">
	            				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        				</form>
	
	        				<h2>${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()"><spring:message code='logout.logout'/></a></h2>
	
	    				</c:if>
					</div>
				</div>
				
				<h2 style = "margin-left: 2%">${currentFaculty.facultyName } <spring:message code='rating.faculty'/></h2>
				<h2 style = "margin-left: 2%"><spring:message code='rating.rating_entrants'/></h2></h2>
			
				<table class = "all-abiturients" style = "margin-left: 2%">
					<tr>
						<th><spring:message code='rating.number'/></th>
						<th><spring:message code='home.first_name'/></th>
						<th><spring:message code='home.second_name'/></th>
						<th><spring:message code='home.photo'/></th>
						<th><spring:message code='home.marks'/></th>
						<th><spring:message code='rating.average'/></th>
						<th><spring:message code='rating.acception'/></th>
					</tr>
					<c:forEach items="${entrantsOfCurrentFaculty}" var="entrant">
						<tr>
							<td>${entrantsOfCurrentFaculty.indexOf(entrant)+1}</td>
							<td>${entrant.user.firstName}</td>
							<td>${entrant.user.lastName}</td>
							<td><img src="data:image/png;base64,${entrant.encodedImage}" width="90" height="120" /></td>
							<td>${entrant.faculty.firstSubject}<br>${entrant.firstSubjectMark}<br>${entrant.faculty.secondSubject}<br>${entrant.secondSubjectMark}<br>${entrant.faculty.thirdSubject}<br>${entrant.thirdSubjectMark}</td>
							<td>${(entrant.firstSubjectMark+entrant.secondSubjectMark+entrant.thirdSubjectMark)/3}</td>
							<td>${isAccepted.get(entrantsOfCurrentFaculty.indexOf(entrant))}</td>
						</tr>
					</c:forEach>
				</table>
				
		</div>
	</div>
	
</body>
</html>