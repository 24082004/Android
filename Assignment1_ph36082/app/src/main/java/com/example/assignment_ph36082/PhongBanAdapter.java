package com.example.assignment_ph36082;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PhongBanAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<PhongBan> listPB  = new ArrayList<>();
    public PhongBanAdapter(Context context, ArrayList<PhongBan> listPB) {
        this.context = context;
        this.listPB = listPB;
    }



    @Override
    public int getCount() {
        return listPB.size();
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.phonban_layout, null);

        ImageView img = convertView.findViewById(R.id.img_pb);
        TextView txt = convertView.findViewById(R.id.txt_pb);

        PhongBan phongban = listPB.get(position);

        img.setImageResource(phongban.getAnh());
        txt.setText(phongban.getName());

        return convertView;
    }

}

