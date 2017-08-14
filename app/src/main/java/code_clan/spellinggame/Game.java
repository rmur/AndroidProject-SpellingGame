package code_clan.spellinggame;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by R.Murzakov on 14/08/2017.
 */

public class Game {
    private String userInput;
    private String randomWord;


    public Game(String userInput, String randomWord){
        this.userInput = userInput;
        this.randomWord = randomWord;
        }

    public String getUserInput() {
        return this.userInput;
    }

    public String getRandomWord(){
        return this.randomWord;
    }

    public String checkOfInput(){

            String userWord = this.userInput.toLowerCase();
            String randomWord = this.randomWord.toLowerCase();

            String result_correct = "Well done!";
            String result_false = "Try again!";
            if (userWord.equals(randomWord)) {
                return result_correct;
            } else {
                return result_false;

        }



    }

}
