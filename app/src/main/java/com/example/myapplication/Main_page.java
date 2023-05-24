package com.example.myapplication;


import android.os.Bundle;

//import android.widget.ListAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ListAdapter;

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
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class Main_page extends AppCompatActivity {
    //String content = "";
    RecyclerView recyclerView;
    JSONArray array;
    JSONObject object;
    private MAdapter adapter;
    CatalogAdapter cadapter;
    List<String> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        recyclerView = findViewById(R.id.MainPage_Recycler_2);
        //String content = getContent("https://api.imgflip.com/get_memes");
        try {
            String content = getContent1("catalog.json");
            JSONObject root = new JSONObject(content);
            //JSONObject response = root.getJSONObject("results");
            //JSONObject object = array.getJSONObject(1);
            array = root.getJSONArray("results");
            //object  =array.getJSONObject(0);



        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                try {
                    ArrayList<JSONObject> listItems = getArrayListFromJSONArray(array);
                    //adapter = new MAdapter(getApplicationContext(),R.layout.main_page,listItems);
                    cadapter = new CatalogAdapter(getApplicationContext(),R.layout.main_page,listItems);
                    // Присваиваем ListView созданный адаптер
                    if (recyclerView != null) {
                        recyclerView.setAdapter(cadapter); //TODO ?
                    }
                } catch (Exception e) { //JSONException
                    throw new RuntimeException(e);
                }
            }
        });

/*        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                try {
                    // Создание адаптера и присвоение ему файла компоновки листа и листа
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.news, items);

                    for(int i=0;i<array.length();i++)
                    {
                        object = array.getJSONObject(i);
                        items.add(array.getString(Integer.parseInt("name"))); //TODO ?
                    }
                    // Присваиваем ListView созданный адаптер
                    if (recyclerView != null) {
                        recyclerView.setAdapter(adapter);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });*/


/*        new Thread(new Runnable() {
            public void run() {
                try {
                    String content = getContent("https://api.imgflip.com/get_memes"); String content = getContent("https://3b74-89-113-139-148.ngrok-free.app/api/news/?format=json"*//*"https://3b74-89-113-139-148.ngrok-free.app/api/docs/price"*//*);

                    JSONObject root = new JSONObject(content);
                    JSONObject response = root.getJSONObject("data");
                    array = response.getJSONArray("memes");
                    recyclerView.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                ArrayList<JSONObject> listItems = getArrayListFromJSONArray(array);
                                if (recyclerView != null) {
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
        }).start(); */


    }
    private JSONObject getJson(JSONArray array, List<String> items) throws JSONException {
        for(int i=0;i<array.length();i++)
        {
            object = array.getJSONObject(i);
            items.add(object.getString("name"));
        }
        return object;
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


    private String getContent1(String path) throws IOException {
        BufferedReader reader = null;
        InputStream stream = null;
        HttpsURLConnection connection = null;
        try {
            stream = this.getAssets().open(path); //TODO Получение с файла
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