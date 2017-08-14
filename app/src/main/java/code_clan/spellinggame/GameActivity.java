package code_clan.spellinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    Button gamebButton;
    TextView randomWord;
    TextView counterCorrect;
    TextView counterIncorrect;
    EditText typedWord;
    WordsCollection listOfWords;
    String typeRandomWord;
    int countCorrect;
    int countIncorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gamebButton = (Button)findViewById(R.id.game_button);
        randomWord = (TextView)findViewById(R.id.random_word);
        typedWord = (EditText)findViewById(R.id.typed_word);
        counterIncorrect=(TextView)findViewById(R.id.counter_incorrect);
        counterCorrect = (TextView)findViewById(R.id.counter_correct);

        listOfWords = new WordsCollection();
        this.typeRandomWord = listOfWords.randomWord();
        randomWord.setText(this.typeRandomWord);
        counterCorrect.setText("0");
        counterIncorrect.setText("0");


    }

    public void onButtonCLickCompare(View view) {
        String word = typedWord.getText().toString();
        Log.d("Word : ", word);



        Game newGame = new Game(word, this.typeRandomWord);
        String result = newGame.checkOfInput();
        if (result.equals("Well done!")) {
            this.typeRandomWord = listOfWords.randomWord();
            randomWord.setText(this.typeRandomWord);
            typedWord.setText("");
            countCorrect ++;

        }
        else {
            countIncorrect ++;

        }


        counterCorrect.setText(Integer.toString(countCorrect));
        counterIncorrect.setText(Integer.toString(countIncorrect));
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

}
