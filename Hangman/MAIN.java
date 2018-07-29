import java.util.Scanner;

public class MAIN {
    public static final int NUM_TRIES = 5;
    public static void main(String[] args) {

        //Creates the object for user input
        Scanner keyboard = new Scanner(System.in);

        //Starts the overall game
        char ch=' ';
        boolean quit = false;
        String sGuess = "";
        System.out.println("Let’s play a round of hangman.\nWe are playing hangman");
        while(quit == false)
        {
            Hangman sWord = new Hangman();
            System.out.println("Tips:The Secure Word is <"+sWord.getSecretWord()+">");  //Comments on formal occasions
            System.out.println("The disguised words is <"+sWord.getHintWord()+">");
            while(quit == false){
                System.out.println("Guess a letter:");

                do{
                     ch= keyboard.nextLine().charAt(0);
                }while(ch<97||ch>122);              //Avoid illegal input,can add more cases
                sWord.setCntALL(sWord.getCntALL()+1);
                sWord.makeGuess(ch);
                System.out.println(sWord.getHintWord());
                if (sWord.isFound(ch)){
                    System.out.println("Correct. Guesses made "+sWord.getCntALL()+" with "+sWord.getCntFalse()+" wrong");
                }else{
                    sWord.setCntFalse(sWord.getCntFalse()+1);
                    System.out.println("Incorrect. Guesses made "+sWord.getCntALL()+" with "+sWord.getCntFalse()+" wrong");
                }

                if(sWord.getHintWord().equals(sWord.getSecretWord()))
                {
                    System.out.println("Congratulations, you found the secret word: "+sWord.getSecretWord());
                    System.out.println("Game over! Would you like to try again?(yes/no)");
                    String input = keyboard.nextLine();
                    if(input.equalsIgnoreCase("no"))
                    {
                        quit = true;
                    }
                    else
                    {
                        System.out.println("***************************************************\n" +
                                "Let’s play a "+sWord.getNumberOfTurns()+" round of hangman.");
                        sWord.setNumberOfTurns(sWord.getNumberOfTurns()+1);
                        break;
                    }
                }
            }
            //Prompts the user to play again

        }
        System.out.println("EXIT,BYE!");
    }

}
