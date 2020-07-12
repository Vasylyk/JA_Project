<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Faculty Registration</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="container">
		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">Menu</h3>
			<a href="/home" class="w3-bar-item w3-button">Home</a> 
			<a href="/create-faculty" class="w3-bar-item w3-button">Create faculty</a> 
			<a href="/faculties" class="w3-bar-item w3-button">Registration on faculty</a>
		</div>
		
		<!-- Page Content -->
		<div style="margin-left: 10%">
			<div class="w3-container w3-teal">
				<h1>Fill the Form</h1>
			</div>
			
			<form:form method="POST" action="${contextPath}/addMarks" modelAttribute="fr">
				<table>
					<tr>
						<th>Enter your marks: </th>
					</tr>

						<tr>
							<td><form:label path="firstSubjectMark">${fr.faculty.firstSubject}</form:label></td>
							<td><form:input path="firstSubjectMark" /></td>
						</tr>
						
						<tr>
							<td><form:label path="secondSubjectMark">${fr.faculty.secondSubject}</form:label></td>
							<td><form:input path="secondSubjectMark" /></td>
						</tr>
						
						<tr>
							<td><form:label path="thirdSubjectMark">${fr.faculty.thirdSubject}</form:label></td>
							<td><form:input path="thirdSubjectMark" /></td>
						</tr>
						
					<tr>
						<td><form:input type="hidden" path="facultyId" value="${fr.faculty.id}" /></td>
						<td><form:input type="hidden" path="userEmail" value="${fr.user.email}" /></td>
					</tr>

					<tr>
						<td><input type="submit" value="Register" /></td>
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