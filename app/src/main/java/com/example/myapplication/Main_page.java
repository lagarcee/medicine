package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class Main_page extends AppCompatActivity {
    //String content = "";
    RecyclerView recyclerView;
    JSONArray array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        recyclerView = findViewById(R.id.news);
        //String content = getContent("https://api.imgflip.com/get_memes");

        new Thread(new Runnable() {
            public void run() {
                try {
                    String content = getContent("https://api.imgflip.com/get_memes");
                    //String content = getContent("https://3b74-89-113-139-148.ngrok-free.app/api/news/?format=json"/*"https://3b74-89-113-139-148.ngrok-free.app/api/docs/price"*/);

                    JSONObject root = new JSONObject(content);
                    JSONObject response = root.getJSONObject("data");
                    array = response.getJSONArray("memes");
                    recyclerView.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                ArrayList<JSONObject> listItems = getArrayListFromJSONArray(array);
                                //RecyclerView.RecyclerListener adapter = new MAdapter(getApplicationContext(), R.layout.listview, listItems);
                                // Присваиваем ListView созданный адаптер
                                if (recyclerView != null) {
                                    //recyclerView.setAdapter((RecyclerView.Adapter) adapter);
                                }
                            } catch (Exception e) { //JSONException
                                throw new RuntimeException(e);
                            }
                        }
                    });
                } catch (IOException ex) {
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }

    private ArrayList<JSONObject> getArrayListFromJSONArray(JSONArray jsonArray) {
        ArrayList<JSONObject> aList = new ArrayList<>();
        try {
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    aList.add(jsonArray.getJSONObject(i));
                }
            }
        } catch (JSONException js) {
            js.printStackTrace();
        }
        return aList;
    }

    private String getContent(String path) throws IOException {
        BufferedReader reader = null;
        InputStream stream = null;
        HttpsURLConnection connection = null;
        try {
            URL url = new URL(path);
            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);
            connection.connect();
            stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder buf = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                buf.append(line).append("\n");
            }
            return (buf.toString());
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (stream != null) {
                stream.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}

//content = res.getContent("http://localhost:8000/api/orders/");
//content = res.getContent("http://10.24.4.55:8000/api/orders/");
//content = res.getContent("https://3b74-89-113-139-148.ngrok-free.app/api/docs");