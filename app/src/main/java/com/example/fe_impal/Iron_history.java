package com.example.fe_impal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Iron_history extends AppCompatActivity {

    ImageView icn_dry, icn_wash, icn_finish, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iron_history);

        icn_dry = findViewById(R.id.dry);
        icn_wash = findViewById(R.id.wash);
        back = findViewById(R.id.backrow);
        icn_finish = findViewById(R.id.finish);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Iron_history.this, Home.class));
                finish();
            }
        });

        icn_dry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Iron_history.this, Dry_history.class));
                finish();
            }
        });

        icn_wash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Iron_history.this, Wash_history.class));
                finish();
            }
        });

        icn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Iron_history.this, Finish_history.class));
                finish();
            }
        });

    }
}