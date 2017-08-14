package code_clan.spellinggame;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by R.Murzakov on 14/08/2017.
 */

public class TestGame {
    Game game;

    @Before
    public void beore() {
        game = new Game("home", "Home");
    }

    @Test
    public void testWords(){
        assertEquals("home", game.getUserInput());
        assertEquals("Home", game.getRandomWord());
    }

    @Test
    public void testGame(){
        assertEquals("Well done!",game.game());
    }
}
