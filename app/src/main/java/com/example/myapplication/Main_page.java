package com.example.myapplication;


import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

//import android.widget.ListAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ListAdapter;

import com.google.android.material.bottomsheet.BottomSheetDialog;

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
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    RecyclerView recyclerView3;
    ArrayList<String> catalog_ID = new ArrayList<>();
    ArrayList<String> news_ID = new ArrayList<>();
    ArrayList<String> catalog_Category = new ArrayList<>();
    ArrayList<String> catalog_Name = new ArrayList<>();
    ArrayList<String> news_Name = new ArrayList<>();
    ArrayList<String> catalog_Description = new ArrayList<>();
    ArrayList<String> news_Description = new ArrayList<>();
    ArrayList<String> catalog_Price = new ArrayList<>();
    ArrayList<String> news_Price = new ArrayList<>();
    ArrayList<String> catalog_Time_result = new ArrayList<>();
    ArrayList<String> catalog_Preparation = new ArrayList<>();
    ArrayList<String> catalog_Bio = new ArrayList<>();
    ArrayList<String> category_ID = new ArrayList<>();
    ArrayList<String> category_Name = new ArrayList<>();
    // ArrayList<String> news_Image = new ArrayList<>();
    int[] btn = new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        recyclerView1 = findViewById(R.id.news);
        recyclerView2 = findViewById(R.id.btn_recycler);
        recyclerView3 = findViewById(R.id.test_recycler);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(linearLayoutManager1);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(linearLayoutManager2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView3.setLayoutManager(linearLayoutManager);


        try {
            JSONObject obj = new JSONObject(loadJSONFomAsset("news.json"));
            JSONArray resultArray = obj.getJSONArray("results");
            for (int i = 0; i < resultArray.length(); i++) {
                JSONObject resultDetail = resultArray.getJSONObject(i);
                news_ID.add(resultDetail.getString("id"));
                news_Name.add(resultDetail.getString("name"));
                news_Description.add(resultDetail.getString("description"));
                news_Price.add(resultDetail.getString("price"));
                // news_Image.add(resultDetail.getString("image"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        NewsAdapter newsAdapter = new NewsAdapter(Main_page.this, news_ID, news_Name, news_Description, news_Price);//, news_Image);
        recyclerView1.setAdapter(newsAdapter);

        try {
            JSONObject obj = new JSONObject(loadJSONFomAsset("category.json"));
            JSONArray resultArray = obj.getJSONArray("results");
            for (int i = 0; i < resultArray.length(); i++) {
                JSONObject resultDetail = resultArray.getJSONObject(i);
                category_ID.add(resultDetail.getString("id"));
                category_Name.add(resultDetail.getString("name"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        CategoryAdapter categoryAdapter = new CategoryAdapter(Main_page.this, category_ID, category_Name);
        recyclerView2.setAdapter(categoryAdapter);

        try {
            JSONObject obj = new JSONObject(loadJSONFomAsset("catalog.json"));
            JSONArray resultArray = obj.getJSONArray("results");
            for (int i = 0; i < resultArray.length(); i++) {
                JSONObject resultDetail = resultArray.getJSONObject(i);
                catalog_ID.add(resultDetail.getString("id"));
                catalog_Category.add(resultDetail.getString("category"));
                catalog_Name.add(resultDetail.getString("name"));
                catalog_Description.add(resultDetail.getString("description"));
                catalog_Price.add(resultDetail.getString("price"));
                catalog_Time_result.add(resultDetail.getString("time_result"));
                catalog_Preparation.add(resultDetail.getString("preparation"));
                catalog_Bio.add(resultDetail.getString("bio"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        CatalogAdapter catalogAdapter = new CatalogAdapter(Main_page.this, catalog_ID, catalog_Name, catalog_Price, catalog_Time_result, catalog_Description, catalog_Bio, catalog_Preparation);
        recyclerView3.setAdapter(catalogAdapter);


    }
    private void showBottomSheetDialog() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.custom_dialog);
        TextView name =  bottomSheetDialog.findViewById(R.id.name2);
        name.setText(catalog_ID.get(1));


        bottomSheetDialog.show();
    }

    public String loadJSONFomAsset(String path) {
        String json = null;
        try {
            InputStream is = getAssets().open(path);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
