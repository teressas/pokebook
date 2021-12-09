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
<title>Show Expense</title>
</head>
<body>

	<div class="container mt-5">
		<div>
			<h1>Expense Details</h1>
		</div>
		<div>
			<a href="/expenses">Go Back</a>
		</div>
		<div>
			<p>Expense Name:</p>
			<p>${expenses.title }</p>
			<p>Expense Vendor:</p>
			<p>${expenses.vendor }</p>
			<p>Amount Spent:</p>
			<p>${expenses.amount }</p>
		</div>
		
	</div>

</body>
</html>