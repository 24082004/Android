package com.example.assignment_ph36082;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dangnhap extends AppCompatActivity {
    String TK = null;
    String MK = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        EditText edtUsername = findViewById(R.id.edt_username);
        EditText edtPassword = findViewById(R.id.edt_password);

        Bundle data = getIntent().getExtras();

        edtUsername.setText(data.getString("username"));
        edtPassword.setText(data.getString("password"));

        Button btndangnhap = findViewById(R.id.btn_dangnhap);
        Button btnBack = findViewById(R.id.btn_trove);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dangnhap.this , dangky.class);
                ActivityResultLauncher<Intent> getData = null;
                getData.launch(intent);
            }
            });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();

                String a = bundle.getString("User");
                String b = bundle.getString("Pass");
                String inputUser = edtUsername.getText().toString();
                String inputPass = edtPassword.getText().toString();

                boolean testUser = inputUser.equals(a);
                boolean testPass = inputPass.equals(b);


                if (inputUser.length() == 0 && inputPass.length() == 0) {
                    Toast.makeText(dangnhap.this, "Ban chua nhap du thong tin", Toast.LENGTH_SHORT).show();
                }else if(testPass == false || testUser == false) {
                    Toast.makeText(dangnhap.this, "Bạn sai thông tin", Toast.LENGTH_SHORT).show();
                }else if (testPass && testUser) {
                    Intent intent1 = new Intent(dangnhap.this, trangchu.class);
                    Toast.makeText(dangnhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    startActivity(intent1);
                }
            }
        });
    }
}