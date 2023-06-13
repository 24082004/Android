package com.example.assignment_ph36082;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivityQlPhongban extends AppCompatActivity {

    PhongBanAdapter pban;
    ArrayList<PhongBan> listpb = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_qlphongban);
        Toolbar toolbar = findViewById(R.id.toolbar);
        ArrayList<PhongBan> listpb = new ArrayList<>();
        ListView listV = findViewById(R.id.ListPhongBan);

        listpb.add(new PhongBan(R.drawable.home, "Nhân sự"));
        listpb.add(new PhongBan(R.drawable.home, "Hành chính"));
        listpb.add(new PhongBan(R.drawable.home, "Đào Tạo"));

        PhongBanAdapter phongbanAdapter = new PhongBanAdapter(this, listpb);
        listV.setAdapter(phongbanAdapter);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Phòng ban");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}