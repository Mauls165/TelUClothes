package com.example.fe_impal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Home extends AppCompatActivity {

    ImageView btnorder, notifbtn, hstrymenu, menu;
    LinearLayout dry, iron, deliv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnorder = findViewById(R.id.order);
        notifbtn = findViewById(R.id.notifikasi);
        dry = findViewById(R.id.historydrying);
        iron = findViewById(R.id.historyiron);
        deliv = findViewById(R.id.historydeliv);
        hstrymenu = findViewById(R.id.historymenu);
        menu = findViewById(R.id.profilebtn);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Profile.class));
                finish();
            }
        });

        hstrymenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Wash_history.class));
                finish();
            }
        });

        btnorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, order_list.class));
                finish();
            }
        });

        notifbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, notification.class));
                finish();
            }
        });

        dry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Dry_history.class));
                finish();
            }
        });

        iron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Iron_history.class));
                finish();
            }
        });

        deliv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Finish_history.class));
                finish();
            }
        });

    }
}