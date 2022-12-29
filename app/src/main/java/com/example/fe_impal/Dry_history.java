package com.example.fe_impal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Dry_history extends AppCompatActivity {

    ImageView icn_wash, icn_iron, icn_finish, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dry_history);

        icn_wash = findViewById(R.id.wash);
        icn_iron = findViewById(R.id.iron);
        back = findViewById(R.id.backrow);
        icn_finish = findViewById(R.id.finish);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dry_history.this, Home.class));
                finish();
            }
        });

        icn_wash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dry_history.this, Wash_history.class));
                finish();
            }
        });

        icn_iron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dry_history.this, Iron_history.class));
                finish();
            }
        });

        icn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dry_history.this, Finish_history.class));
                finish();
            }
        });
    }
}