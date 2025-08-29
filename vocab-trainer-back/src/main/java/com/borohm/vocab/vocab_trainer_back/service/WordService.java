package com.borohm.vocab.vocab_trainer_back.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.borohm.vocab.vocab_trainer_back.model.Word;
import com.borohm.vocab.vocab_trainer_back.repository.WordRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WordService {
  private final WordRepository wordRepository;
  private final ObjectMapper objectMapper;

  public WordService(WordRepository wordRepository) {
    this.wordRepository = wordRepository;
    this.objectMapper = new ObjectMapper();
  }

  public void importWords() throws IOException {
    InputStream is = getClass().getClassLoader().getResourceAsStream("words.json");
    if (is == null) throw new FileNotFoundException("words.json introuvable");

    List<Word> words = Arrays.asList(objectMapper.readValue(is, Word[].class));
    for (Word word : words) {
      if (wordRepository.existsByKanaAndKanji(word.getKana(), word.getKanji())) {
        Word existingWord = wordRepository.findByKanaAndKanji(word.getKana(), word.getKanji());
        existingWord.setTranslation(word.getTranslation());
        existingWord.setExample(word.getExample());
        existingWord.setExampleTranslation(word.getExampleTranslation());
        existingWord.setType(word.getType());
        existingWord.setLevel(word.getLevel());
        wordRepository.save(existingWord);
      } else {
        wordRepository.save(word);
      }
    }
  }
}
