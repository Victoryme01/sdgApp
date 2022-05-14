package bbc.sdg.sdgapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.qap.ctimelineview.TimelineRow;
import org.qap.ctimelineview.TimelineViewAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExampleActivity extends AppCompatActivity {
    List<String> titleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        ListView myListView = (ListView) findViewById(R.id.timeline_listView);

        // Create Timeline rows List
        ArrayList<TimelineRow> timelineRowsList = new ArrayList<>();

// Create new timeline row (Row Id)
        TimelineRow myRow = new TimelineRow(0);
titleList=new ArrayList<>();
        titleList.add("Event 2");
        titleList.add("Event 3");
        titleList.add("Event 4");
        titleList.add("Event 5");
        titleList.add("Event 6");
        titleList.add("Event 7");
        titleList.add("Event 8");
        titleList.add("Inaguration of app launching event by BBC Nepal");

// To set the row Title (optional) // quapp library


        for (int i = 0; i < 8; i++) {


        myRow.setTitle(titleList.get(i).toString());
        myRow.setDescription("25th feb 2022");
        myRow.setImage(BitmapFactory.decodeResource(getResources(), R.drawable.inagurationlogo));
        myRow.setBellowLineColor(Color.argb(255, 0, 0, 0));
        myRow.setBellowLineSize(6);
        myRow.setImageSize(40);

        myRow.setTitleColor(Color.argb(255, 0, 0, 0));
        myRow.setDescriptionColor(Color.argb(255, 0, 0, 0));
        timelineRowsList.add(myRow);


// Create the Timeline Adapter
        ArrayAdapter<TimelineRow> myAdapter = new TimelineViewAdapter(this, 0, timelineRowsList,
                //if true, list will be sorted by date
                false);

// Get the ListView and Bind it with the Timeline Adapter
         myListView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
}
}