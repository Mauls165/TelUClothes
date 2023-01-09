package com.example.fe_impal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    ImageView back;
    ImageView btnorder, notifbtn, hstrymenu, home;
    TextView logoutbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        notifbtn = findViewById(R.id.notifikasi);
        hstrymenu = findViewById(R.id.historymenu);
        home = findViewById(R.id.homemenu);
        btnorder = findViewById(R.id.order);
        back = findViewById(R.id.backrow);
        logoutbtn = findViewById(R.id.logout);

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, Login.class));
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, Home.class));
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, Home.class));
                finish();
            }
        });

        hstrymenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, Wash_history.class));
                finish();
            }
        });

        btnorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, order_list.class));
                finish();
            }
        });

        notifbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Profile.this, notification.class));
                finish();
            }
        });

    }
}