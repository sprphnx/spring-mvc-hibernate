<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<title>Add new customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h1>CRM - Customer Relation Manager</h1>
		</div>
	</div>
	<br>

	<div id="container">
		<h2>Add new customer</h2>
		<div id="content">
			<form:form action="addCustomer" modelAttribute="customer"
				method="POST">
				<table>
					<tbody>
						<tr>
							<td><label>First Name: </label></td>
							<td><form:input path="firstName" /></td>
						</tr>
						<tr>
							<td><label>Last Name: </label></td>
							<td><form:input path="lastName" /></td>
						</tr>
						<tr>
							<td><label>Email: </label></td>
							<td><form:input path="email" /></td>
						</tr>
						<tr>
							<td colspan="2" align="left"><input type="submit" value="Add Customer"></td>
						</tr>
					</tbody>
				</table>
			</form:form>
		</div>
	</div>

</body>

</html>