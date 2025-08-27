package com.borohm.vocab.vocab_trainer_back.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "progress")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Progress {
  @EmbeddedId
  @JsonIgnore
  private ProgressKey id;

  @ManyToOne
  @MapsId("userId")
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @MapsId("wordId")
  @JoinColumn(name = "word_id")
  private Word word;

  @Column(name = "times_seen")
  private int timesSeen;

  @Column(name = "times_correct")
  private int timesCorrect;

  @Column(name = "last_seen")
  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime lastSeen;

  @Column(name = "next_review")
  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime nextReview;
}
