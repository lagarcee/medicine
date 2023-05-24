package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MAdapter extends ArrayAdapter<JSONObject> {
    int listLayout;
    ArrayList<JSONObject> list;
    Context context;
    public MAdapter(Context context, int listLayout, ArrayList<JSONObject> list) {
        super(context, listLayout, list);
        this.context = context;
        this.listLayout = listLayout;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(listLayout,parent,false);
        TextView name = itemView.findViewById(R.id.name);
        TextView des = itemView.findViewById(R.id.description);
        ImageView img = itemView.findViewById(R.id.image);
        try {
            name.setText(list.get(position).getString("name"));
            des.setText(list.get(position).getString("des"));
            img.setImageResource(Integer.parseInt(list.get(position).getString("img")));
        }catch (JSONException e){
            e.printStackTrace();
        }
        return itemView;
    }

}
