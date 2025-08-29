package com.borohm.vocab.vocab_trainer_back.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.borohm.vocab.vocab_trainer_back.model.Word;
import com.borohm.vocab.vocab_trainer_back.repository.WordRepository;
import com.borohm.vocab.vocab_trainer_back.service.WordService;

@RestController
@CrossOrigin
@RequestMapping("/word")
public class WordController {
  
  private final WordRepository wordRepository;
  private final WordService wordService;

  public WordController(WordRepository wordRepository, WordService wordService) {
    this.wordRepository = wordRepository;
    this.wordService = wordService;
  }
  
  @PostMapping
  public Word createWord(@RequestBody Word word) {
    return wordRepository.save(word);
  }

  @GetMapping
  public List<Word> getAllWords() {
    return wordRepository.findAll();
  }

  @GetMapping("/import")
  public void importWords() throws Exception {
    wordService.importWords();
  }
}
