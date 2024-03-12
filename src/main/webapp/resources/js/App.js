angular.module("myApp", [])

.controller("FlashcardController", function($scope, $http) {
	
	let URL = "http://localhost:8080";
	
	// Initialize flashcards array
	$scope.flashcards = [];
	
	// Fetch all flashcards
	$http.get(URL + '/api/flashcard')
	.then(function(response) {
		$scope.flashcards = response.data;
		console.log(response.data);
	})
	.catch(function(error) {
		console.error('Error fetching flashcards:', error);
	});
	
	//Function to create a new flashcard
	$scope.createFlashcard = function() {
		$http.post(URL + "/api/flashcard/create", $scope.newFlashcard)
		.then(function(response) {
			// Add the newly created flashcard to the list
			$scope.flashcards.push(response.data);
			console.log(response.data);
			
			// Reset the form fields
			$scope.newFlashcard = {};
		})
		.catch(function(error) {
			console.error('Error creating flashcard:', error);
		});
	};
	
});