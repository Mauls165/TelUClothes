package com.example.fe_impal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Wash_history extends AppCompatActivity {

    ImageView icn_dry, icn_iron, icn_finish, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wash_history);

        icn_dry = findViewById(R.id.dry);
        icn_iron = findViewById(R.id.iron);
        back = findViewById(R.id.backrow);
        icn_finish = findViewById(R.id.finish);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Wash_history.this, Home.class));
                finish();
            }
        });

        icn_dry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Wash_history.this, Dry_history.class));
                finish();
            }
        });

        icn_iron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Wash_history.this, Iron_history.class));
                finish();
            }
        });

        icn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Wash_history.this, Finish_history.class));
                finish();
            }
        });

    }
}