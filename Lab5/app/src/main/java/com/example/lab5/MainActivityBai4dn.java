package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityBai4dn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai4_dn);
        EditText edtUsername = findViewById(R.id.edt_username);
        EditText edtPassword = findViewById(R.id.edt_password);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        Button btnLogin = findViewById(R.id.btn_login);
        Button btnSign = findViewById(R.id.btn_register);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityBai4dn.this, MainActivityBai4dk.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bundle != null) {
                    String user = bundle.getString("username");
                    String pass = bundle.getString("password");

                    boolean u = user.equals(edtUsername.getText().toString());
                    boolean p = pass.equals(edtPassword.getText().toString());

                    if (u && p) {
                        Toast.makeText(MainActivityBai4dn.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivityBai4dn.this, MainActivityBai2.class));
                    } else {
                        Toast.makeText(MainActivityBai4dn.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
