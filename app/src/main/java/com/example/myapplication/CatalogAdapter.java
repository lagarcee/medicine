package com.example.myapplication;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Catalog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CatalogAdapter extends// RecyclerView.ViewHolder {
        RecyclerView.Adapter<CatalogAdapter.ViewHolder> {
    int listLayout;
    ArrayList<JSONObject> list;
    Context context;
    View convertView;

    CatalogAdapter(Context context, int listLayout, ArrayList<JSONObject> list) {
        //super(context, listLayout, list);
        //super(context, listLayout, list, convertView);
        this.context = context;
        this.listLayout = listLayout;
        this.list = list;
        //this.convertView = convertView;
/*        Log.d(Const.DEBUG, "Urls Size: " + urls.size());
        Log.d(Const.DEBUG, urls.toString());*/
    }
    //@Override
    public CatalogAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       // View itemView = inflater.inflate(listLayout,parent,false);

        View itemView = inflater.inflate(R.layout.news, parent, false);
        return new ViewHolder(itemView);
    }
    //@Override
    public void onBindViewHolder(CatalogAdapter.ViewHolder holder, int position) {
        //Catalog catalog = list.get(position);
        //holder.flagView.setImageResource(state.getFlagResource());
        try {
            holder.name.setText(list.get(position).getString("name")); //TODO
            holder.des.setText(list.get(position).getString("des"));
            // holder.img.setImageResource(Integer.parseInt(list.get(position).getString("img")));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


/*        holder.name.setText(catalog.getName());
        holder.des.setText(catalog.getDescription());*/

        // обработка нажатия
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                // вызываем метод слушателя, передавая ему данные
                //onClickListener.onStateClick(catalog, position);
            }
        });
    }

    //@Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //final ImageView flagView;
        final TextView name, des;

        ViewHolder(View view){
            super(view);
            name = itemView.findViewById(R.id.name);
            des = itemView.findViewById(R.id.description);
            //flagView = view.findViewById(R.id.flag);
            //nameView = view.findViewById(R.id.name);
            //capitalView = view.findViewById(R.id.capital);
        }
    }
}