package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Flashcard;

@Service
public interface FlashcardService {
	void saveFlashcard(Flashcard flashcard);
	List<Flashcard> getAllFlashcards();
}
