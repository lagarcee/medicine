package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;


public class Analysis extends AppCompatActivity {

    TextView textView, textView2, textView1;
    ImageView imageView, imageView1;
    String sDown, sMove, sUp;
    int[] title = new int[3];
    float x1 = 0;
    int i = 0;
    String content = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analysis);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Response res = new Response();
//                try {
//                    //content = res.getContent("http://10.24.4.55:8000/api/orders/");
//                    content = res.getContent("https://3b74-89-113-139-148.ngrok-free.app/api/news/?format=json");
//                    //content = res.getContent("https://api.imgflip.com/get_memes");
//                    String test = content;
//                    //content = res.getContent("http://localhost:8000/api/orders/");
//
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//
//            }
//        }).start();
        //OnSwipeTouchListener = new OnSwipeTouchListener(this, findViewById(R.id.lin_lay));
        textView = findViewById(R.id.title_analysis);
        textView1 = findViewById(R.id.description);
        textView2 = findViewById(R.id.resume);
        imageView = findViewById(R.id.scroll);
        imageView1 = findViewById(R.id.medicine);
        LinearLayout linearLayout = findViewById(R.id.lin_lay);
        linearLayout.setOnTouchListener(this::onTouch);

        title[0] = 1;
        title[1] = 2;
        title[2] = 3;
        Check(i);




    }

    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                x1 = x;
                break;
            case MotionEvent.ACTION_UP: // отпускание
            case MotionEvent.ACTION_CANCEL:
                if (x > x1) {
                    if (i != 0) {
                        i--;
                    }
                } else if (x < x1) {
                    if (i < 2) {
                        i++;
                    }
                    if (i == 2) {
                        textView2.setText("Завершить");
                    }
                }
                Check(i);
                break;
        }
        return true;
    }

    public void Check(int i) {
        if (title[i] == 1) {
            textView.setText("Анализы");
            textView1.setText("Экспресс сбор и получение проб");
            imageView.setImageResource(R.drawable.rbtn1);
            imageView1.setImageResource(R.drawable.lab);

        }
        if (title[i] == 2) {
            textView.setText("Уведомления");
            textView1.setText("Вы быстро узнаете о результатах");
            imageView.setImageResource(R.drawable.rbtn2);
            imageView1.setImageResource(R.drawable.med);

        }
        if (title[i] == 3) {
            textView.setText("Уведомления");
            textView1.setText("Наши врачи всегда наблюдают \n" + "за вашими показателями здоровья");
            imageView.setImageResource(R.drawable.rbtn3);
            imageView1.setImageResource(R.drawable.medsis);

        }
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}

