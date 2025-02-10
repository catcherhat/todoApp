<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body{
padding-top: 40px;
text-align: center;}
c1 {
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	padding-left: 30px;
	padding-top: 30px;
	padding-bottom : 40px;
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
<title>Todo Page</title>
</head>
<body>
	<%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<h2>Welcome ${username}</h2>
		<hr>
		<h3>Todo List </h3>
		
		<br>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Description</th>
					<th>TargetDate</th>
					<th>Status</th>
					<th>IsDone</th>
					

				</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.description}</td>
						<td>${todo.targetdate}</td>
						<td>${todo.status}</td>
						<td>${todo.done}</td>
						<td><a href="deletetodo?id=${todo.id}" class="btn btn-info">Delete</a></td>
						<td><a href="updatetodo?id=${todo.id}"
							class="btn btn-success ">Update</a></td>
						
					</tr>

				</c:forEach>
			</tbody>
		</table>
		<a href="addtodo" class="btn btn-success">Add Todo</a>
	</div>
	
	<%@ include file="common/footer.jspf" %>