package com.example.myapplicationguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SingUp extends AppCompatActivity {
    EditText email , password;

    Button button;
    FirebaseAuth auth;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);

        button = findViewById(R.id.signup_button);
        auth = FirebaseAuth.getInstance();



        if (auth.getCurrentUser()!=null){
            Toast.makeText(SingUp.this, "You have been already registered", Toast.LENGTH_LONG).show();

        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em = email.getText().toString().trim();
                String passw = password.getText().toString().trim();
                if (TextUtils.isEmpty(em)){
                    email.setError("Email is required");
                    button.setEnabled(false);
                }else{
                    button.setEnabled(true);
                }
                if (TextUtils.isEmpty(passw)){
                    password.setError("Password is required");
                    button.setEnabled(false);
                }else{
                    button.setEnabled(true);
                }
                if (passw.length() < 6){
                    password.setError(">6 must");
                    button.setEnabled(false);
                }else{
                    button.setEnabled(true);
                }


                auth.createUserWithEmailAndPassword(em, passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SingUp.this, "Successfully", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(SingUp.this, InfoActivity.class);
                            startActivity(i);

                        }else{
                            Toast.makeText(SingUp.this, "Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });



    }
}