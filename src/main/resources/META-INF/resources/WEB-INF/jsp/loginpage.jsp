<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
c1{
text-align: center;
margin-left: auto;
margin-right: auto;
padding-left: 30px;
padding-top: 30px;

}
h1{
background-color: aqua;
text-align:center;
margin-left: auto;
margin-right: auto;
}
h2{
text-align: center;
}</style>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1>Hello User</h1>
<h2>Welcome to Login Page ${name}!</h2>
<pre>${errormsg}</pre>
<div class="c1">
<form class="form1" method="post">
Name: <input type="text" placeholder="Enter your Name" name="name"/><br>
Password: <input type="password"  placeholder="Enter your Name" name="password" required/><br>
Email: <input type="email"  placeholder="Enter your Name" name="email" required/><br>
Phone: <input type="text" placeholder="Enter your Name" name="phone"/><br>
 <input type="submit" /> 

</form>
</div>
</body>
</html>