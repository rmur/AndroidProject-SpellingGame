package code_clan.spellinggame;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by R.Murzakov on 14/08/2017.
 */

public class TestWordsCollection {
    WordsCollection listOfWords;

    @Before
    public void before(){
        listOfWords = new WordsCollection();
        }

    @Test
    public void TestReturnofTHeWord(){
        assertEquals("Helicopter",listOfWords.getList().get(0));
    }

    @Test
    public void TestReturnRandomWord(){

        assertNotNull(listOfWords.randomWord());
    }



}
