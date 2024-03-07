package com.project.controller;

import java.util.List;
import java.util.Optional;

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
import com.project.repository.FlashcardRepository;

@RestController
@RequestMapping("/api/flashcards")
public class MvcRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(MvcRestController.class);

	@Autowired
    private FlashcardRepository flashcardRepository;

    @GetMapping
    public List<Flashcard> getAllFlashcards() {
        return flashcardRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createFlashcard(@RequestBody Flashcard flashcard) {
        try {
            flashcardRepository.save(flashcard);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            // Log the exception for debugging purposes
            logger.error("Error occurred while processing the request: " + e.getMessage(), e);
            // Return an appropriate response indicating failure
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Flashcard> getFlashcardById(@PathVariable Long id) {
        Optional<Flashcard> optionalFlashcard = flashcardRepository.findById(id);
        return optionalFlashcard.map(ResponseEntity::ok)
                                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
