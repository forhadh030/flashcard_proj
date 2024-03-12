angular.module("myApp", [])

.controller("FlashcardController", function($scope, $http) {
	// Initialize flashcards array
	$scope.flashcards = [];
	
	// Fetch all flashcards
	$http.get('http://localhost:8080/api/flashcards')
	.then(function(response) {
		$scope.flashcards = response.data;
	})
	.catch(function(error) {
		console.error('Error fetching flashcards:', error);
	});
	
	//Function to create a new flashcard
	$scope.createFlashcard = function() {
		$http.post('http://localhost:8080/api/flashcards', $scope.newFlashcard)
		.then(function(response) {
			// Add the newly created flashcard to the list
			$scope.flashcards.push(response.data);
			
			// Reset the form fields
			$scope.newFlashcard = {};
		})
		.catch(function(error) {
			console.error('Error creating flashcard:', error);
		});
	};
});