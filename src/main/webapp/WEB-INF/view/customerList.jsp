<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="utf-8">
<title>Customer Relation Manager</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h1>CRM - Customer Relation Manager</h1>
		</div>
	</div>
	<br>

	<div id="container">
		<div id="content">

			<a href="showAddCustomerForm" class="add-button">Add customer</a> <br><br><br>
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<c:forEach var="customer" items="${customers}">
					<c:url var="updateLink" value="showUpdateCustomerForm">
					<c:param name="customerId" value="${customer.id}"></c:param>
					</c:url>
					<c:url var="deleteLink" value="deleteCustomer">
					<c:param name="customerId" value="${customer.id}"></c:param>
					</c:url>
					
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td><a href="${updateLink}">Update</a>/<a href="${deleteLink}">Delete</a></td>
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
