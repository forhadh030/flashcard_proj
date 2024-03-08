package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Flashcard;

@Service
public interface FlashcardService {
	
	public List < Flashcard > getFlashcards();
	public void saveFlashcard(Flashcard flashcard);
	public Flashcard getFlashcard(Long id);
	public void deleteFlashcard(Long id);
}
