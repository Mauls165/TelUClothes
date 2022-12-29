package com.example.fe_impal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangePass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);

        Button register;
        EditText in_pass1, in_pass2;

        register = findViewById(R.id.registerbutton);
        in_pass1 = findViewById(R.id.pass1);
        in_pass2 = findViewById(R.id.pass2);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass1 = in_pass1.getText().toString().trim();
                String pass2 = in_pass2.getText().toString().trim();

                if(pass2.equals(pass1)) {
                    Intent intent = new Intent(ChangePass.this, Login.class);
                    startActivity(intent);
                } else {
                    in_pass2.setError("Masukkan password dengan benar");
                    return;
                }
            }
        });
    }
}