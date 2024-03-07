package com.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Flashcard;
import com.project.repository.FlashcardRepository;

@Service
public class FlashcardServiceImpl implements FlashcardService {
	
	@Autowired
    private FlashcardRepository flashcardRepository;

    @Override
    public void updateFlashcard(Flashcard flashcard) {
        System.out.println("work in progress");
    }

    @Override
    public void deleteFlashcard(Long flashcardId) {
    	System.out.println("work in progress");
    }

    @Override
    public void saveFlashcard(String question, String answer) {
        Flashcard flashcard = new Flashcard(question, answer);
        flashcardRepository.save(flashcard);
    }

    @Override
    public Map<Integer, Map<String, String>> getAllFlashcards() {
        List<Flashcard> flashcardsList = flashcardRepository.findAll();
        Map<Integer, Map<String, String>> flashcards = new HashMap<>();
        for (Flashcard flashcard : flashcardsList) {
            Map<String, String> flashcardMap = new HashMap<>();
            flashcardMap.put("question", flashcard.getQuestion());
            flashcardMap.put("answer", flashcard.getAnswer());
            flashcards.put(flashcard.getId().intValue(), flashcardMap);
        }
        return flashcards;
    }

    @Override
    public Map<String, String> getFlashcardById(int id) {
        Flashcard flashcard = flashcardRepository.findById((long) id).orElse(null);
        if (flashcard != null) {
            Map<String, String> flashcardMap = new HashMap<>();
            flashcardMap.put("question", flashcard.getQuestion());
            flashcardMap.put("answer", flashcard.getAnswer());
            return flashcardMap;
        }
        return null;
    }

}
