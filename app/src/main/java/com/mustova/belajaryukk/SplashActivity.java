package com.mustova.belajaryukk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    public static SharedPreferences sh;
    public static SharedPreferences.Editor editor;
    public static final String FILENAME = "login";
    Animation anim;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sh = getSharedPreferences("myprefe", 0);
        editor = sh.edit();
        anim = AnimationUtils.loadAnimation(this, R.anim.anim);
        logo = findViewById(R.id.logo);
        logo.setAnimation(anim);

        // Menghilangkan Status Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Memberi Delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }

        }, 3000L);
    }
}