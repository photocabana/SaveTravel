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
<title>Insert title here</title>
</head>
<body>
	<h1>Save Travel</h1>
	<table>
		<tr>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="expense" items="${expenses}">
			<tr>
				<td>
					<a href="/expenses/<c:out value="${expense.id}"/>">
					<c:out value="${expense.name}"/></a>
				</td>
				<td><c:out value="${expense.vendor}"/></td>
				<td>$<fmt:formatNumber type="number" minFractionDigits="2" value="${expense.amount}"/></td>
				<td>
					<a href="/expenses/edit/${expense.id}">edit</a>
					<a href="/expenses/delete/${expense.id}">delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<h1>Add an expense:</h1>
	<form:form action="/expenses" method="post" modelAttribute="expense">
		<div>
			<form:label path="name">Expense Name: </form:label><br>
			<form:errors path="name"/>
			<form:input style="width:200px;" path="name"/>
		</div>
	
		<div>
			<form:label path="vendor">Vendor: </form:label><br>
			<form:errors path="vendor"/>
			<form:input style="width:200px;" path="vendor"/>
		</div>
		
		<div>
			<form:label path="amount">Amount: </form:label><br>
			<form:errors path="amount"/>
			<form:input style="width:200px;" type="number" step="0.01" min="0" path="amount"/>
		</div>
		
		<div>
			<form:label path="description">Description: </form:label><br>
			<form:errors path="description"/>
			<form:textarea style="width:250px;" rows="3" path="description"/>
		</div>
		
		<div>
			<input type="submit" value="Submit"/>
		</div>
	</form:form>
</body>
</html>