package de.obcc.obccemployees;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.content.Intent;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    CardView profile,newsObcc, myprojects, mypay, message, workinghours;
    //ScrollView scroller; //,scroller1, scroller2, scroller3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profile = (CardView) findViewById(R.id.myProfile_Card);
        newsObcc = (CardView) findViewById(R.id.obcc_News);
        myprojects = (CardView) findViewById(R.id.my_projects);
        mypay = (CardView) findViewById(R.id.mypay);
        message = (CardView) findViewById(R.id.messages);
        workinghours = (CardView) findViewById(R.id.working_hours);
        //scroller = (ScrollView) findViewById(R.id.scroller);

        //scroller.fullScroll(View.LAYOUT_DIRECTION_INHERIT);

        //scroller.smoothScrollTo(10,20);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profile_intent = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(profile_intent);
            }
        });

        newsObcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //goToUrl ("https://www.obcc.de");
                Uri uri = Uri.parse("http://www.obcc.de");
                Intent news_obcc = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(news_obcc);

            }
        });

        myprojects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_projects = new Intent(MainActivity.this, Projects.class);
                startActivity(intent_projects);
            }
        });

        mypay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_pay = new Intent(MainActivity.this, Pay_Section.class);
                startActivity(intent_pay);
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent message_intent = new Intent(MainActivity.this, Messages.class);
                startActivity(message_intent);
            }
        });

        workinghours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent working_hours_intent = new Intent(MainActivity.this, WorkingHours.class);
                startActivity(working_hours_intent);
            }
        });

    }
}
