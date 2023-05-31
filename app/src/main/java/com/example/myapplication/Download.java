package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Download extends AppCompatActivity {
    Timer timer;
    TimerTask timerTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download);
        timer= new Timer();
        timerTask = new MyTimerTask();
        timer.schedule(timerTask, 5000);
    }
    class MyTimerTask extends TimerTask{
        @Override
        public void run(){
            //Intent intent = new Intent(Download.this, End.class);
            //startActivity(intent);
        }
    }
}