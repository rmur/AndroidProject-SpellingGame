package code_clan.spellinggame;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by R.Murzakov on 14/08/2017.
 */

public class WordsCollection {
    Random randomGenerator;
    ArrayList<String> listOfWords;

    public WordsCollection(){
        listOfWords = new ArrayList<String>();
        listOfWords.add("convalesce");
        listOfWords.add("embarrass");
        listOfWords.add("conscience");
        listOfWords.add("handkerchief");
    }

    public ArrayList<String> getList(){
        return new ArrayList<String>(listOfWords);
    }

    public String randomWord(){
        new ArrayList<String>(listOfWords);
        randomGenerator = new Random();
        int index = randomGenerator.nextInt(listOfWords.size());
        String word = listOfWords.get(index);
        return word;
    }


}
