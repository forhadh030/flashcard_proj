package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Flashcard;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
}