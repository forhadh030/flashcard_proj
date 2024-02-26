<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- 2 forms (required and optional field) -->
	<form action="POST">
		<label for="title" name="title">Title</label><br>
		<input type="text" id="title" name="title" required><br>
		<textarea name="message" rows="10" cols="30"></textarea><br>
		<input type="submit">
	</form>
	<!-- Second page w/ navigation -->
	<a href="/">Return to Homepage</a>
</body>
</html>