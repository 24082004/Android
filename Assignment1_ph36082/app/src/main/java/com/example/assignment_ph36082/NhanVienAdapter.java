package com.example.assignment_ph36082;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class NhanVienAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<NhanVien> list = new ArrayList<>();

    public NhanVienAdapter(Context context, ArrayList<NhanVien> list) {
        this.context = context;
        this.list = list;
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.nhanvien_layout, parent, false);
        TextView txtMa = convertView.findViewById(R.id.manv);
        TextView txtName = convertView.findViewById(R.id.tennv);
        TextView txtPB = convertView.findViewById(R.id.pbnv);
        ImageView imgDelete = convertView.findViewById(R.id.Remove);

        NhanVien nhanvien = list.get(position);

        txtMa.setText(nhanvien.getManv());
        txtName.setText(nhanvien.getTennv());
        txtPB.setText(nhanvien.getPbnv());

        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
                fFile.ghiFile(context, "txt", list);
            }
        });
        return convertView;
    }

    public void dialog(NhanVien nv) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.update_layout, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        EditText manv = view.findViewById(R.id.manv);
        EditText uphoten = view.findViewById(R.id.uphoten);
        EditText upchucvu = view.findViewById(R.id.upchucvu);
        Button btnhoanthanh = view.findViewById(R.id.btnhoanthanh);

        manv.setText(nv.getManv());
        uphoten.setText(nv.getTennv());
        upchucvu.setText(nv.getPbnv());

        btnhoanthanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nv.setManv(manv.getText().toString());
                nv.setTennv(uphoten.getText().toString());
                nv.setPbnv(upchucvu.getText().toString());
                dialog.dismiss();
                fFile.ghiFile(context, "file2.txt", list);
                notifyDataSetChanged();
            }
        });
    }
}
