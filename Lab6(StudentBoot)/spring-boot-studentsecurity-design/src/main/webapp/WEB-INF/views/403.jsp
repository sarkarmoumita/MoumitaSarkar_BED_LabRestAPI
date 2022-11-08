<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<body>
	<h1>HTTP Status 403 - Access is denied</h1>
	<h2>${msg}</h2>
	<hr>
	<form action="/studentManagement/students/list" class="form-inline">
	<a style="font-size:30px" href="/studentManagement/students/list">Back to Students List</a>
	</form>
</body>
</html>