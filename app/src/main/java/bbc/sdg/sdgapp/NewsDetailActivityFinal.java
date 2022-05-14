package bbc.sdg.sdgapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsDetailActivityFinal extends AppCompatActivity {

ImageView cardView;
String value;
TextView newsDetail,newsTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_news_detail);
        cardView = findViewById(R.id.roundedImageView);
        newsDetail = findViewById(R.id.newsDetail);
        newsTitle = findViewById(R.id.newsTitle);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            value = extras.getString("key");
            Log.d("hola",value);
            //The key argument here must match that used in the other activity
        }
        if (value.equals("fragment_g1.xml")) {
            setContentView(R.layout.fragment_news_detail);

            // return inflater.inflate(R.layout.fragment_g1_desc, container, false);
        }
        if (value.equals("fragment_g2.xml")) {
            setContentView(R.layout.fragment_news_detail2);
            // return inflater.inflate(R.layout.fragment_g1_desc, container, false);
        }
        if (value.equals("fragment_g3.xml")) {
            setContentView(R.layout.fragment_news_detail3);
            // return inflater.inflate(R.layout.fragment_g1_desc, container, false);
        }
    }
}
