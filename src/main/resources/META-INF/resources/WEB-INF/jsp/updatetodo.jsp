<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
	<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >

<style>
body{
	text-align:center; 
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
<title>Add Todo Page</title>
</head>
<body>

	<h2>Update Todo</h2>
	<div class="container">
		<form:form  method="post" modelAttribute="todo">
			<fieldset>
			<form:label path="description">Description</form:label>
			Description: <form:input type="text" placeholder="Enter the Descrition" path="description"  required="required"/>
			<form:errors path="description" cssClass="text-warning"/> <br>
			</fieldset>
			Target Date: <form:input type="date" path="targetdate" placeholder="Enter the due date" required="required" /><br> 
			<form:input path="id" type="hidden"/>
			Status: <form:input placeholder="Enter the Status" path="status" /><br>
			Done: <form:input placeholder="Enter if completed" path="done" />
			<input type="submit" class="btn btn-success">
			

		</form:form>
	</div>
	<script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd'
	});
</script>
</body>
</html>