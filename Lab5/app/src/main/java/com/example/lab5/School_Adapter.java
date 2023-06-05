package com.example.lab5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class School_Adapter extends BaseAdapter {
    ArrayList<School> list = new ArrayList<>();
    Context context;

    public School_Adapter(ArrayList<School> list, Context c) {
        this.list = list;
        this.context = c;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((MainActivityBai1) context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.spinner, null);

        ImageView img = convertView.findViewById(R.id.imageView);
        TextView tv11 = convertView.findViewById(R.id.textView11);

        img.setImageResource(list.get(position).hinh);
        tv11.setText(list.get(position).ten);
        return convertView;
    }
}

