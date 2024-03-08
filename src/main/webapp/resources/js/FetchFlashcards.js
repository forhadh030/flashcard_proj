/**
 * Asynchronous Call (AngularJS Service to Rest-style Java Controller)
 */
const REST_SERVICE_URI = "http://localhost:8080";

function fetchFlashcard() {
	try {
		$.ajax({
			url: '/',
			method: 'GET',
			success: function(flashcards) {
				flashcards.forEach(function(flashcard) {
					$('#flashcardContainer'.append) (
						'<div class="flashcard">' +
						'div class="question">' + flashcard.question + '</div>' +
						'div class="answer">' + flashcard.answer + '</div>' +
						'</div'
					);
				});
			},
			error: function(xhr, status, error) {
				console.error("Error fetching or processing flashcards: ", error);
				console.error(status);
				console.error(xhr);
			}
		});
	} catch(error) {
		console.error('Error making AJAX request: ', error)
	}
 }
 
$(document).ready(function() {
	fetchFlashcard();
});
