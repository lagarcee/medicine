package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    ArrayList<String> news_ID = new ArrayList<>();
    ArrayList<String> news_Name = new ArrayList<>();
    ArrayList<String> news_Description = new ArrayList<>();
    ArrayList<String> news_Price = new ArrayList<>();
    // ArrayList<String> news_Image = new ArrayList<>();
    Context context;

    public NewsAdapter(Context context, ArrayList<String> news_ID, ArrayList<String> news_Name, ArrayList<String> news_Description,
                       ArrayList<String> news_Price) {  //, ArrayList<String> news_Image) {
        this.news_ID = news_ID;
        this.news_Name = news_Name;
        this.news_Description = news_Description;
        this.news_Price = news_Price;
        this.context = context;
        // this.news_Image = news_Image;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_page_1, parent, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(news_Name.get(position));
        holder.description.setText(news_Description.get(position));
        holder.price.setText(news_Price.get(position));

        //  holder.image.setImageResource(Integer.parseInt(news_Image.get(position)));

    }

    @Override
    public int getItemCount() {
        return news_Name.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, description, price;
        //     ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name1);
            description = (TextView) itemView.findViewById(R.id.description1);
            price = (TextView) itemView.findViewById(R.id.price1);

            //  image = (ImageView) itemView1.findViewById(R.id.image1);

        }
    }
}

