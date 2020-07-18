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

<title>Faculty Creating</title>
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
			<a href="/statements" class="w3-bar-item w3-button">Statements</a>
		</div>

		<!-- Page Content -->
		<div style="margin-left: 10%">
			<div class="w3-container w3-teal">
				<h2 style="float: left">Create Faculty</h2>
				<div style="text-align: end">
					<c:if test="${pageContext.request.userPrincipal.name != null}">
        				<form id="logoutForm" method="POST" action="${contextPath}/logout">
            				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        				</form>

        				<h2>${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

    				</c:if>
				</div>
			</div>

			<div class="w3-container">
			
				<form:form method="POST" action="${contextPath}/addFaculty"
					modelAttribute="faculty">
					<table>
							
						<tr>
							<td><form:label path="facultyName">Faculty name: </form:label></td>
							<td>
							<select name="facultyName">
								<c:forEach items="${facultyNames}" var="facultyName">
									<option name="facultyName">${facultyName }</option>
								</c:forEach>
							</select>
							</td>
						</tr>

						<tr>
							<td><form:label path="numberOfStudents">Number of students: </form:label></td>
							<td><form:input path="numberOfStudents" /></td>
						</tr>

						<tr>
							<td><form:label path="firstSubject">First subject: </form:label></td>
							<td>
							<select name="firstSubject">
								<c:forEach items="${subjects}" var="subject">
									<option name="subject">${subject }</option>
								</c:forEach>
							</select>
							</td>
						</tr>
						
						<tr>
							<td><form:label path="secondSubject">Second subject: </form:label></td>
							<td>
							<select name="secondSubject">
								<c:forEach items="${subjects}" var="subject">
									<option name="subject">${subject }</option>
								</c:forEach>
							</select>
							</td>
						</tr>
						
						<tr>
							<td><form:label path="thirdSubject">Third subject: </form:label></td>
							<td>
							<select name="thirdSubject">
								<c:forEach items="${subjects}" var="subject">
									<option name="subject">${subject }</option>
								</c:forEach>
							</select>
							</td>
						</tr>

						<tr>
							<td><input type="submit" value="Submit" /></td>
						</tr>
					</table>

					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form:form>

		
			</div>
		</div>
	</div>

	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>