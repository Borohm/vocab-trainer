package com.borohm.vocab.vocab_trainer_back.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.borohm.vocab.vocab_trainer_back.model.Word;
import com.borohm.vocab.vocab_trainer_back.repository.WordRepository;

@RestController
@RequestMapping("/word")
public class WordController {
  
  private final WordRepository wordRepository;

  public WordController(WordRepository wordRepository) {
    this.wordRepository = wordRepository;
  }
  
  @PostMapping
  public Word createWord(@RequestBody Word word) {
    return wordRepository.save(word);
  }

  @GetMapping
  public List<Word> getAllWords() {
    return wordRepository.findAll();
  }
}
