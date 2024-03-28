package com.project.FlashcardProvider.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.FlashcardProvider.entity.Flashcard;
import com.project.FlashcardProvider.repository.FlashcardRepo;


@Service
public class FlashcardServiceImpl implements FlashcardService {
	
	private final String BASE_URL = "http://localhost:8080/api/flashcard";
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private FlashcardRepo flashcardRepo;

	public FlashcardServiceImpl(FlashcardRepo flashcardRepo) {
		this.flashcardRepo = flashcardRepo;
	}

	@Override
	public List<Flashcard> getAllFlashcards() {
		return flashcardRepo.findAll();
	}

	@Override
	public Flashcard saveFlashcard(Flashcard flashcard) {
		System.out.println(flashcard);
		return flashcardRepo.save(flashcard);
	}

	@Override
	public Flashcard getFlashcardById(Long id) {
		return flashcardRepo.findById(id).get();
	}

	@Override
	public void deleteFlashcard(Long id) {
		Optional<Flashcard> optionalFlashcard = flashcardRepo.findById(id);

		if(optionalFlashcard.isPresent()) {
			flashcardRepo.deleteById(id);
			System.out.println("The flashcard with id " + id + " has been deleted successfully");
		} else {
			throw new IllegalArgumentException("Flashcard with id " + id + " does not exist in the database.");
		}
	}

	@Override
	public Flashcard updateFlashcard(Long id, Flashcard flashcard) {
		Optional<Flashcard> optionalFlashcard = flashcardRepo.findById(id);
		if(optionalFlashcard.isPresent()) {
			optionalFlashcard.get().setDate(flashcard.getDate());
			optionalFlashcard.get().setQuestion(flashcard.getQuestion());
			optionalFlashcard.get().setAnswer(flashcard.getAnswer());
			flashcardRepo.save(optionalFlashcard.get());
			return optionalFlashcard.get();
		} else {
			throw new IllegalArgumentException("Flashcard with id " + id + " does not exist in the database.");
		}
	}
}