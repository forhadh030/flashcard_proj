package com.project.FlashcardProvider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.FlashcardProvider.entity.Flashcard;

@Repository
public interface FlashcardRepo extends JpaRepository<Flashcard, Long>{

}
