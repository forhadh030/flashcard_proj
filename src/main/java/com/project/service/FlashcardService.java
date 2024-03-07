package com.project.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.entity.Flashcard;

@Service
public interface FlashcardService {
	
	void saveFlashcard(String question, String answer);
    Map<Integer, Map<String, String>> getAllFlashcards();
    Map<String, String> getFlashcardById(int id);
    void updateFlashcard(Flashcard flashcard);
    void deleteFlashcard(Long flashcardId);
}
