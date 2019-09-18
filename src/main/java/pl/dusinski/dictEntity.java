package pl.dusinski;



class dictEntity {

    private int entityId;
    private String polishWord;
    private String englishWord;

    public dictEntity(String englishWord, String polishWord, int entityCounter) {
        this.entityId = ++entityCounter;
        this.englishWord = englishWord;
        this.polishWord = polishWord;
//            System.out.println(this.entityId + " | " + this.polishWord + " | " + this.englishWord);
    }

    public String printDictEntity() {
        return this.entityId + " | " + this.polishWord + " | " + this.englishWord;
    }

    public String returnPolishWord(){
        return this.polishWord;
    }

    public String returnEnglishWord(){
        return this.englishWord;
    }
    public int returnId()
    {
        return this.entityId;
    }
}

