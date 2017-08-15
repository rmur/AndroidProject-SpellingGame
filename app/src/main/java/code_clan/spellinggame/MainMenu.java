package code_clan.spellinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    Button goToGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        goToGame = (Button)findViewById(R.id.toGame_button);

        goToGame.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View view){
                goPlay();
            }
        });
    }

    public void goPlay(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
