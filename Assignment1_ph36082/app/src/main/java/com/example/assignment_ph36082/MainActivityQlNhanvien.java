package com.example.assignment_ph36082;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.io.Serializable;
import java.util.ArrayList;

public class MainActivityQlNhanvien extends AppCompatActivity implements Serializable {
    ArrayList<NhanVien> listNV = new ArrayList<>();
    NhanVienAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_qlnhanvien);

        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView txt = findViewById(R.id.txt);
        ListView listView = findViewById(R.id.ListView);

        listNV.add(new NhanVien("Mã NV: PH01", "Họ tên: Lợi", "Phòng ban: Giám Đốc"));
        listNV.add(new NhanVien("Mã NV: PH02", "Họ tên: Đại", "Phòng ban: Trưởng phòng"));
        listNV.add(new NhanVien("Mã NV: PH03", "Họ tên: Cường", "Phòng ban: Nhân viên"));

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Quản Lý Nhaan Viên");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });


        adapter = new NhanVienAdapter(this, listNV);
        listView.setAdapter(adapter);
    }

    public void add() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = ((Activity) this).getLayoutInflater();
        View view = inflater.inflate(R.layout.update_layout, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        EditText manv = view.findViewById(R.id.manv);
        EditText uphoten = view.findViewById(R.id.uphoten);
        EditText upchucvu = view.findViewById(R.id.upchucvu);
        Button btnhoanthanh = view.findViewById(R.id.btnhoanthanh);

        btnhoanthanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma = manv.getText().toString();
                String hoten = uphoten.getText().toString();
                String chucvu = upchucvu.getText().toString();

                listNV.add(new NhanVien(ma, hoten, chucvu));
                fFile.ghiFile(MainActivityQlNhanvien.this, "file2.txt", listNV);
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
    }

}
