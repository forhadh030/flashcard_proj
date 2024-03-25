package com.project.FlashcardProvider.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.FlashcardProvider.entity.Flashcard;


@Service
public interface FlashcardService {

	List < Flashcard > getAllFlashcards();
	Flashcard saveFlashcard(Flashcard flashcard);
	Flashcard getFlashcardById(Long id);
	void deleteFlashcard(Long id);
	Flashcard updateFlashcard(Long id, Flashcard flashcard);
}
