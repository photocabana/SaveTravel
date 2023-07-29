<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
</head>
<body>
	<h1>Edit Expense</h1>
	<a href="/expenses">Go back</a>
	
	<form:form action="/expenses/edit/${expense.id}" method="post" modelAttribute="expense">
		<div>
			<form:label path="name">Expense Name: </form:label><br />
			<form:errors path="name"/>
			<form:input style="width:200px;" path="name"/>
		</div>
	
		<div>
			<form:label path="vendor">Vendor: </form:label><br />
			<form:errors path="vendor"/>
			<form:input style="width:200px;" path="vendor"/>
		</div>
		
		<div>
			<form:label path="amount">Amount: </form:label><br />
			<form:errors path="amount"/>
			<form:input style="width:200px;" type="number" step="0.01" min="0" path="amount"/>
		</div>
		
		<div>
			<form:label path="description">Description: </form:label><br />
			<form:errors path="description"/>
			<form:textarea style="width:250px;" rows="4" path="description"/>
		</div>
		<div>
			<input type="submit" value="Submit"/>
		</div>
	</form:form>
</body>
</html>