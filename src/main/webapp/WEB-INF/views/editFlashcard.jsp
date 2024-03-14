<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" ng-app="myApp">
<head>
	 <meta charset="ISO-8859-1">
	 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js" defer></script>
	 <script src="${pageContext.request.contextPath}/resources/js/App.js" defer></script>
	 <link href="<c:url value="/resources/angular/angular-route.js" />" rel="stylesheet">
	 
	 <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
	 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	 <title>Edit Flashcard</title>
</head>
<body ng-controller="FlashcardController">

	<div class=container mt-5">
		<h2>Edit Flashcard</h2>
		
		<div class="mb-3">
			<label for="previousQuestion" class="form-label">Previous Question:</label>
			<p id="previousQuestion">{{ flashcard.question }}</p>
		</div>
		
		<div class="mb-3">
			<label for="previousAnswer" class="form-label">Previous Answer:</label>
			<p id="previousAnswer">{{ flashcard.answer }}</p>
		</div>
		
		
		<form ng-submit="updateFlashcard(flashcard.id, updatedFlashcard)">
			<div class="form-group">
				<label for="question">New Question:</label>
				<input type="text" class="form-control" id="question" ng-model="updatedFlashcard.question" required>
			</div>
			
			<div class="form-group">
				<label for="answer">New Answer:</label>
				<input type="text" class="form-control" id="answer" ng-model="updatedFlashcard.answer" required>
			</div>
			
			<button type="submit" class="btn btn-primary">Update Flashcard</button>
			
		</form>
	</div>
	<script>
		console.log("Flashcard object: ", flashcard);
	</script>
</body>
</html>