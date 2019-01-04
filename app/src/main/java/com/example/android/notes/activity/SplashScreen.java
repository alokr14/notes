package com.example.android.notes.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.notes.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splashscreen);
            new Timer().schedule(new TimerTask(){
                public void run() {
                    startActivity(new Intent(SplashScreen.this, SignupActivity.class));
                }
            }, 2000);
        }
    }
