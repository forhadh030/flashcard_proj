package com.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Flashcard;
import com.project.service.FlashcardService;

@RestController
@RequestMapping("/api/flashcard")
public class MvcRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(MvcRestController.class);

	@Autowired
    private FlashcardService flashcardService;

    @GetMapping
    public List<Flashcard> getAllFlashcards() {
        return flashcardService.getFlashcards();
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createFlashcard(@RequestBody Flashcard flashcard) {
        try {
            flashcardService.saveFlashcard(flashcard);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            // Log the exception for debugging purposes
            logger.error("Error occurred while processing the request: " + e.getMessage(), e);
            // Return an appropriate response indicating failure
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/{id}")
    public Flashcard getFlashcardById(@PathVariable Long id) {
    	for(Flashcard i : flashcardService.getFlashcards()) {
    		if(i.getId() == id) {
    			return new ResponseEntity<Flashcard>(flashcardService.getFlashcard(id), HttpStatus.CREATED).getBody();
    		}
    	}
    	return null;
    };
}