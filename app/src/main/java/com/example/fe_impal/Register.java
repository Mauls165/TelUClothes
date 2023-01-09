package com.example.fe_impal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText in_email, in_username, in_password, in_conpassword;
    Button register;
    TextView login;
    ImageView back;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mAuth = FirebaseAuth.getInstance();
        in_email = findViewById(R.id.email);
        in_username = findViewById(R.id.username);
        in_password = findViewById(R.id.password);
        in_conpassword = findViewById(R.id.confirmpassword);
        register = findViewById(R.id.registerbutton);
        login = findViewById(R.id.login);
        back = findViewById(R.id.backrow);

        database = FirebaseDatabase.getInstance();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registrasi();
            }
        });
    }

    private void registrasi() {
        String getemail = in_email.getText().toString().trim();
        String getusername = in_username.getText().toString().trim();
        String getpass = in_password.getText().toString().trim();
        String getconf = in_conpassword.getText().toString().trim();

        if(getemail.isEmpty()){
            in_email.setError("Enter Email");
        }
        if(getusername.isEmpty()){
            in_username.setError("Masukkan Username anda");
        }
        if(getpass.isEmpty()){
            in_password.setError("Enter Password");
        }
        if(getconf.isEmpty()){
            in_conpassword.setError("Enter Password");
        }
        if(getconf.equals(getpass)){
            ModelUser modeluser = new ModelUser(getemail, getusername, getpass);
            mAuth.createUserWithEmailAndPassword(getemail,getpass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                ModelUser modeluser = new ModelUser(getemail, getusername, getpass);
                                String id = task.getResult().getUser().getUid();
                                database.getReference().child("User").child(id).setValue(modeluser);
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(Register.this, "Registrasi berhasil", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(Register.this, Login.class));
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(Register.this, "Registrasi gagal", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        } else{
            in_conpassword.setError("Wrong password");
        }
    }
}