<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" ng-app="myApp">
<head>
	<meta charset="UTF-8">
	
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" >
	<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/resources/js/App.js" defer></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-route.js"></script>
	
	<title>Flashcard App</title>
</head>
<body ng-controller="FlashcardController">
	<div class="home-container center-box">
		<div class="card card-size">
			<div class="card-body">
				<h1 class="card-title mb-4">Flashcards App</h1>
				
				<div ng-if="successMessage" class="alert alert-success alert-dismissible" ng-show="showSuccessAlert" role="alert">
					{{ successMessage }}
				<button type="button" class="close" ng-click="closeSuccessAlert()"><span aria-hidden="true">&times;</span></button>
				</div>
				
				<!-- Create flashcard form -->
				<form ng-submit="createFlashcard()" class="mb-4">
					<div class="form-group">
						<label for="date">Date:</label>
						<input type="date" class="form-control" id="date" ng-model="newFlashcard.date" required>
					</div>
					
					<div class="form-group">
						<label for="question">Question:</label>
						<input type="text" id="question" class="form-control" ng-model="newFlashcard.question" required>	
					</div>
					
					<div class="form-group">
						<label for="answer">Answer:</label>
						<input type="text" id="answer" class="form-control" ng-model="newFlashcard.answer" required>	
					</div>
					<button type="submit" class="btn btn-primary">Create Flashcard</button>
				</form>
				
				<a href="/viewFlashcards" class="btn btn-secondary">View All The Flashcards</a>
			</div>
	 	</div>
 	</div>
</body>
</html>