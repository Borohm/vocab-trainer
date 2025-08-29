export enum WordType {
  NOM,
  VERBE_GODAN,
  VERBE_ICHIDAN,
  VERBE_IRREGULIER,
  ADJECTIF_I,
  ADJECTIF_NA,
  ADVERBE,
  PARTICULE,
  EXPRESSION,
  PRONOM,
  CONJONCTION
}

export const WordTypeLabels: Record<string, string> = {
  NOM: "Nom",
  VERBE_GODAN: "Verbe godan",
  VERBE_ICHIDAN: "Verbe ichidan",
  VERBE_IRREGULIER: "Verbe irrégulier",
  ADJECTIF_I: "Adjectif い",
  ADJECTIF_NA: "Adjectif な",
  ADVERBE: "Adverbe",
  PARTICULE: "Particule",
  EXPRESSION: "Expression",
  PRONOM: "Pronom",
  CONJONCTION: "Conjonction"
};