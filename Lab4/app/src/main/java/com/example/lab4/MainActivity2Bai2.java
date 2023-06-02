package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2Bai2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_bai2);

        TextView tvNamesp = findViewById(R.id.tv_nameSp);
        Button btnBaogia = findViewById(R.id.btn_baoGia);
        EditText edtPrice = findViewById(R.id.edt_price);

        Intent intent = getIntent();
        String ten = intent.getStringExtra("name");
        tvNamesp.setText(ten);

        btnBaogia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("priceData", edtPrice.getText().toString());
                intent.putExtras(bundle);
                setResult(1, intent);
                finish();
            }
        });
    }
}