package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    ArrayList<String> category_ID = new ArrayList<>();
    ArrayList<String> category_Name = new ArrayList<>();
    Context context;

    public CategoryAdapter(Context context, ArrayList<String> category_ID, ArrayList<String> category_Name) {
        this.context = context;
        this.category_ID= category_ID;
        this.category_Name=category_Name;

    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.button_news, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.button.setText(category_Name.get(position));

        }

    @Override
    public int getItemCount() {
        return category_ID.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        Button button;

        public MyViewHolder(View itemView) {
            super(itemView);
            button = (Button) itemView.findViewById(R.id.btn_news);
        }
    }
}




