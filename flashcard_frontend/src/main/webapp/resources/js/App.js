var app = angular.module('flashcardApp', ['ngRoute']);

app.config(function($routeProvider) {
	$routeProvider
	.when('/', {
		templateUrl: 'views/home.html',
		controller: 'HomeController'
	})
	.when('/flashcards', {
		templateUrl: 'views/flashcards.html',
		controller: 'FlashcardController'
	})
	.otherwise({
		redirectTo: '/'
	});
})