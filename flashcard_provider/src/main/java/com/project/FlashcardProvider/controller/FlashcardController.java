package com.project.FlashcardProvider.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.FlashcardProvider.entity.Flashcard;
import com.project.FlashcardProvider.service.FlashcardService;


@RestController
@RequestMapping("/api/flashcard")
public class FlashcardController {
	
	private static final Logger logger = LoggerFactory.getLogger(FlashcardController.class);

	@Autowired
    private FlashcardService flashcardService;

    @GetMapping
    public ResponseEntity<List<Flashcard>> getAllFlashcards() {
    	return new ResponseEntity<>(flashcardService.getAllFlashcards(), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Flashcard> createFlashcard(@RequestBody Flashcard flashcard) {
    	try {
        	flashcard.setDate(new Date());
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
    @ResponseStatus(HttpStatus.OK)
    public Flashcard getFlashcardById(@PathVariable Long id) {
    	return flashcardService.getFlashcardById(id);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Flashcard> updateFlashcard(@PathVariable("id") Long id, @RequestBody Flashcard flashcard) {
    	Flashcard updatedFlashcard = flashcardService.updateFlashcard(id, flashcard);
    	return new ResponseEntity<>(updatedFlashcard, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFlashcardById(@PathVariable Long id) {
    	flashcardService.deleteFlashcard(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
