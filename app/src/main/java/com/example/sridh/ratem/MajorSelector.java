package com.example.sridh.ratem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MajorSelector extends AppCompatActivity {

    private final String TAG = "major selector";
    private String userName ;
    private String schoolName;
    private String major;

    private TextView nameTxt;
    private Spinner schoolSpin;
    private Spinner majorSpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major_selector);

        // Get user info(username, email, friends)from facebook login

        Intent intent = getIntent();
        if(intent.getStringExtra("userName") == null)
            userName = "Cool name here bro";
        else
        userName = intent.getStringExtra("userName");

        // "Welcome, userName"
        nameTxt = (TextView) findViewById(R.id.userName);
        nameTxt.setText(userName);

        // School name drop down
        schoolSpin = (Spinner) findViewById(R.id.schoolNameList);
        String[] categories = new String[]{"San Jose State University"};
        ArrayAdapter<String> myAdapt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,categories);
        myAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolSpin.setAdapter(myAdapt);

       // catching the selected item -> String
        schoolSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                schoolName = item.toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //major
        majorSpin = (Spinner) findViewById(R.id.majorList);
        categories = new String[]{"Computer Science","Maths","Software Engineering"};
        myAdapt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,categories);
        myAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        majorSpin.setAdapter(myAdapt);


        // catching the selected item -> String
        majorSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object item = parent.getItemAtPosition(pos);
                major = item.toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }


    public void goToNext(View view) {
        // send the info + school + major to database
        Toast.makeText(this, major, Toast.LENGTH_SHORT).show();
        Log.d(TAG,"Connection complete");
        Intent intMe = new Intent(this,);
        startActivity(intMe);
    }
}
