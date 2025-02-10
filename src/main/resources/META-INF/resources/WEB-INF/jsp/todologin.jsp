<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	align-items: inherit;
	background-image: url('login1.jfif');
}

c1 {
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	padding-left: 30px;
	padding-top: 30px;
}

h1 {
	background-color: aqua;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
}

h2 {
	text-align: center;
}
</style>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<link rel="stylesheet" href="/style.css">
</head>
<body>

	<div class="container">
		<h1>Hello User</h1>
		<h2>Welcome to Login Page ${name}!</h2>
		<pre>${errormsg}</pre>

		<form class="form1" method="post">
			Name: <input type="text" placeholder="Enter your Name" name="name" required/><br>
			Password: <input type="password" placeholder="Enter your Password"
				name="password" required /><br>
				 Email: <input type="email"
				placeholder="Enter your Email" name="email" required /><br>
			Phone: <input type="text" placeholder="Enter your Phone" name="phone" /><br>
			<input type="submit" />

		</form>
		
	</div>
	<script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>