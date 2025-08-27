package com.borohm.vocab.vocab_trainer_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.borohm.vocab.vocab_trainer_back.model.Progress;
import com.borohm.vocab.vocab_trainer_back.model.ProgressKey;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, ProgressKey> {
  public List<Progress> findByUserId(Long userId);
}