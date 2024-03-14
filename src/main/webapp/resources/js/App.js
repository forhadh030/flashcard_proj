angular.module("myApp", [])

.controller("FlashcardController", function($scope, $http, $window) {
	
	let URL = "http://localhost:8080/api/flashcard/";
	
	// Initialize flashcards array
	$scope.flashcards = [];
	
	// Fetch all flashcards
	$http.get(URL)
	.then(function(response) {
		$scope.flashcards = response.data;
	})
	.catch(function(error) {
		console.error('Error fetching flashcards:', error);
	});
	
	//Function to create a new flashcard
	$scope.createFlashcard = function() {
		$http.post(URL + "create", $scope.newFlashcard)
		.then(function(response) {
			// Add the newly created flashcard to the list
			$scope.flashcards.push(response.data);
			
			// Reset the form fields
			$scope.newFlashcard = {};
			
			// Set success message
			$scope.showSuccessAlert = true;
			$scope.successMessage = "Flashcard created successfully!";
		})
		.catch(function(error) {
			console.error('Error creating flashcard:', error);
		});
	};
	
	// Function to delete a flashcard
	$scope.deleteFlashcard = function(flashcard) {
		if(confirm("Are you sure you want to delete this flashcard?")) {
			$http.delete(URL + "delete/" + flashcard.id)
			.then(function() {
				var index = $scope.flashcards.indexOf(flashcard);
				if(index != -1) {
					$scope.flashcards.splice(index, 1);
				}
				$scope.showSuccessAlert = true;
				$scope.successMessage = "Flashcard deleted successfully!";
			})
			.catch(function(error) {
				console.error("Error deleting flashcard:", error);
			})
		}
	};
	
	// Function to update a flashcard
	$scope.editFlashcard = function(id, flashcard) {
		$window.location.href = '/editFlashcard?id=' + id, flashcard;
	}	
	
	$scope.updateFlashcard = function(id, updatedFlashcard) {
		$http.put(URL + "update/" + id, updatedFlashcard)
		.then(function(response) {
			
			console.log("Flashcard updated successfully: ", response.data);
			
			$window.location.href = "/viewFlashcards";
			
			})
			.catch(function(error) {
				console.error("Error updating flashcard:", error)
				$scope.errorMessage = "Failed to update flashcard. Please try again later.";
			}
		)
	};
	
	// Function to close the success alert
	$scope.closeSuccessAlert = function() {
		$scope.showSuccessAlert = false;
	};
	
});