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

import java.util.ArrayList;
import java.util.concurrent.RunnableFuture;

public class GameActivity extends AppCompatActivity {
    Button gamebButton;
    Button returnButton;
    Button hintButton;

    TextView randomWord;
    TextView counterCorrect;
    TextView counterIncorrect;

    EditText typedWord;

    WordsCollection wordsCollection;

    ArrayList<String>arrayOfWords;
    String typeRandomWord;
    int countCorrect;
    int countIncorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gamebButton = (Button)findViewById(R.id.toGame_button);
        returnButton = (Button)findViewById(R.id.return_button);
        hintButton = (Button)findViewById(R.id.hint_button);

        typedWord = (EditText)findViewById(R.id.typed_word);

        randomWord = (TextView)findViewById(R.id.random_word);
        counterIncorrect=(TextView)findViewById(R.id.counter_incorrect);
        counterCorrect = (TextView)findViewById(R.id.counter_correct);

        wordsCollection = new WordsCollection();

        this.typeRandomWord = wordsCollection.randomWord();
        randomWord.setText(this.typeRandomWord);

        showViewDelayed(randomWord, 3000);
        counterCorrect.setText("Correctly spelled words: 0");
        counterIncorrect.setText("Incorrectly Spelled words: 0");

        returnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                returnToMainMenu();
            }
        });


    }
    //Hide word
    public void showViewDelayed(View view, int time){
        final View delayedView = view;
        view.postDelayed(new Runnable() {
            public void run(){
                delayedView.setVisibility(View.INVISIBLE);
            }
        },time);
    }
    //Show word
    public void showView(View view,int visibility){
        final View delayedView = view;
        view.postDelayed(new Runnable() {
            public void run(){
                delayedView.setVisibility(View.VISIBLE);
            }
        },visibility);
    }
    //MainMenu
    public void returnToMainMenu(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
    //Game
    public void onButtonCLickCompare(View view) {
        String word = typedWord.getText().toString();


        Game newGame = new Game(word, this.typeRandomWord);
        String result = newGame.checkOfInput();
        if (result.equals("Well done!")) {
            showView(randomWord, 100);
            wordsCollection.listOfWords.remove(this.typeRandomWord);
            this.typeRandomWord = wordsCollection.randomWord();
            randomWord.setText(this.typeRandomWord);
            showViewDelayed(randomWord, 3000);
            typedWord.setText("");
            countCorrect ++;
        }
        else {countIncorrect ++;}

        counterCorrect.setText("Correctly spelled words: " + Integer.toString(countCorrect)+ "\n");
        counterIncorrect.setText("Incorrectly Spelled words: " + Integer.toString(countIncorrect));
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
    //Hint
    public void onButtonClickhint(View view){
        showView(randomWord, 100);
        showViewDelayed(randomWord, 1000);

    }

}
