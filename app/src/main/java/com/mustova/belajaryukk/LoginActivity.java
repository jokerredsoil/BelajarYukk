package com.mustova.belajaryukk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import com.mustova.belajaryukk.Common;

public class LoginActivity extends AppCompatActivity {
    TextView txtUser, txtPass;
    EditText edtUser, edtPass;
    Button btnLogin, btnDaftar;
    String[] dataUser;
    public static SharedPreferences sh;
    public static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUser = findViewById(R.id.txtUsername);
        txtPass = findViewById(R.id.txtPass);

        edtUser = findViewById(R.id.edtUsername);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnDaftar = findViewById(R.id.btnDaftar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readFile();
                loginProcess();
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
    }

    private void readFile() {
        File file = new File(Common.directory, edtUser.getText().toString() + ".txt");
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


    private void loginProcess() {
        try {
            if (dataUser[0].equals(edtUser.getText().toString())) {
                if (dataUser[1].equals(edtPass.getText().toString())) {
                    Common.username = dataUser[0];

//                    shared preferences
                    SplashActivity.editor.putString("loginStatus", "true");
                    SplashActivity.editor.putString("username", dataUser[0]);
                    SplashActivity.editor.putString("password", dataUser[1]);
                    SplashActivity.editor.putString("namaLengkap", dataUser[2]);
                    SplashActivity.editor.putString("email", dataUser[3]);
                    SplashActivity.editor.commit();
//                    shared preferences

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    if (edtPass.getText().toString().equals("")) {
                        Toast.makeText(this, "Please fill Password", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Password is wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                if (edtUser.getText().toString().equals("")) {
                    Toast.makeText(this, "Please fill Username", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Username is wrong", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
