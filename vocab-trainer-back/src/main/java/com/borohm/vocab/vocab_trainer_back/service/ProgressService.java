package com.borohm.vocab.vocab_trainer_back.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.borohm.vocab.vocab_trainer_back.dto.ProgressRequest;
import com.borohm.vocab.vocab_trainer_back.model.Progress;
import com.borohm.vocab.vocab_trainer_back.model.ProgressKey;
import com.borohm.vocab.vocab_trainer_back.model.User;
import com.borohm.vocab.vocab_trainer_back.model.Word;
import com.borohm.vocab.vocab_trainer_back.repository.ProgressRepository;
import com.borohm.vocab.vocab_trainer_back.repository.UserRepository;
import com.borohm.vocab.vocab_trainer_back.repository.WordRepository;

@Service
public class ProgressService {

  private final ProgressRepository progressRepository;
  private final UserRepository userRepository;
  private final WordRepository wordRepository;
  
  public ProgressService(ProgressRepository progressRepository, UserRepository userRepository, WordRepository wordRepository) {
    this.progressRepository = progressRepository;
    this.userRepository = userRepository;
    this.wordRepository = wordRepository;
  }

  public Progress createOrUpdateProgress(ProgressRequest progressRequest) {
    User user = userRepository.findById(progressRequest.getUserId()).orElseThrow();
    Word word = wordRepository.findById(progressRequest.getWordId()).orElseThrow();
  
    ProgressKey progressKey = ProgressKey.builder().userId(user.getId()).wordId(word.getId()).build();
  
    Progress progress = progressRepository.findById(progressKey).orElse(
      Progress.builder()
        .id(progressKey)
        .user(user)
        .word(word)
        .timesSeen(0)
        .timesCorrect(0)
        .lastSeen(null)
        .nextReview(null)
        .build()
    );
    
    if (progressRequest.isCorrect()) progress.setTimesCorrect(progress.getTimesCorrect() + 1);
  
    progress.setTimesSeen(progress.getTimesSeen() + 1);
    progress.setLastSeen(LocalDateTime.now());
    progress.setNextReview(LocalDateTime.now().plusDays(1));

    return progress;
  }
}
