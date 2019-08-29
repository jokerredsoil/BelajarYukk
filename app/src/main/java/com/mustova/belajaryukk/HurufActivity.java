package com.mustova.belajaryukk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.mustova.belajaryukk.R;

public class HurufActivity extends AppCompatActivity {
    ImageButton btnA, btnB, btnC, btnD, btnE;
    ImageView gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huruf);

        btnA = findViewById(R.id.btn01);
        btnB = findViewById(R.id.btn02);
        btnC = findViewById(R.id.btn03);
        btnD = findViewById(R.id.btn04);
        btnE = findViewById(R.id.btn05);

        gambar = findViewById(R.id.gambar);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gambar.setImageResource(R.drawable.a01);

                Toast.makeText(HurufActivity.this, "Gambar telah di set", Toast.LENGTH_SHORT).show();
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gambar.setImageResource(R.drawable.b01);
                Toast.makeText(HurufActivity.this, "Gambar telah di set", Toast.LENGTH_SHORT).show();
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gambar.setImageResource(R.drawable.c01);
                Toast.makeText(HurufActivity.this, "Gambar telah di set", Toast.LENGTH_SHORT).show();
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gambar.setImageResource(R.drawable.d01);
                Toast.makeText(HurufActivity.this, "Gambar telah di set", Toast.LENGTH_SHORT).show();
            }
        });

        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gambar.setImageResource(R.drawable.e01);
                Toast.makeText(HurufActivity.this, "Gambar telah di set", Toast.LENGTH_SHORT).show();
            }
        });
    }

}


