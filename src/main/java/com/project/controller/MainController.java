package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.entity.Flashcard;
import com.project.service.FlashcardService;


@Controller
public class MainController {
	
	@Autowired
	private FlashcardService flashcardService;
	
	@GetMapping(value = "/")
	public String home() {
		return "home";
	}
	
	@GetMapping(value = "/viewFlashcards")
	public String viewAllFlashcards(Model model) {
		List<Flashcard> flashcards = flashcardService.getFlashcards();
		model.addAttribute("flashcard", flashcards);
//		model.addAttribute("newFlashcard", new Flashcard());
		return "viewFlashcards";
	}
	
	@PostMapping("/create")
	public String createFlashcard(@ModelAttribute("flashcard") Flashcard flashcard) {
		flashcardService.saveFlashcard(flashcard);
		System.out.println(flashcard);
		return "redirect:/";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("flashcardId") Long id, Model model) {
		Flashcard flashcard = flashcardService.getFlashcard(id);
		model.addAttribute("flashcard", flashcard);
		return "createFlashcard";
	}
	
	@GetMapping("/delete")
	public String deleteFlashcard(@RequestParam("flashcardId") Long id) {
		flashcardService.deleteFlashcard(id);
		return "redirect:/";
	}

}
