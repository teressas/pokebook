<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Read Share</title>
</head>
<body>
	<div class="container mt-5">
		<h1>PokeBook</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Vendor</th>
					<th>Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${expenses }">
					<tr>
						<td>${expense.id }</td>
						<td>${expense.title }</td>
						<td>${expense.vendor }</td>
						<td>${expense.amount }</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		
		<div>
			<h2>Track An Expense:</h2>

			<form:form action="/create" method="post" modelAttribute="newExpense" class="form">
				<p>
					<form:label path="title" class="form-label">Title</form:label>
					<form:errors path="title" class="text-danger"/>
					<form:input path="title" type="text" class="form-control"/>
				</p>
				<p>
					<form:label path="vendor" class="form-label">Vendor</form:label>
					<form:errors path="vendor" class="text-danger" />
					<form:input path="vendor" class="form-control"/>
				</p>
				<p>
					<form:label path="amount" class="form-label">Amount</form:label>
					<form:errors path="amount" class="text-danger"/>
					<form:input path="amount" type="number" class="form-control"/>
				</p>
				<button class="btn btn-primary">Submit</button>
			</form:form>

		</div>
	</div>
</body>
</html>