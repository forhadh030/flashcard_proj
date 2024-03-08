function submitFlashcardForm() {
	
	var formData = {
		question: $('#question').val(),
		answer: $('#answer').val()
	};
	
	$.ajax({
		type: 'POST',
		url: '/',
		contextType: 'application/json',
		data: JSON.stringify(formData),
		success: function(response) {
			console.log('Flashcard saved successfully: ', response);
			window.location.href='/';
		},
		error: function(error) {
			console.error('Error saving flashcard: ', error);
			alert('Failed to save flashcard. Please try again.');
		}
	});
}