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
	 <title>View All Flashcards</title>
</head>
<body ng-controller="FlashcardController">

	<h1>All Flashcards</h1>
	
	<div ng-repeat="flashcard in flashcards">
		<p>{{flashcard.question}} - {{flashcard.answer}}</p>
	</div>
	<a href="/">Back to Home</a>
	
</body>
</html>