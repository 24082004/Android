package com.example.lab5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SinhVien_Adapter extends BaseAdapter {
    ArrayList<SinhVien> list;
    Context context;

    public SinhVien_Adapter(ArrayList<SinhVien> list, Context c) {
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
        LayoutInflater inf = ((MainActivityBai2) context).getLayoutInflater();
        convertView = inf.inflate(R.layout.listview,null);

        TextView cs = convertView.findViewById(R.id.tvCS);
        TextView name = convertView.findViewById(R.id.tvName);
        TextView dc = convertView.findViewById(R.id.tvDc);
        Button btupdate = convertView.findViewById(R.id.btUpdate);
        Button btdelete = convertView.findViewById(R.id.btDelete);

        cs.setText(list.get(position).coSo);
        name.setText(list.get(position).hoTen);
        dc.setText(list.get(position).diaChi);

        btdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivityBai2)context).deleteSV(position);
            }
        });

        btupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivityBai2)context).updateSV(position);
            }
        });
        return convertView;
    }
}

