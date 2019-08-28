package com.mustova.belajaryukk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static com.mustova.belajaryukk.Common.username;
import static com.mustova.belajaryukk.SplashActivity.editor;

public class MainActivity extends AppCompatActivity {

    TextView txtwelcome;
    Button btnList, btnMaps;
    Toolbar toolbar;
    String[] dataUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtwelcome = findViewById(R.id.txtWelcome);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Menu Utama");
        readFile();

        if (dataUser != null) {
            txtwelcome.setText("Welcome, " + dataUser[2] + "!!");
        } else {
            txtwelcome.setText(SplashActivity.sh.getString("namaLengkap", null));
        } //        get values from shared preferences


        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HurufActivity.class);
                startActivity(intent);
            }
        });
    }

        private void readFile () {
            File file = new File(Common.directory, username + ".txt");
            try {
                if (file.exists()) {
                    StringBuilder text = new StringBuilder();

                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line = br.readLine();

                    while (line != null) {
                        text.append(line);
                        line = br.readLine();
                    }
                    br.close();
                    dataUser = text.toString().split(";");
                }
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }


        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.content_menu, menu);
            return true;
        }

        public boolean onOptionsItemSelected (MenuItem item){
            if (item.getItemId() == R.id.actionlogout) {
                setLogout();
                //startActivity(new Intent(this, LoginActivity.class));
                finish();
            }
            return true;
        }

        private void setLogout () {
            SplashActivity.editor.remove("loginStatus");
            SplashActivity.editor.commit();

            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
    }











