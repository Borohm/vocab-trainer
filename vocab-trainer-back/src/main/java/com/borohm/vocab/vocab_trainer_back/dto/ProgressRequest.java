package com.borohm.vocab.vocab_trainer_back.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProgressRequest {
  private long userId;
  private long wordId;
  private boolean correct;
}
