package pl.dusinski;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.lang.Math;

public class dictTable {

    private List<dictEntity> dictList = new ArrayList<>();
    private int randomDictEntityNumber;
    private dictEntity randomDictEntity = new dictEntity(null, null, 0);
    private List<dictEntity> mixingDictEntityList = new ArrayList<>();


    public dictTable() {

    }

    public void addTranslation(String polishWord, String englishWord) {

        this.dictList.add(new dictEntity(polishWord, englishWord, this.dictList.size()));

//        System.out.println(this.getTranslation(this.dictList.size()));
    }

//    public String getTranslation(int entityId) {
//        return this.dictList.get(--entityId).printDictEntity();
//    }

    private dictEntity drawLots() {
        dictEntity tempDictEntity = this.mixingDictEntityList.get(0);
        while (this.mixingDictEntityList.contains(tempDictEntity)) {
            int randomInt = (int) (Math.random() * this.dictList.size());
            tempDictEntity = this.dictList.get(randomInt);
//            System.out.println(tempWord + "\n");
        }
//          this.mixingWordList.add(tempWord);
        return tempDictEntity;
    }

    public String generateQuestion() {
        String question;

        this.randomDictEntityNumber = (int) (Math.random() * this.dictList.size());
        this.randomDictEntity = this.dictList.get(this.randomDictEntityNumber);


        this.mixingDictEntityList.clear();
        this.mixingDictEntityList.add(this.randomDictEntity);

        this.mixingDictEntityList.add(drawLots());
        this.mixingDictEntityList.add(drawLots());

        Collections.shuffle(this.mixingDictEntityList);

        question = "English version of: " + this.randomDictEntity.returnPolishWord() + "\n"
                + " is: (1) " + this.mixingDictEntityList.get(0).returnEnglishWord() + "\n"
                + " or: (2) " + this.mixingDictEntityList.get(1).returnEnglishWord() + "\n"
                + " or: (3) " + this.mixingDictEntityList.get(2).returnEnglishWord();

        return question;
    }


    public boolean checkAnswer(int choiceNumber) {
        if (this.mixingDictEntityList.get(--choiceNumber).equals(this.randomDictEntity)) {
            return true;
        } else {
            return false;
        }
    }

    public String getQuestionWord(int choiceNumber){

        return this.mixingDictEntityList.get(--choiceNumber).returnEnglishWord();
    }



    public String getQuestionTranslation(int choiceNumber) {

        return this.mixingDictEntityList.get(--choiceNumber).returnPolishWord();
    }


}


