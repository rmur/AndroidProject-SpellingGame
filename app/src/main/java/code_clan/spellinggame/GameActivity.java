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
    EditText typedWord;
    WordsCollection listOfWords;
    String typeRandomWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.typeRandomWord = typeRandomWord;

        gamebButton = (Button)findViewById(R.id.game_button);
        randomWord = (TextView)findViewById(R.id.random_word);
        typedWord = (EditText)findViewById(R.id.typed_word);

        listOfWords = new WordsCollection();
        this.typeRandomWord = listOfWords.randomWord();
        randomWord.setText(this.typeRandomWord);
    }

    public void onButtonCLickCompare(View view){
        String word = typedWord.getText().toString();
        Log.d("Word : ", word);

        Game newGame = new Game(word,this.typeRandomWord);
        String result = newGame.game();
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

}
