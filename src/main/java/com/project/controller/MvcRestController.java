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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Flashcard;
import com.project.service.FlashcardService;

@RestController
@RequestMapping("/api/flashcard")
public class MvcRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(MvcRestController.class);
	
	@Autowired
	FlashcardService flashcardService;
	
	public MvcRestController(FlashcardService flashcardService) {
		this.flashcardService = flashcardService;
	}
	
	@GetMapping
    public ResponseEntity<List<Flashcard>> getAllFlashcards() {
        List<Flashcard> flashcards = flashcardService.getAllFlashcards();
        if(flashcards.isEmpty()) {
        	return ResponseEntity.noContent().build();
        } else {
        	return ResponseEntity.ok(flashcards);
        }
    }
	
	@GetMapping("/{id}")
	public Flashcard getFlashcardById(@PathVariable Long id) {
		return new ResponseEntity<Flashcard>(flashcardService.getFlashcard(id), HttpStatus.CREATED).getBody();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Void> addFlashcard(@RequestBody Flashcard flashcard) {
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
	
	@PutMapping("/update/{id}")
    public ResponseEntity<String> updateFlashcard(@PathVariable("id") Long id, 
    		@RequestParam("question") String question, @RequestParam("answer") String answer) {
    	boolean updated = flashcardService.updateFlashcard(id, question, answer);
    	if(updated) {
    		return ResponseEntity.ok().body("Flashcard updated successfully");
    	} else {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update flashcard");
    	}
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteFlashcardById(@PathVariable Long id) {
		try {
			Flashcard deleted = flashcardService.deleteFlashcard(id);
			if(deleted != null) {
				return ResponseEntity.ok("Flashcard with ID " + id + " deleted successfully");
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete flashcard with ID " + id);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occured while deleting flashcard with ID " + id);
		}
	}
}