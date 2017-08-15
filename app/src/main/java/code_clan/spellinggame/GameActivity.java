package code_clan.spellinggame;

import android.content.Intent;
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
    Button returnButton;

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

        gamebButton = (Button)findViewById(R.id.toGame_button);
        returnButton = (Button)findViewById(R.id.return_button);

        typedWord = (EditText)findViewById(R.id.typed_word);

        randomWord = (TextView)findViewById(R.id.random_word);
        counterIncorrect=(TextView)findViewById(R.id.counter_incorrect);
        counterCorrect = (TextView)findViewById(R.id.counter_correct);

        listOfWords = new WordsCollection();
        this.typeRandomWord = listOfWords.randomWord();
        randomWord.setText(this.typeRandomWord);
        counterCorrect.setText("Correctly spelled words: 0");
        counterIncorrect.setText("Incorrectly Spelled words: 0");

        returnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                returnToMainMenu();
            }
        });


    }

    public void returnToMainMenu(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
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


        counterCorrect.setText("Correctly spelled words: " + Integer.toString(countCorrect)+ "\n");
        counterIncorrect.setText("Incorrectly Spelled words: " + Integer.toString(countIncorrect));
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

}
