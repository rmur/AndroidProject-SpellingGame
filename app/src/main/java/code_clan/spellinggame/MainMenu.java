package code_clan.spellinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    Button goToGame;
    Button seeSummary;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        goToGame = (Button)findViewById(R.id.toGame_button);
        seeSummary =(Button)findViewById(R.id.summary_button);
        description = (TextView)findViewById(R.id.description_view);

        description.setText(" Hello and welcome to the \n Spelling game!");


        goToGame.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View view){
                goPlay();
            }
        });

        seeSummary.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
                goSummary();
            }
        });
    }

    public void goPlay(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void goSummary(){
        Intent intent = new Intent(this, SummaryActivity.class);
        startActivity(intent);
    }
}
