package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int SPLASH_DURATION = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img = findViewById(R.id.img);
        TextView text = findViewById(R.id.text);

        Animation anim1 = AnimationUtils.loadAnimation(this,R.anim.anim_1);
        img.startAnimation(anim1);

        Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.anim_2);
        text.startAnimation(anim2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MainActivityBai2.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}