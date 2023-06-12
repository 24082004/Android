package com.example.lab5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

public class SinhVien_Adapter extends BaseAdapter implements Filterable {
    ArrayList<SinhVien> list;
    Context context;
    ArrayList<SinhVien> listold;
    public SinhVien_Adapter(ArrayList<SinhVien> list, Context c) {
        this.list = list;
        this.context = c;
        this.listold = list;
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

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String s = constraint.toString();
                if (s.isEmpty()){
                    list = listold;
                } else{
                    ArrayList<SinhVien> listS = new ArrayList<>();
                    for (SinhVien sv : listold){
                        if (sv.getHoTen().toLowerCase().contains(s.toLowerCase())){
                            listS.add(sv);
                        }
                    }
                    list = listS;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = list;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                list = (ArrayList<SinhVien>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}

