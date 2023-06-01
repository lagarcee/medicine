package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class ProfilesAdapter extends RecyclerView.Adapter<ProfilesAdapter.MyViewHolder> implements SpinnerAdapter {

    ArrayList<String> profiles_ID = new ArrayList<>();

    ArrayList<String> profiles_First_name = new ArrayList<>();
    ArrayList<String> profiles_Last_name = new ArrayList<>();
//    ArrayList<String> profiles_Middle_name = new ArrayList<>();
 //   ArrayList<String> profiles_Date_of_birth = new ArrayList<>();
 //   ArrayList<String> profiles_Pol = new ArrayList<>();
 //   ArrayList<String> profiles_Image = new ArrayList<>();
    Context context;
    View v;

    public ProfilesAdapter(Context context, ArrayList<String> profiles_ID, ArrayList<String> profiles_First_name,
                          ArrayList<String> profiles_Last_name /*ArrayList<String> profiles_Middle_name, ArrayList<String> profiles_Date_of_birth,
                          ArrayList<String> profiles_Pol, ArrayList<String> profiles_Image*/) {
        this.profiles_ID = profiles_ID;
        this.profiles_First_name = profiles_First_name;
        this.profiles_Last_name = profiles_Last_name;
//        this.profiles_Middle_name = profiles_Middle_name;
        this.context = context;
//        this.profiles_Date_of_birth = profiles_Date_of_birth;
//        this.profiles_Pol = profiles_Pol;
//        this.profiles_Image = profiles_Image;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.delivery, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.first_name.setText(profiles_First_name.get(position));
        holder.last_name.setText(profiles_Last_name.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog(position);
            }

        });
    }

    private void showBottomSheetDialog(int position) {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(R.layout.custom_prof_dialog);
        TextView first_name = bottomSheetDialog.findViewById(R.id.name_prof);
        Button price = bottomSheetDialog.findViewById(R.id.price2);
        first_name.setText(profiles_First_name.get(position) + profiles_Last_name.get(position));
        bottomSheetDialog.show();
    }

    @Override
    public int getItemCount() {
        return profiles_ID.size();
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView first_name, last_name;

        public MyViewHolder(View itemView) {
            super(itemView);
            first_name = (TextView) itemView.findViewById(R.id.name_prof);

        }
    }

}
