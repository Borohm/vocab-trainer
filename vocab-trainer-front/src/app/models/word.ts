import { WordType } from "./wordType";

export class Word {
  id: number;
  kana: string;
  kanji: string;
  translation: string;
  example: string;
  exampleTranslation: string;
  type: WordType;
  level: string;

  constructor(id: number, kana: string, kanji: string, translation: string, example: string, exampleTranslation: string, type: WordType, level: string) {
    this.id = id;
    this.kana = kana;
    this.kanji = kanji;
    this.translation = translation;
    this.example = example;
    this.exampleTranslation = exampleTranslation;
    this.type = type;
    this.level = level;
  }
}