package com.project.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.service.FlashcardService;

@Service
public class DatabaseConnectionTest {
	
	@Autowired
	private FlashcardService flashcardService;
	
	public void testConnection() {
		try {
			Map<Integer, Map<String, String>> flashcard = flashcardService.getAllFlashcards();
			System.out.println("Number of flashcards retrieved: " + flashcard.size());
		} catch(Exception e) {
			System.err.println("Error testing database connection: " + e.getMessage());
		}
	}
}
s