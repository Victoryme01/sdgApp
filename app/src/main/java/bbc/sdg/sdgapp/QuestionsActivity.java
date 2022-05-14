package bbc.sdg.sdgapp;

import android.animation.ObjectAnimator;
import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kofigyan.stateprogressbar.StateProgressBar;

import java.util.Random;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    int progressStatusCounter = 0;
    TextView textView;
    Handler progressHandler = new Handler();
    TextView progress;
   // ProgressBar progressBar;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    String[] descriptionData = {"Details", "Status", "Photo", "Confirm"};
    String questions[] = {
            "test",
            "The SDGs has -- goals",
            "The SDGs main agenda is --",
            "The SDGs is focused on 3 dimensions they are",
            "The SDGs are the global action plan for",
            "The purpose of the SDGs is to",
            "The SDGs were agreed on",
            "The SDGs are",
            "Who should be involved for the SDGs to be met?",
            "Which are the obstacles to achieve the SDGs",
            "What qualities do people need to be the change makers for Sustainable Development?",
            "Which SDGs talks about the Gender Equality",
            "Which SDGs has the target and indicators on Sexual and Reproductive Health and Rights (SRHR) and talks about the international instruments on SRHR?",
            "How do countries review the status and assess the progress on SDGs at national level? ",
            "Every year, the member states present the SDGs status and progress via VNR report in"
    };
    String answers[] = {"test","17","Leave No One Behind","Social, Economic & Environmental","15","Help Human live peaceful and Sustainable life","2015","None of the mentioned","java","equals()","int","equals()","int","equals()","int"};
    String opt[] = {
            "8","10","17","18",
            "8","10","17","18",
            "Leave No One Behind","Reaching the furthest first","all of the above","None",
            "Social, Economic & political","Environmental, Economic & political","Social, Economic & Environmental","None",
            "5","10","15","30",
            "Create 17 goals","Help Human live peaceful and Sustainable life","Engage peoples, private sector and CSOs for the sustainable Development","None of the mentioned",
            "2012","2015","2030","Rio De Janeiro",
            "Indivisible to each other","Independent to each other","all of the above","None of the mentioned",
            "Individuals","Governments","All","Private Sector",
            "Inequality","Economic Growth","Sustainability","Ecological problems",
            "Knowledge on SDGs","Skills on SDGs","Attitude and values that support the SDGs agenda","All",

            "Goal 1","Goal 3","5","Goal 17",

            "Goal 4 & 5","Goal 3 , 4 & 6","Goal 3 and 5","Goal 3,4 & 5",

            "Voluntary National Review (VNR)","Voluntary National Service ( VNS)","None","All",

            "High Level Platform Forum (HLPF)","High Level Political Forum (HLPF)","High Level Politics Forum (HLPF)","All",







    };
    int flag=1;
    int secondflag=1;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        progress=findViewById(R.id.progress);

        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");
/*
        if (name.trim().equals(""))
            textView.setText("Hello User");
        else
            textView.setText("Hello " + name);
*/
        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);


        Random r = new Random();
        int lowerBound = 1;
        int upperBound = 15;
        int result = r.nextInt(upperBound-lowerBound) + lowerBound;






//flag= (int) (Math.random() * (14 - 1 + 1) + 1); // 1 min is inclusiove and 16 is exclusive

       // if(flag<questions.length)
       tv.setText(questions[result]);
        rb1.setText(opt[flag*4]);
        rb2.setText(opt[flag*4 +1]);
        rb3.setText(opt[flag*4 +2]);
        rb4.setText(opt[flag*4 +3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;
                secondflag++;
                if (score != null)
                    score.setText(""+correct);

                if(secondflag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
              // progress.setText(Integer.toString(flag));

//progressBar.setProgress(flag);
progress.setText(Integer.toString(secondflag) + "/" +"14");















































            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}