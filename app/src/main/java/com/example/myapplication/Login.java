package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Activity {
    String email = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button button = findViewById(R.id.go);
        EditText emailValidate = findViewById(R.id.editTextTextEmailAddress);
        String emailPattern = "[a-zA-Z0-9._]+@[a-z]+\\.+[a-z]+";
        button.setEnabled(false);
        emailValidate.addTextChangedListener(new TextWatcher() {
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
                email = emailValidate.getText().toString().trim();
                if (email.matches(emailPattern) && s.length() > 0) {
                    button.setEnabled(true);
                    button.setBackgroundResource(R.drawable.btn_style);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Login.this, Code_email.class);
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
}
