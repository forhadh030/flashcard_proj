package com.project.FlashcardProvider.controller;

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
import org.springframework.web.client.RestTemplate;

import com.project.FlashcardProvider.entity.Flashcard;
import com.project.FlashcardProvider.service.FlashcardService;


@RestController
@RequestMapping("/api/flashcard")
public class FlashcardController {
	
	private static final Logger logger = LoggerFactory.getLogger(FlashcardController.class);

	@Autowired
    private FlashcardService flashcardService;
	
	@Autowired
	RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<Flashcard>> getAllFlashcards() {
    	return new ResponseEntity<>(flashcardService.getAllFlashcards(), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Flashcard> createFlashcard(@RequestBody Flashcard flashcard) {
    	return new ResponseEntity<Flashcard>(flashcardService.saveFlashcard(flashcard), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Flashcard> getFlashcardById(@PathVariable Long id) {
    	return Optional.of(flashcardService.getFlashcardById(id));
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
