package xyz.dannyc.test1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class TorahTextView extends Activity {

    //private ScaleGestureDetector scaleGestureDetector;
    private VerseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        addVerses();
        Button nextChapter = (Button) findViewById(R.id.nextChapter);
        nextChapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.nextChapter();
            }
        });
        Button previousChapter = (Button) findViewById(R.id.previousChapter);
        previousChapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.previousChapter();
            }
        });
        Button fontSmaller = (Button) findViewById(R.id.fontSmaller);
        fontSmaller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.decreaseTextSize();
            }
        });
        Button fontBigger = (Button) findViewById(R.id.fontBigger);
        fontBigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.increaseTextSize();
            }
        });
        /*
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleGestureDetector.SimpleOnScaleGestureListener(){
            @Override
            public void onScaleEnd(ScaleGestureDetector detector) {
                //detector.getScaleFactor();
                Log.d("TorahTextView", "zoom ongoing, scale: " + detector.getScaleFactor());
            }
        });
        */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_text_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<String> getVerses(){
        ArrayList<String> verses = new ArrayList<String>();
        verses.add("בראשית ברא אלהים את השמים ואת הארץ");
        verses.add("והארץ היתה תהו ובהו וחשך על־פני תהום ורוח אלהים מרחפת על־פני המים");
        verses.add("ויאמר אלהים יהי אור ויהי־אור");
        verses.add("וירא אלהים את־האור כי־טוב ויבדל אלהים בין האור ובין החשך");
        verses.add("ויקרא אלהים לאור יום ולחשך קרא לילה ויהי־ערב ויהי־בקר יום אחד");
        verses.add("ויאמר אלהים יהי רקיע בתוך המים ויהי מבדיל בין מים למים");
        return verses;
    }

    private void addVerses(){
        ListView list = (ListView) findViewById(R.id.listView);
        adapter = new VerseAdapter(this);
        list.setAdapter(adapter);
        verseClicked(list);
    }

    private void verseClicked(ListView list){
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Toast.makeText(getApplicationContext(),"Click ListItem Number " + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //scaleGestureDetector.onTouchEvent(event);
        return true;
    }
}