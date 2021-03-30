package com.example.mrhead2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class SignUpPage extends AppCompatActivity implements  View.OnClickListener {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[a-zA-Z])" +  //Any letter
                    "(?=\\S+$)" +       //No white space
                    ".{4,}" +           //At least 4 char
                    "$");

    EditText textNama, textNim, textEmail, textPwd;
    String inputNim, inputPasswd;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        textNama = (EditText) findViewById(R.id.editTextUsername);
        textEmail = (EditText) findViewById(R.id.editTextMail);

        btnSignUp = findViewById(R.id.buttonSignUp);
        btnSignUp.setOnClickListener(this);

        //configureSignUpBtn();
        SignInText();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == btnSignUp.getId()) {
            Intent intent = new Intent(SignUpPage.this, LoginPage.class);

            textNim = (EditText) findViewById(R.id.editTextNIM);
            textPwd = (EditText) findViewById(R.id.editTextPassword);

            inputNim = textNim.getText().toString();
            inputPasswd = textPwd.getText().toString();

            intent.putExtra("nim", inputNim);
            intent.putExtra("password", inputPasswd);

            startActivity(intent);
        }
    }

    private void SignInText() {
        TextView SignInTxt = (TextView) findViewById(R.id.textSignIn);
        SignInTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpPage.this, LoginPage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    private boolean validateName() {
        String nameInput = textNama.getText().toString().trim();

        if (nameInput.isEmpty()) {
            textNama.setError("Field Can`t be Empty");
            return false;
        } else if (nameInput.length() > 15) {
            textNama.setError("Username Too Long");
            return false;
        }  else {
            textNama.setError(null);
            return true;
        }
    }

    private boolean validateNim() {
        String nimInput = textNim.getText().toString().trim();

        if (nimInput.isEmpty()) {
            textNim.setError("Field Can`t be Empty");
            return false;
        } else {
            textNim.setError(null);
            return true;
        }
    }

    private boolean validateEmail() {
        String emailInput = textEmail.getText().toString().trim();

        if (emailInput.isEmpty()) {
            textEmail.setError("Field can`t be Empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textEmail.setError("Please enter a valid email");
            return false;
        } else {
            textEmail.setError(null);
            return true;
        }
    }

    private boolean validatePwd() {
        String pwdInput = textPwd.getText().toString().trim();

        if (pwdInput.isEmpty()) {
            textPwd.setError("Field Can`t be Empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(pwdInput).matches()) {
            textPwd.setError("Password Too Weak");
            return false;
        } else {
            textPwd.setError(null);
            return true;
        }
    }
}