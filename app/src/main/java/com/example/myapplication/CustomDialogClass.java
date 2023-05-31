package com.example.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class CustomDialogClass extends Dialog {
    public Activity c;
    public Dialog d;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;

    public CustomDialogClass(@NonNull Context context) {
        super(context);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);
    }

    public void showDialog(Activity activity) {
        textView1 = findViewById(R.id.name2);
        textView2 = findViewById(R.id.description2);
        textView3 = findViewById(R.id.preparation);
        textView4 = findViewById(R.id.time_result1);
        textView5 = findViewById(R.id.bio);
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.show();

    }



}
