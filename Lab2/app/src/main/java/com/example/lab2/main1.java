package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class main1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai1);

        Button btnClick = findViewById(R.id.btn_click);
        EditText edtHoten = findViewById(R.id.edt_hoten);
        TextView tvKq = findViewById(R.id.tv_result);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten = edtHoten.getText().toString();

                tvKq.setText(hoten);
            }
        });
    }
}