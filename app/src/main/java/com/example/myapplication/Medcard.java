package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Medcard extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medcard);
        EditText editText = findViewById(R.id.editTextDate);
        Button button = findViewById(R.id.create);
        TextView textView = findViewById(R.id.resume1);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                button.setEnabled(false);
                button.setBackgroundResource(R.drawable.btn_false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                button.setEnabled(false);
                button.setBackgroundResource(R.drawable.btn_false);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editText.length() > 0) {
                    button.setEnabled(true);
                    button.setBackgroundResource(R.drawable.btn_style);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Medcard.this, Main_page.class);
                            startActivity(intent);
                        }
                    });
                }else {
                    button.setEnabled(false);
                    button.setBackgroundResource(R.drawable.btn_false);
                }
            }
        });
    }
    public void onClick3(View v) {
        Intent intent = new Intent(Medcard.this, Main_page.class);
        startActivity(intent);
    }
}
