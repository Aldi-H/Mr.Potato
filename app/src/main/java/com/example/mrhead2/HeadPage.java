package com.example.mrhead2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HeadPage extends AppCompatActivity {

    ImageView hair, eyebrow, beard, moustache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head_page);

        configureBackButton();
        configureContactUsBtn();
    }

    private void configureContactUsBtn() {
        Button contactUsBtn = (Button) findViewById(R.id.buttonContactUs);
        contactUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HeadPage.this, AboutUsPage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    private void configureBackButton() {
        ImageButton backButton = (ImageButton) findViewById(R.id.backIcon);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HeadPage.this, LoginPage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    public void checkAll (View view) {
        switch (view.getId()) {
            case R.id.checkBoxHair:
                hair = findViewById(R.id.hair);
                hair.setVisibility(hair.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
                break;
            case R.id.checkBoxEyebrow:
                eyebrow = findViewById(R.id.eyebrow);
                eyebrow.setVisibility(eyebrow.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
                break;
            case R.id.checkBoxBeard:
                beard = findViewById(R.id.beard);
                beard.setVisibility(beard.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
                break;
            case R.id.checkBoxMoustache:
                moustache = findViewById(R.id.moustache);
                moustache.setVisibility(moustache.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
                break;
        }
    }
}