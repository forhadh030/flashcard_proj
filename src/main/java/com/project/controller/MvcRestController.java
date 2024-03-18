package com.project.controller;

import java.util.Date;
import java.util.List;

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
        return new ResponseEntity<>(flashcardService.getFlashcards(), HttpStatus.CREATED).getBody();
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createFlashcard(@RequestBody Flashcard flashcard) {
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
    public Flashcard getFlashcardById(@PathVariable Long id) {
    	return new ResponseEntity<Flashcard>(flashcardService.getFlashcard(id), HttpStatus.CREATED).getBody();
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<Flashcard> updateFlashcard(@PathVariable("id") Long id, @RequestBody Flashcard flashcard) {
    	Flashcard existingFlashcard = flashcardService.getFlashcard(id);
    	System.out.println(existingFlashcard);
    	if(existingFlashcard != null) {
    		existingFlashcard.setQuestion(flashcard.getQuestion());
    		existingFlashcard.setAnswer(flashcard.getAnswer());
    		flashcardService.updateFlashcard(existingFlashcard);
    		return new ResponseEntity<>(existingFlashcard, HttpStatus.OK);
    	} else {
    		System.out.println("data do not exist");
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
    
    @DeleteMapping("/delete/{id}")
    public List<Flashcard> deleteFlashcardById(@PathVariable Long id) {
    	flashcardService.deleteFlashcard(id);
    	return flashcardService.getFlashcards();
    }
}