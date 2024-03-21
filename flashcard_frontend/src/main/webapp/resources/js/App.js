angular.module("myApp", [])

.controller("FlashcardController", function($scope, $http, $window) {
	
	let URL = "http://localhost:8080/api/flashcard/";
	
	// Initialize flashcards array
	$scope.flashcards = [];

	// Fetch all flashcards
	$http.get(URL)
	.then(function(response) {
		$scope.flashcards = response.data;
		if($scope.flashcards == null) {
			$scope.message = "No Data Available";
		}
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
	
	// Function to route to update form and transfer flashcard info
	$scope.editFlashcard = function(id, flashcard) {
		console.log("Editing flashcard with ID: ", id);
		flashcardToUpdate = flashcard;
		$window.location.href = '/editFlashcard?id=' + id, flashcard;
	}
	
	// Function to update the transferred flashcard
	$scope.updateFlashcard = function(updatedFlashcard) {
		var id = new URLSearchParams(window.location.search).get('id');
		console.log("Updating flashcard with ID: ", id);
		
		$http.put(URL + "update/" + id, updatedFlashcard)
		.then(function(response) {
			console.log("Flashcard updated successfully: ", response.data);
			$window.location.href = "/viewFlashcards";
		})
		.catch(function(error) {
			console.error("Error updating flashcard: ", error);
		});
	};
	
	// Function to close the success alert
	$scope.closeSuccessAlert = function() {
		$scope.showSuccessAlert = false;
	};
	
});