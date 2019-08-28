









package com.mustova.belajaryukk;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import com.mustova.belajaryukk.Common;

public class RegisterActivity extends AppCompatActivity {
    TextView txtUser, txtPass, txtNama, txtEmail;
    EditText edtUser, edtPass, edtNama, edtEmail;
    Button btnReg;

    protected boolean shouldAskPermissions() {
        return (Build.VERSION.SDK_INT >
                Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    @TargetApi(23)
    protected void askPermissions() {
        String[] permissions = {
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE"
        };
        int requestCode = 200;
        requestPermissions(permissions, requestCode);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (shouldAskPermissions()) {
            askPermissions();
        }

        txtUser = findViewById(R.id.txtUsername);
        txtPass = findViewById(R.id.txtPass);
        txtNama = findViewById(R.id.txtPengguna);
        txtEmail = findViewById(R.id.txtEmail);

        edtUser = findViewById(R.id.edtUsername);
        edtPass = findViewById(R.id.edtPass);
        edtNama = findViewById(R.id.edtPengguna);
        edtEmail = findViewById(R.id.edtEmail);
        btnReg = findViewById(R.id.btnReg);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValid()) {
                    if(isValidEmail()) {
                        if(isSaveData()) {
                            Toast.makeText(RegisterActivity.this, "Registrasi berhasil",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this,
                                    LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this,
                                "Format File Salah!!",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this,
                            "Tolong Lengkapi data anda",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValid() {
        if (edtUser.getText().toString().equals("") ||
                edtPass.getText().toString().equals("") ||
                edtNama.getText().toString().equals("") ||
                edtEmail.getText().toString().equals("")) {
            return false;
        }
        return true;
    }

    private boolean isValidEmail() {
        if(edtEmail.getText().toString().contains("@") && edtEmail.getText().toString().contains(".com")) {
            return true;
        }
        return false;
    }

    private boolean isSaveData() {
        String isiFile = edtUser.getText().toString() + ";" + edtPass.getText().toString() + ";" +
                edtNama.getText().toString() + ";" + edtEmail.getText().toString() ;
        File directory = new File(Common.extStorage, "vsga");
        if(!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(Common.directory, edtUser.getText().toString()+ ".txt");

        FileOutputStream outputStream;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
            return true;
        } catch(Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}


