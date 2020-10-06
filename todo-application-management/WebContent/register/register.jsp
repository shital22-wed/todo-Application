<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ToDO Application</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

</head>
<body style="background-color:#484848; color:white;">
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container">

	<h2>User Register Form</h2>
	<div class="col-md-6 col-md-offset-3">
			<div class="alert alert-success center" role="alert">
				<p>${NOTIFICATION}</p>
			</div>
			
				<form action="<%=request.getContextPath()%>/register" method="post">

					<div class="form-group">
						<label for="firstName">First Name:</label> <input type="text"
							class="form-control" id="firstName" placeholder="First Name"
							name="firstName" required>
					</div>

					<div class="form-group">
						<label for="lastName">Last Name:</label> <input type="text"
							class="form-control" id="lastName" placeholder="last Name"
							name="lastName">
					</div>
					
					<div class="form-group">
						<label for="gender">Gender:</label> <input type="text"
							class="form-control" id="gender" placeholder="Gender"
							name="gender" required>
					</div>
					
					<div class="form-group">
						<label for="phone">Phone:</label> <input type="text"
							class="form-control" id="phone" placeholder="contact no"
							name="phone" required>
					</div>

					<div class="form-group">
						<label for="username">User EmailId:</label> <input type="text"
							class="form-control" id="username" placeholder="User EMailId"
							name="username" required>
					</div>

					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							class="form-control" id="password" placeholder="Password"
							name="password" required>
					</div>
					
					<div class="form-group">
						<label for="rep_password">Repeat Password:</label> <input type="password"
							class="form-control" id="password" placeholder="Repeat Password"
							name="rep_password" required>
					</div>
					
					 <!-- <div class="form-group">
						<label for="status">status:</label> <input type="text"
							class="form-control" id="status" placeholder="active"
							name="status" required>
					</div> -->
 
					<button type="submit" class="btn btn-primary">Submit</button>

				</form>
			</div>
		</div>
	
</body>
</html>