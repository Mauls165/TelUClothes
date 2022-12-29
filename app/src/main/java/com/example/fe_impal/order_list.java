package com.example.fe_impal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class order_list extends AppCompatActivity {

    private TextView item, numberorder;
    private ImageView plustbtn, minbtn, addtochart, btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        btnback = findViewById(R.id.backrow);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(order_list.this, Home.class);
                startActivity(intent);
                finish();
            }
        });
    }


}