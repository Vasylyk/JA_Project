<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title><spring:message code='rating.rating'/></title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
			
			<c:forEach items="${faculties}" var="currentFaculty">
				<div class="w3-container" style="margin-bottom: 2%">
					<div class="w3-card-4" style="width: 30%">
						<div class="w3-container w3-center" style="padding: 0">
							<h2>${currentFaculty.facultyName}</h2>
							<p><spring:message code='faculties.number_students'/> ${currentFaculty.numberOfStudents}</p>
							<a href="rating?currentFacultyId=${currentFaculty.id}"><spring:message code='rating.show_rating'/></a>
						</div>
					</div>
				</div>
			</c:forEach>
			
		</div>
	</div>
</body>
</html>