package pl.dusinski;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.lang.Math;

public class dictTable {

    private List<dictEntity> dictList = new ArrayList<>();
    private int randomDictEntityNumber;
    private dictEntity randomDictEntity = new dictEntity(null, null, 0);
    private List<String> mixingWordList = new ArrayList<>();


    public dictTable() {

    }

    public void addTranslation(String polishWord, String englishWord) {

        this.dictList.add(new dictEntity(polishWord, englishWord, this.dictList.size()));

//        System.out.println(this.getTranslation(this.dictList.size()));
    }

//    public String getTranslation(int entityId) {
//        return this.dictList.get(--entityId).printDictEntity();
//    }

    private String drawLots() {
        String tempWord = this.mixingWordList.get(0);
        while (this.mixingWordList.contains(tempWord)) {
            int randomInt = (int) (Math.random() * this.dictList.size());
            tempWord = this.dictList.get(randomInt).returnEnglishWord();
//            System.out.println(tempWord + "\n");
        }
//          this.mixingWordList.add(tempWord);
        return tempWord;
    }

    public String generateQuestion() {
        String question;

        this.randomDictEntityNumber = (int) (Math.random() * this.dictList.size());
        this.randomDictEntity = this.dictList.get(this.randomDictEntityNumber);


        this.mixingWordList.clear();
        this.mixingWordList.add(this.randomDictEntity.returnEnglishWord());

        this.mixingWordList.add(drawLots());
        this.mixingWordList.add(drawLots());

        Collections.shuffle(this.mixingWordList);

        question = "English version of: " + this.randomDictEntity.returnPolishWord() + "\n"
                + " is: (1) " + this.mixingWordList.get(0) + "\n"
                + " or: (2) " + this.mixingWordList.get(1) + "\n"
                + " or: (3) " + this.mixingWordList.get(2);

        return question;
    }


    public boolean checkAnswer(int choiceNumber) {
        if (this.mixingWordList.get(--choiceNumber).equals(this.randomDictEntity.returnEnglishWord())) {
            return true;
        } else {
            return false;
        }
    }

    public String getTranslation(int choiceNumber) {

//        check how to use two keys map??

        return this.dictList.get()
    }


}


