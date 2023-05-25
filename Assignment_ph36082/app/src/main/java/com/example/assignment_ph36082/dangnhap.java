package com.example.assignment_ph36082;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class dangnhap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        EditText edtUsername = findViewById(R.id.edt_username);
        EditText edtPassword = findViewById(R.id.edt_password);

        Bundle data = getIntent().getExtras();

        edtUsername.setText(data.getString("username"));
        edtPassword.setText(data.getString("password"));

        Button btnBack = findViewById(R.id.btn_trove);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
        Button btndangnhap = findViewById(R.id.btn_dangnhap);
        btndangnhap.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(dangnhap.this, trangchu.class);
                startActivity(intent);
            }
        });
    }
        @Override
        public void onBackPressed() {

            Intent data = new Intent();
            data.putExtra("number", 18);

            setResult(RESULT_OK, data);

            super.onBackPressed();
        }
}