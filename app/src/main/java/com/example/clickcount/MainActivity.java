package com.example.clickcount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mTextViewCount,textView1;
    private int btncount,bckgrndcnt;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textView);
        mTextViewCount = findViewById(R.id.textView2);
        button=findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btncount++;
                mTextViewCount.setText(String.valueOf(btncount));
            }
        });
        if (savedInstanceState != null) {
            btncount = savedInstanceState.getInt("count");
            bckgrndcnt = savedInstanceState.getInt("count2");
            mTextViewCount.setText(String.valueOf(btncount));
            textView1.setText(String.valueOf(bckgrndcnt));
        }
    }


    public void onPause()
    {
        super.onPause();
        // app moved to background
        bckgrndcnt++;
        textView1.setText(String.valueOf(bckgrndcnt));
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", btncount);
        outState.putInt("count2", bckgrndcnt);
    }


}