<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" ng-app="myApp">
<head>
	 <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
	 <script src="${pageContext.request.contextPath}/resources/js/App.js" defer></script>
	 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
	 <link href="<c:url value="/resources/angular/angular-route.js" />" rel="stylesheet">
</head>
<body ng-controller="FlashcardController">
	<h1>Flashcards App</h1>
	
	<!-- Create flashcard form -->
	<form ng-submit="createFlashcard()">
		<label>Question:</label>
		<input type="text" ng-model="newFlashcard.question" required>
		<label>Answer:</label>
		<input type="text" ng-model="newFlashcard.answer" required>
		<button type="submit">Create Flashcard</button>
	</form>
	
	<br>
	
	<a href="/viewFlashcards">View All The Flashcards</a>
 
</body>
</html>