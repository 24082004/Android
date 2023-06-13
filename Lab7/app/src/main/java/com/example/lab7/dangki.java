package com.example.lab7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class dangki extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky);

        EditText sUser = findViewById(R.id.et_username1);
        EditText sPass = findViewById(R.id.et_password1);
        EditText rePass = findViewById(R.id.et_repassword);
        Button btnLogin = findViewById(R.id.btn_getlogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = sUser.getText().toString();
                String pass = sPass.getText().toString();
                String chPass = rePass.getText().toString();

                if (!pass.equals(chPass)) {
                    Toast.makeText(dangki.this, "Mật khẩu nhập không giống nhau", Toast.LENGTH_SHORT).show();
                } else if (user.equals("")) {
                    Toast.makeText(dangki.this, "Không được để trống tên", Toast.LENGTH_SHORT).show();

                } else if (pass.equals("") || chPass.equals("")) {
                    Toast.makeText(dangki.this, "Không được để trống mật khẩu", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), dangki.class);
                    Bundle bundle = new Bundle();

                    bundle.putString(dangnhap.KEY_USER, user);
                    bundle.putString(dangnhap.KEY_PASS, pass);
                    intent.putExtras(bundle);
                    setResult(1, intent);
                    Toast.makeText(dangki.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }
}
