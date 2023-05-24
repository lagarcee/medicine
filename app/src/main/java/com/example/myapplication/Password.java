package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Password extends Activity {
    int i = 0;
    String value = "";
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password);
        textView = findViewById(R.id.resume);
        Button button1 = findViewById(R.id.btn1);
        Button button2 = findViewById(R.id.btn2);
        Button button3 = findViewById(R.id.btn3);
        Button button4 = findViewById(R.id.btn4);
        Button button5 = findViewById(R.id.btn5);
        Button button6 = findViewById(R.id.btn6);
        Button button7 = findViewById(R.id.btn7);
        Button button8 = findViewById(R.id.btn8);
        Button button9 = findViewById(R.id.btn9);
        Button button0 = findViewById(R.id.btn0);
        imageView = findViewById(R.id.check);
        ImageButton imageButton = findViewById(R.id.del);
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn1:
                value = value + "1";
                break;
            case R.id.btn2:
                value = value + "2";
                break;
            case R.id.btn3:
                value = value + "3";
                break;
            case R.id.btn4:
                value = value + "4";
                break;
            case R.id.btn5:
                value = value + "5";
                break;
            case R.id.btn6:
                value = value + "6";
                break;
            case R.id.btn7:
                value = value + "7";
                break;
            case R.id.btn8:
                value = value + "8";
                break;
            case R.id.btn9:
                value = value + "9";
                break;
            case R.id.btn0:
                value = value + "10";
                break;

        }
        i++;


        switch (i) {
            case 1:
                imageView.setImageResource(R.drawable.progress1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.progress2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.progress3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.progress4);
                break;

        }
        if (i == 4) {
            Intent intent = new Intent(this, Medcard.class);
            startActivity(intent);
        }


    }
    public void onClick1(View v) {
        Intent intent = new Intent(this, Medcard.class);
        startActivity(intent);
    }
    public void onClick3(View v){
        i--;
        switch (i) {
            case 1:
                imageView.setImageResource(R.drawable.progress1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.progress2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.progress3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.progress4);
                break;

        }

    }
}







