package code_clan.spellinggame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by R.Murzakov on 16/08/2017.
 */

public class WordsCollectionAdapter extends ArrayAdapter<String> {
    public WordsCollectionAdapter (Context context, ArrayList<String> words){
        super(context, 0 , words);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent){
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.summary_element, parent, false);
        }

        String currentWord = getItem(position);

        TextView word = (TextView)listItemView.findViewById(R.id.summary_item);
        word.setText(currentWord);
        return listItemView;
    }
}
