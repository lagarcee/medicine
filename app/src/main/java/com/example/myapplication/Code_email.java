package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Code_email extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.code_email);
        EditText editText = findViewById(R.id.editTextNumber1);
        EditText editText1 = findViewById(R.id.editTextNumber2);
        EditText editText2 = findViewById(R.id.editTextNumber3);
        EditText editText3 = findViewById(R.id.editTextNumber4);
        TextView textView = findViewById(R.id.time_code);
        ImageButton imageButton = findViewById(R.id.back);

        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = "" + editText.getText() + editText1.getText() + editText2.getText() + editText3.getText();
                Intent intent = new Intent(Code_email.this, Password.class);
                startActivity(intent);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        new CountDownTimer(60000,1000){
            @Override
            public void onTick(long millisUntilFinished){
                NumberFormat f = new DecimalFormat("00");
                long sec = (millisUntilFinished/1000)%60;
                textView.setText("Отправить код повторно можно\nбудет через " + f.format(sec) + " секунд");
            }
            @Override
            public void onFinish(){
                textView.setText("Отправить код повторно можно\nбудет через 00");
            }
        }.start();

    }
    public void onClick2(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}

