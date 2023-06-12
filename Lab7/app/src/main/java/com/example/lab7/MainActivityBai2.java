package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivityBai2 extends AppCompatActivity {
    ImageView logofan;

    Button btnFast;
    Button btnMedium;
    Button btnSlow;
    Button btnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        logofan = findViewById(R.id.fanBlades);

        btnFast = findViewById(R.id.btn_fast);
        btnMedium = findViewById(R.id.btn_medium);
        btnSlow = findViewById(R.id.btn_slow);
        btnOff = findViewById(R.id.btn_off);

        btnFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFan(200);
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFan(400);
            }
        });

        btnSlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFan(600);
            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logofan.animate().cancel();
            }
        });

    }


    private void startFan(long time) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                logofan.animate()
                        .rotationBy(360)
                        .withEndAction(this)
                        .setDuration(time)
                        .setInterpolator(new LinearInterpolator())
                        .start();
            }
        };
        logofan.animate()
                .rotationBy(360)
                .withEndAction(runnable)
                .setDuration(time)
                .setInterpolator(new LinearInterpolator())
                .start();
    }

}