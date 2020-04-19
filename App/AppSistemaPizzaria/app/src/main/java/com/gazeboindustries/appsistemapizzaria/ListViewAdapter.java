package com.gazeboindustries.appsistemapizzaria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<SaborPizza> {
    Context context;
    List<SaborPizza> list = new ArrayList<>();


    public ListViewAdapter(@NonNull Context context, int resource, List<SaborPizza> list) {
        super(context, resource, list);
        this.context = context;
        this.list = list;
        list.addAll(list);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        VersionHolder holder = new VersionHolder();

        if (convertView == null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_row,null);


            holder.checkBox = convertView.findViewById(R.id.check_box);
            holder.textView = convertView.findViewById(R.id.name);
            holder.textView2 = convertView.findViewById(R.id.price);

            holder.checkBox.setOnCheckedChangeListener((Request)context);

            convertView.setTag(holder);

        }else{
            holder = (VersionHolder) convertView.getTag();
        }

        SaborPizza versions  = list.get(position);
        holder.textView.setText(versions.getTaste());
        holder.textView2.setText(versions.getPrice());
        holder.checkBox.setTag(list);

        return convertView;
    }

    public static class VersionHolder{
        public CheckBox checkBox;
        public TextView textView;
        public TextView textView2;
    }

}
