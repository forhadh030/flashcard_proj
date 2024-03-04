<link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet" type="text/css">

<!-- 

	Home/Landing page 
	
	Second page with navigation 
	
	Two Forms (ex.  HTML/Spring <form> ) 
	
	Required field 
	
	Optional field 
	
	Synchronous call (Java MVC)
	
	Asynchronous call (AngularJS Service to Rest-style Java Controller) 

 -->

<!-- Home/Landing Page -->
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="/resources/js/FetchFlashcards.js"></script>
	<title>Flashcard Home</title>
</head>
<body>
	<h2>Welcome to Flashcard</h2>
	<!-- Second page w/ Navigation -->
	<div id="flashcardContainer"></div>
	<a href="/createFlashcardForm"> Create a flashcard </a>
</body>
</html>
