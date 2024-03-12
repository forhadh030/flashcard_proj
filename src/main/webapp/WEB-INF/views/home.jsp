<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en" ng-app="myApp">
<head>
	 <link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet" type="text/css">
	 <link href="../test.css" rel="stylesheet" type="text/css">
</head>
<body ng-controller="FlashcardController">
	<h1>Flashcards App</h1>
	
	<!-- Display Flashcards -->
	<div ng-repeat="flashcard in flashcards">
		<p>{{flashcard.question}} - {{flashcard.answer}}</p>
	</div>
	
	<!-- Create flashcard form -->
	<form ng-submit="createFlashcard()">
		<label>Question:</label>
		<input type="text" ng-model="newFlashcard.answer" required>
		<label>Answer:</label>
		<input type="text" ng-model="newFlashcard.answer" required>
		<button type="submit">Create Flashcard</button>
	</form>
 
</body>
</html>