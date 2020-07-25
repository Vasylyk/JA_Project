<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang = "en">
<head>
 	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <meta name="description" content="">
    <meta name="author" content="">
    
	<title>Statements</title>
	
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
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">Menu</h3>
			<a href="/home" class="w3-bar-item w3-button">Home</a> 
			<a href="/faculties" class="w3-bar-item w3-button">Registration on faculty</a>
			<a href="/ratingFaculties" class="w3-bar-item w3-button">Rating</a>
			<security:authorize access="hasRole('ADMIN')">
				<a href="/statements" class="w3-bar-item w3-button">Statements</a>
				<a href="/create-faculty" class="w3-bar-item w3-button">Create faculty</a> 
			</security:authorize>
		</div>
	
	<!-- Page Content -->
	<div style="margin-left: 10%">
			<div class="w3-container w3-teal">
				<h2 style="float: left">Statements</h2>
				<div style="text-align: end">
					<c:if test="${pageContext.request.userPrincipal.name != null}">
        				<form id="logoutForm" method="POST" action="${contextPath}/logout">
            				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        				</form>

        				<h2>${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

    				</c:if>
				</div>
			</div>
			
			<h2>Statements</h2>
			
			<table class = "all-abiturients">
				<tr>
					<th>First name</th>
					<th>Second name</th>
					<th>Photo</th>
					<th>Faculty name</th>
					<th>Marks</th>
					<th>Accept</th>
					<th>Decline</th>
				</tr>
				<c:forEach items="${facultyRegistrations}" var="current">
					<tr>
						<td>${current.user.firstName}</td>
						<td>${current.user.lastName}</td>
						<td><img src="data:image/png;base64,${current.encodedImage}" width="90" height="120" /></td>
						<td>${current.faculty.facultyName}</td>
						<td>${current.faculty.firstSubject}<br>${current.firstSubjectMark}<br>${current.faculty.secondSubject}<br>${current.secondSubjectMark}<br>${current.faculty.thirdSubject}<br>${current.thirdSubjectMark}</td>
						<td>
							<form:form action="${contextPath}/acceptStatement" method="POST" enctype="multipart/form-data">
								<input type = "hidden" name="currentStatementId" value="${current.id}"/>
								<input type="submit" value="Accept" />
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							</form:form>
						</td>
						<td>
							<form:form action="${contextPath}/declineStatement" method="POST" enctype="multipart/form-data">
								<input type = "hidden" name="currentStatementId" value="${current.id}"/>
								<input type="submit" value="Decline" />
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							</form:form>
						</td>
					</tr>
				</c:forEach>
			</table>
	
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>