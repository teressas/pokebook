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
<title>Edit My Task</title>
</head>
<body>
	<div class="container mt-5">
		<div>
			<h2>Edit Expense:</h2>
		</div>	
		
		<div>
			<a href="/expenses">Go Back</a>
		</div>
		<div>
			<form:form action="/expenses/edit/${expense.id }" method="post" modelAttribute="expense"
				class="form">
				<input type="hidden" name="_method" value="put" />	
				<p>
					<form:label path="title" class="form-label">Expense</form:label>
					<form:errors path="title" class="text-danger" />
					<form:input path="title" type="text" class="form-control" />
				</p>
				<p>
					<form:label path="vendor" class="form-label">Vendor</form:label>
					<form:errors path="vendor" class="text-danger" />
					<form:input path="vendor" class="form-control" />
				</p>
				<p>
					<form:label path="amount" class="form-label">Amount</form:label>
					<form:errors path="amount" class="text-danger" />
					<form:input path="amount" type="double" class="form-control" />
				</p>
				<button class="btn btn-primary">Submit</button>
			</form:form>
		</div>
	</div>

</body>
</html>