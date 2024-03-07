package com.project.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.project.entity.Flashcard;
import com.project.service.FlashcardService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class MvcRestControllerTests {

    @InjectMocks
    private MvcRestController mvcRestController;

    @Mock
    private FlashcardService flashcardService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(mvcRestController).build();
    }

    @Test
    public void testCreateFlashcard() throws Exception {
        Flashcard flashcard = new Flashcard("What is the capital of France?", "Paris");

        // Perform the POST request to create a flashcard
        mockMvc.perform(post("/api/flashcards/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"question\": \"What is the capital of France?\", \"answer\": \"Paris\" }"))
                .andExpect(status().isCreated());

        // Verify that the saveFlashcard method is called with the correct arguments
        verify(flashcardService, times(1)).saveFlashcard("What is the capital of France?", "Paris");
    }
}

