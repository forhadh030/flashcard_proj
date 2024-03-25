<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" ng-app="myApp">
<head>
	 <meta charset="ISO-8859-1">
	 
	 <script src="${pageContext.request.contextPath}/resources/js/App.js" defer></script>
	 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
	 <link href="<c:url value="/resources/angular/angular-route.js" />" rel="stylesheet">
	 
	 <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
	 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	 
	 <title>View All Flashcards</title>
</head>
<body ng-controller="FlashcardController">

	<div class="view-container">
		<div class="ribbon">
			<div class="header">
				<h1 class="header">All Flashcards</h1>
			</div>
			
			<div ng-if="successMessage" class="alert alert-success alert-dismissible" ng-show="showSuccessAlert" role="alert">
					{{ successMessage }}
			<button type="button" class="close" ng-click="closeSuccessAlert()"><span aria-hidden="true">&times;</span></button>
			</div>
			
			<div class="row">
				<div class="flashcard-card" ng-repeat="flashcard in flashcards")>
					<div class="col-sm-12">
						<div class="card-group">
							<div class="card bg-light border-primary mb-3">
								<div class="card-body">
									<h5 class="card-title">{{ flashcard.question }}</h5>
									<p class="card-text">{{ flashcard.answer }}</p>
									<p><strong>Due Date:</strong> {{ flashcard.date | date: 'yyyy-MM-dd' }}</p>
									<button class="btn btn-primary" ng-click="editFlashcard(flashcard.id, flashcard)">Edit</button>
									<button class="btn btn-danger" ng-click="deleteFlashcard(flashcard)">Delete</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
				
			<div class="footer">
				<a href="/" class="back-to-home">Back to Home</a>
			</div>
		</div>
	</div>
</body>
</html>