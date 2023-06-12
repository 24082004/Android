package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityBai4dk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bai4_dk);
        EditText edtUsername = findViewById(R.id.edt_User);
        EditText edtPassword = findViewById(R.id.edt_Pass);
        EditText edtRetypePass = findViewById(R.id.edt_Retypepass);

        Button btnRegister = findViewById(R.id.btn_back);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sUserName = edtUsername.getText().toString().trim();
                String sPassword = edtPassword.getText().toString().trim();
                String sRetypePass = edtRetypePass.getText().toString().trim();

                if (sUserName.equals("")) {
                    Toast.makeText(MainActivityBai4dk.this, "Username không được để trống!", Toast.LENGTH_SHORT).show();
                } else if (sPassword.equals("")) {
                    Toast.makeText(MainActivityBai4dk.this, "Password không được để trống!", Toast.LENGTH_SHORT).show();
                } else if (sRetypePass.equals("")) {
                    Toast.makeText(MainActivityBai4dk.this, "Password nhập lại không được để trống!", Toast.LENGTH_SHORT).show();
                } else if (!sRetypePass.equals(sPassword)) {
                    Toast.makeText(MainActivityBai4dk.this, "Password nhập lại chưa đúng!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), MainActivityBai4dn.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("username", sUserName);
                    bundle.putString("password", sPassword);

                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }
}