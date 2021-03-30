package com.example.mrhead2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    EditText textNIM, textPassword;
    Button btnSignIn;
    String tempNim = "";
    String tempPasswd = "";
    //int reqCode = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        textNIM = (EditText) findViewById(R.id.editTextNIM);
        textPassword = (EditText) findViewById((R.id.editTextPassword));

        Intent intent = getIntent();
        tempNim = intent.getStringExtra("nim");
        tempPasswd = intent.getStringExtra("password");

        textNIM.setText(tempNim);

        configureSingInBtn();
        SignUpText();
    }

    public boolean validation(String type) {
        if ("nim".equals(type)) {
            return textNIM.getText().toString().equals(tempNim) && tempNim != "";
        } else if ("password".equals(type)) {
            return textPassword.getText().toString().equals(tempPasswd) && tempPasswd != "";
        }
        return false;
    }

    public void configureSingInBtn() {
        Button btnSignIn = (Button) findViewById(R.id.buttonLogin);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (!validateNim() | !validatePassword()) {
                    return;
                } else if (validation("nim")) {
                   if (validation("password")) {
                       Intent intent = new Intent(LoginPage.this, HeadPage.class);
                       intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                       startActivity(intent);
                   } else {
                       Toast.makeText(LoginPage.this, "NIM atau Password Salah!",
                               Toast.LENGTH_SHORT).show();
                   }
               } else {
                   Toast.makeText(LoginPage.this, "NIM atau Password Salah!",
                           Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    private void SignUpText() {
        TextView SignUpTxt = (TextView) findViewById(R.id.textSignUp);
        SignUpTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginPage.this, SignUpPage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    private boolean validateNim() {
        String nimInput = textNIM.getText().toString().trim();
        if (nimInput.isEmpty()) {
            textNIM.setError("Field can't be empty");
            return false;
        } else if (nimInput.length() > 15) {
            textNIM.setError("Username too long");
            return false;
        } else {
            textNIM.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = textPassword.getText().toString().trim();
        if (passwordInput.isEmpty()) {
            textPassword.setError("Field can't be Empty");
            return false;
        } else {
            textPassword.setError(null);
            return true;
        }
    }
}