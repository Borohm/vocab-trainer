package com.borohm.vocab.vocab_trainer_back.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ProgressKey implements Serializable {
  @Column(name = "user_id")
  private Long userId;

  @Column(name = "word_id")
  private Long wordId;
}
