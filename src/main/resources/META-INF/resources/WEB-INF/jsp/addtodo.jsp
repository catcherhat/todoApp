
    <%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>
	<h2>Create New Todo</h2>
	<div class="container">
		<form:form  method="post" modelAttribute="todo">
			
			Description: <form:input type="text" placeholder="Enter the Descrition" path="description"  required="required"/>
			<form:errors path="description" cssClass="text-warning"/><br>
			Target Date: <form:input type="date" path="targetdate" placeholder="Enter the due date" required="required" /><br> 
			<form:input path="id" type="hidden"/>
			<form:input path="username" type="hidden"/>
			<form:input path="status" type="hidden"/>
			<form:input path="done" type="hidden"/>
			<input type="submit" class="btn btn-success">
			

		</form:form>
	</div>
		<%@ include file="common/footer.jspf" %>