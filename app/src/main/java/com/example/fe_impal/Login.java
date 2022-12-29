package com.example.fe_impal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText in_email, in_password;
    Button logbutton;
    TextView fgtpass, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        in_email = findViewById(R.id.email);
        in_password = findViewById(R.id.password);
        logbutton = findViewById(R.id.logbutton);
        fgtpass = findViewById(R.id.fgpass);
        signup = findViewById(R.id.Signup);

        logbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cekLogin();
            }
        });

        fgtpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, ForgotPass.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }

    private void cekLogin() {
        String email = in_email.getText().toString().trim();
        String pass = in_password.getText().toString().trim();

        if(email.isEmpty()){
            in_email.setError("Masukkan Email/No Handphone dengan benar");
            return;
        }
        if(pass.isEmpty()){
            in_password.setError("Masukkan Password");
            return;
        }
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(Login.this, "Login berhasil", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(Login.this, Home.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Login.this, "Login gagal, Email atau Password salah", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}