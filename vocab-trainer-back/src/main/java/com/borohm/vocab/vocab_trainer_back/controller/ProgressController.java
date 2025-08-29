package com.borohm.vocab.vocab_trainer_back.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.borohm.vocab.vocab_trainer_back.dto.ProgressRequest;
import com.borohm.vocab.vocab_trainer_back.model.Progress;
import com.borohm.vocab.vocab_trainer_back.repository.ProgressRepository;
import com.borohm.vocab.vocab_trainer_back.service.ProgressService;

@RestController
@CrossOrigin
@RequestMapping("/progress")
public class ProgressController {
  
  private final ProgressRepository progressRepository;
  private final ProgressService progressService;

  public ProgressController(ProgressRepository progressRepository, ProgressService progressService) {
    this.progressRepository = progressRepository;
    this.progressService = progressService;
  }

  @GetMapping
  public List<Progress> getProgress(@RequestParam Long userId) {
    return progressRepository.findByUserId(userId);
  }

  @PostMapping
  public Progress createOrUpdateProgress(@RequestBody ProgressRequest progressRequest) {
    return progressRepository.save(progressService.createOrUpdateProgress(progressRequest));
  }
}
