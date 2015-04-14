package xyz.dannyc.test1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by daniel on 12-Apr-15.
 */
public class VerseAdapter extends ArrayAdapter<String>{

    private List<String> verses;
    private Context context;
    public VerseAdapter(Context context, List<String> verses) {
        super(context, R.layout.pasuk, verses);
        this.context = context;
        this.verses = verses;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View pasukView = inflater.inflate(R.layout.pasuk, parent, false);
        TextView verseNum = (TextView) pasukView.findViewById(R.id.verseNum);
        verseNum.setText(String.valueOf(position));
        TextView verseText = (TextView) pasukView.findViewById(R.id.verseText);
        verseText.setText(verses.get(position));
        return pasukView;
    }

}
