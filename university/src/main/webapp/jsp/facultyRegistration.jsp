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

<title><spring:message code='faculties.faculty_registration'/></title>
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
				<h2 style="float: left"><spring:message code='faculties.registration'/></h2>
				<div style="text-align: end">
					<c:if test="${pageContext.request.userPrincipal.name != null}">
        				<form id="logoutForm" method="POST" action="${contextPath}/logout">
            				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        				</form>

        				<h2>${pageContext.request.userPrincipal.name} | <button onclick="document.forms['logoutForm'].submit()"><spring:message code='logout.logout'/></button></h2>

    				</c:if>
				</div>
			</div>
			
			<form:form method="POST" action="${contextPath}/addMarks" enctype="multipart/form-data">
				<table>
					<tr>
						<th><spring:message code='faculties.enter_your_marks'/> </th>
					</tr>

						<tr>
							<td>${fr.faculty.firstSubject}</td>
							<td><input type = "number" name="firstSubjectMark" /></td>
						</tr>
						
						<tr>
							<td>${fr.faculty.secondSubject}</td>
							<td><input type = "number" name="secondSubjectMark" /></td>
						</tr>
						
						<tr>
							<td>${fr.faculty.thirdSubject}</td>
							<td><input type = "number" name="thirdSubjectMark" /></td>
						</tr>
						
						<tr>
							<td><spring:message code='faculties.add_photo'/></td>
							<td><input type="file" name="image"/></td>
						</tr>
						
					<tr>
						<td><input type="hidden" name="facultyId" value="${fr.faculty.id}" /></td>
						<td><input type="hidden" name="userEmail" value="${fr.user.email}" /></td>
					</tr>

					<tr>
						<spring:message code='faculties.register' var='register'/>
						<td><input type="submit" value="${register }" /></td>
					</tr>

				</table>

				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form:form>
		</div>
	</div>
	
	<!-- /container -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>