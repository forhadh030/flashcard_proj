<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<script src="${pageContext.request.contextPath}/resources/js/flashcardService.js"></script>
	<title>Insert title here</title>
</head>
<body>
	<!-- 2 forms (required and optional field) -->
	<form id="flashcardForm" onSubmit="submitFlashcardForm(); return false;">
		<label for="question">Question:</label><br>
		<!-- Required Field -->
		<input type="text" id="question" name="question" required><br>
		<!-- Optional Field -->
		<textarea name="answer" id="answer" rows="4" cols="50"></textarea><br>
		<input type="submit">
	</form>
	<!-- Second page w/ navigation -->
	<a href="/">Return to Homepage</a>
</body>
</html>