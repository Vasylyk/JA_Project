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
				<h2 style="float: left">Registration</h2>
				<div style="text-align: end">
					<c:if test="${pageContext.request.userPrincipal.name != null}">
        				<form id="logoutForm" method="POST" action="${contextPath}/logout">
            				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        				</form>

        				<h2>${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

    				</c:if>
				</div>
			</div>
			
			<c:forEach items="${faculties}" var="currentFaculty">
				<div class="w3-container" style="margin-bottom: 2%">
					<div class="w3-card-4" style="width: 20%">
						<div class="w3-container w3-center" style="padding: 0">
							<h2>${currentFaculty.facultyName}</h2>
							<p>Number of student: ${currentFaculty.numberOfStudents}</p>
							<p>
								List of subjects:<br>
								${currentFaculty.firstSubject}<br>
								${currentFaculty.secondSubject}<br>
								${currentFaculty.thirdSubject}<br>
							</p>
							<a href="faculty-registration?currentFacultyId=${currentFaculty.id}&currentUserEmail=${pageContext.request.userPrincipal.name}">Choose this faculty</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

</body>
</html>