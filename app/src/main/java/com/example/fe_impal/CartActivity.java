package com.example.fe_impal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class CartActivity extends AppCompatActivity {

    RecyclerView itemincart;
    ImageView back, conforderbtn;
    TextView in_subtotal, in_subtotaljasa, in_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        itemincart = findViewById(R.id.itemorder);
        back = findViewById(R.id.backrow);
        in_subtotal = findViewById(R.id.subtotal);
        in_subtotaljasa = findViewById(R.id.subtotaljasa);
        in_total = findViewById(R.id.total);
        conforderbtn = findViewById(R.id.conforder);

        conforderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, PopUp_confOrder.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, order_list.class);
                startActivity(intent);
            }
        });
    }
}