<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>List of Customers</title>
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/style.css"/>
	</head>
	<body>
		
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		<hr/>
		<div id="container">
		
			<div id="content">
			
			<!-- Add a button: For adding customers -->
		
			<input type="button" value="Add Customer" 
			onclick="window.location.href='showFormForAddCustomer'; return false;"
			class="add-button"/>
			
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					<c:forEach var="tempCustomer" items="${customers}">
					
						<!-- Create an update link for each customer with embedded customer id -->
						<c:url var="updateLink" value="/customer/showFormForUpdateCustomer">
							<c:param name="customerId" value="${tempCustomer.id}"></c:param>
						</c:url>
						
						<!-- Create a delete link for each customer with embedded customer id -->
						<c:url var="deleteLink" value="/customer/deleteCustomer">
							<c:param name="customerId" value="${tempCustomer.id}"></c:param>
						</c:url>
						
					    <tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
							<td><a href="${updateLink}">Update</a> | 
								<a href="${deleteLink}" onclick="return confirm('Do you want to delete the customer?');">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
		</div>
		<hr/>
		
	</body>
</html>