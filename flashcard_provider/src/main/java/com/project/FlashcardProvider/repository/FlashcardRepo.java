package com.project.FlashcardProvider.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.FlashcardProvider.entity.Flashcard;

public interface FlashcardRepo extends CrudRepository<Flashcard, Long>{

}
