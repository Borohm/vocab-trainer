package com.borohm.vocab.vocab_trainer_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.borohm.vocab.vocab_trainer_back.model.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
  public boolean existsByKanaAndKanji(String kana, String kanji);
  public Word findByKanaAndKanji(String kana, String kanji);
}
