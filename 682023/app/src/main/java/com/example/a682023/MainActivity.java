package com.example.a682023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPassword;
    TextView tvKetqua;
    Button btnLuudulieu;
    Button btnDocdulieu;

    private void mapView(){
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        tvKetqua = findViewById(R.id.tv1);
        btnLuudulieu = findViewById(R.id.btn_luudulieu);
        btnDocdulieu = findViewById(R.id.btn_docdulieu);
    }

    private final String FILE_NAME = "dulieu.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapView();

        btnLuudulieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
            }
        });

        btnDocdulieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fileInputStream = openFileInput("data.txt");
                    int read = -1;
                    StringBuilder buffer = new StringBuilder();
                    while((read =fileInputStream.read())!= -1){
                        buffer.append((char)read);
                    }
                    String name = buffer.substring(0, buffer.indexOf(""));
                    String pass = buffer.substring(buffer.indexOf("") + 1 );
                    Toast.makeText(getApplicationContext(), name + " - " + pass, Toast.LENGTH_SHORT).show();
                }catch (Exception e){

                }
            }
        });
    }
}