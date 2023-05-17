package com.duyle.lab1md18312;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    boolean flagChangeBg = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btn = findViewById(R.id.btn);

        TextView tv = findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flagChangeBg) {
                    tv.setTextColor(getColor(R.color.red));
                    flagChangeBg = false;
                } else {
                    tv.setTextColor(getColor(R.color.purple_700));
                    flagChangeBg = true;
                }
            }
        });

    }
}