package com.borohm.vocab.vocab_trainer_back.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "word")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Word {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "kana")
  private String kana;

  @Column(name = "kanji")
  private String kanji;

  @Column(name = "translation")
  private String translation;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private WordType type;

  @Column(name = "level")
  private String level;

  @JsonIgnore
  @OneToMany(mappedBy = "word")
  private List<Progress> progress;
}
