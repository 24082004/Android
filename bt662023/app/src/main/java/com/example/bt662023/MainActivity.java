package com.example.bt662023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view1 = findViewById(R.id.view1);
        Animation amin1 = AnimationUtils.loadAnimation(this, R.anim.amin1);
        view1.startAnimation(amin1);
    }
}