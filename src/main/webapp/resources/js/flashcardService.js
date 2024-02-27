/**
 * Asynchronous Call (AngularJS Service to Rest-style Java Controller)
 */

const REST_SERVICE_URI = "http://localhost:8080";

function getFlashcardDisplayUrl(question, answer) {
	return "/flashcardDisplay?question=" + encodeURIComponent(question) + "&answer=" + encodeURIComponent(answer);
}
 
 function submitFlashcardForm() {
	 var formData = {
		 "question" : document.getElementById("question").value,
		 "answer" : document.getElementById("answer").value
	 };
	 fetch(REST_SERVICE_URI + "/saveFlashcard", {
		 method: 'POST',
		 headers: {'Content-Type' : 'application/json'
	 },
	 body : JSON.stringify(formData)
	 })
	 .then(response => response.text())
	 .then(data => {
		 console.log(data)
		 redirectToFlashcardDisplay(formData.question, formData.answer);
	 })
	 .catch(error => {
		 console.error('Error', error)
	 });
 }
 
 function redirectToFlashcardDisplay(question, answer) {
	 var flashcardDisplayUrl = getFlashcardDisplayUrl(question, answer);
	 window.location.href = flashcardDisplayUrl;
 }