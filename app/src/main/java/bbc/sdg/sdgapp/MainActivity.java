package bbc.sdg.sdgapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);










        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);;
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowTitleEnabled(true);




/*

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(MainActivity.this,ActivityShowMainServices.class));
            }
        });



*/






        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        openFragment(new HomeFragment());



        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.home:
                        openFragment(new HomeFragment());
                        return true;

                    case R.id.news:
                        openFragment(new NewsFragment());
                        return true;

                    case R.id.events:
                      //  openFragment(new CalendarFragment());
                        startActivity(new Intent(MainActivity.this,ExampleActivity.class));
                        return true;

                    case R.id.quiz:
                   //openFragment(new QuizFragment());
                        startActivity(new Intent(MainActivity.this,QuestionsActivity.class));
                        return true;

                       // fabicon in -> message section

                    case R.id.share:


                     startActivity(new Intent(MainActivity.this,DetailsActivity.class));
                     //   startshare();
                        return true;

                }


                return false;
            }
        });

    }

    private void startshare() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "https://www.facebook.com/BeyondBeijingCommittee");
        startActivity(Intent.createChooser(intent, "Share"));
    }

    void openFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            //Back button
            case android.R.id.home:
                //If this activity started from other activity
                finish();

            /*If you wish to open new activity and close this one
            startNewActivity();
            */
                return true;
            case R.id.sendmail:
                //addfav (heart icon) was clicked, Insert your after click code here.
              sendEmail();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    protected void sendEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","info@beyondbeijing.org", null));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Query");
        intent.putExtra(Intent.EXTRA_TEXT, "my message here");
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
    }
    //https://data-flair.training/blogs/send-email-from-android/
}
