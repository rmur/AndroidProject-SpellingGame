package code_clan.spellinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary_list);

        WordsCollection wordsCollection = new WordsCollection();
        ArrayList<String> list = wordsCollection.getList();

        WordsCollectionAdapter wordsCollectionAdapter = new WordsCollectionAdapter(this, list);

        ListView listView = (ListView) findViewById(R.id.summary_list);
        listView.setAdapter(wordsCollectionAdapter);
    }
}
