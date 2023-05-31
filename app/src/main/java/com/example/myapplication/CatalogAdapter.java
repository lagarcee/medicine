package com.example.myapplication;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.MyViewHolder> {

    ArrayList<String> catalog_ID = new ArrayList<>();
    ArrayList<String> catalog_Name = new ArrayList<>();
    ArrayList<String> catalog_Price = new ArrayList<>();
    ArrayList<String> catalog_Description = new ArrayList<>();
    ArrayList<String> catalog_Time_result = new ArrayList<>();
    ArrayList<String> catalog_Preparation = new ArrayList<>();
    ArrayList<String> catalog_Bio = new ArrayList<>();
    Context context;
    View v;

    public CatalogAdapter(Context context, ArrayList<String> catalog_ID, ArrayList<String> catalog_Name,
                          ArrayList<String> catalog_Price, ArrayList<String> catalog_Time_result, ArrayList<String> catalog_Description,
                          ArrayList<String> catalog_Preparation, ArrayList<String> catalog_Bio) {
        this.catalog_ID = catalog_ID;
        this.catalog_Description = catalog_Description;
        this.catalog_Preparation = catalog_Preparation;
        this.catalog_Bio = catalog_Bio;
        this.context = context;
        this.catalog_Name = catalog_Name;
        this.catalog_Price = catalog_Price;
        this.catalog_Time_result = catalog_Time_result;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.catalog, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.name.setText(catalog_Name.get(position));
        holder.price.setText(catalog_Price.get(position));
        holder.time_result.setText(catalog_Time_result.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog(position);
            }

        });
    }

    private void showBottomSheetDialog(int position) {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(R.layout.custom_dialog);
        TextView name = bottomSheetDialog.findViewById(R.id.name2);
        TextView description = bottomSheetDialog.findViewById(R.id.description2);
        TextView preparation = bottomSheetDialog.findViewById(R.id.preparation);
        TextView time_result = bottomSheetDialog.findViewById(R.id.time_result1);
        TextView bio = bottomSheetDialog.findViewById(R.id.bio);
        Button price = bottomSheetDialog.findViewById(R.id.price2);
        name.setText(catalog_Name.get(position));
        description.setText(catalog_Description.get(position));
        preparation.setText(catalog_Bio.get(position));
        time_result.setText(catalog_Time_result.get(position));
        bio.setText(catalog_Preparation.get(position));
        price.setText("Добавить за " + catalog_Price.get(position));

        bottomSheetDialog.show();
    }

    @Override
    public int getItemCount() {
        return catalog_ID.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, price, time_result;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            time_result = itemView.findViewById(R.id.time_result);

        }
    }

}
