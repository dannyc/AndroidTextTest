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

    private int textSize = 14;
    private static Integer currentChapter = 1;
    private Context context;
    private static VerseDB verseDB = new VerseDB();
    private static List<String> verses = verseDB.getChapter(currentChapter);

    public VerseAdapter(Context context) {
        super(context, R.layout.pasuk, verses);
        this.context = context;
        //this.verses = verseDB.getChapter(currentChapter);
    }

    public void nextChapter(){
        if(currentChapter < VerseDB.MAX){
            currentChapter += 1;
            updateVerses();
        }
    }
    public void previousChapter(){
        if(currentChapter > 1){
            currentChapter -= 1;
            updateVerses();
        }
    }


    public void increaseTextSize(){
        this.textSize += 2;
        notifyDataSetChanged();
    }

    public void decreaseTextSize(){
        if(textSize > 6) { //don't go too small
            this.textSize -= 2;
            notifyDataSetChanged();
        }
    }
    public void updateVerses(){
        this.verses = verseDB.getChapter(currentChapter);
        notifyDataSetChanged();
    }

    public int getCurrentChapter(){
        return currentChapter;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View pasukView = inflater.inflate(R.layout.pasuk, parent, false);
        TextView verseNum = (TextView) pasukView.findViewById(R.id.verseNum);
        verseNum.setText(String.valueOf(position + 1));
        TextView verseText = (TextView) pasukView.findViewById(R.id.verseText);
        verseText.setText(verses.get(position));
        verseText.setTextSize(textSize);
        return pasukView;
    }

}
