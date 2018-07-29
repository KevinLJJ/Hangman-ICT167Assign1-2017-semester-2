import java.util.Random;

class Hangman {

    private static int WORDS_LENGTH = 5;  //change the word length
    private String SecretWord;
    private String hintWord;
    private int numberOfTurns=1;   //Game Turns
    private int cntALL=0;       //Guess count
    private int cntFalse=0;     //False Count

    public Hangman() {
        setSecretWord();
        setDisguisedWord();
    }
    public boolean isFound(char ch){
        int result=SecretWord.indexOf(ch);
        return result!=-1?true:false;
    }

    public void makeGuess(char ch) {
        int index;
        int start = 0;
        isFound(ch);
        StringBuilder str=new StringBuilder(hintWord);
        String charStrTemp=""+ch;
        do {
            index = SecretWord.indexOf(ch, start);
            if(index != -1) {
                str.replace(index,index+1,charStrTemp);   //replace ? with correctly character.
                start = index+1;
            }
        } while(index >= 0);   //Multiple matching characters
        hintWord = new String(str);
    }

    public String getSecretWord() {
        return SecretWord;
    }

    private void setSecretWord() {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random();
        SecretWord = "";
        for(int i = 0; i < WORDS_LENGTH; i++)
            SecretWord += alphabets.charAt(rand.nextInt(rand.nextInt(26)));
    }
    public String getHintWord() {
        return hintWord;
    }

    private void setDisguisedWord() {
        if(SecretWord != null && !"".equals(SecretWord.trim())) {
            hintWord = "";
            for(int i = 0; i < SecretWord.length(); i++)
                hintWord += "?";
        }
    }
    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public int getCntALL() {
        return cntALL;
    }

    public int getCntFalse() {
        return cntFalse;
    }

    public void setCntALL(int cntALL) {
        this.cntALL = cntALL;
    }

    public void setCntFalse(int cntFalse) {
        this.cntFalse = cntFalse;
    }
    public void StudentInfo(){
        //Personal Code
    }
}