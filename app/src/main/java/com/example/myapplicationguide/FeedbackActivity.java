package com.example.myapplicationguide;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class FeedbackActivity extends AppCompatActivity {
    EditText email, name, comment;
    Button send, back, details;
    Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        comment  = findViewById(R.id.feedback);
        send = findViewById(R.id.send);
        details = findViewById(R.id.details);
        Firebase.setAndroidContext(this);
        String ID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        firebase = new Firebase("https://guide-app-d325a-default-rtdb.firebaseio.com/Users" + ID);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                details.setEnabled(true);
                final String nameData = name.getText().toString();
                final String emailData = email.getText().toString();
                final String commentData = comment.getText().toString();
                Firebase child_name = firebase.child("NAme");
                child_name.setValue(nameData);
                if(nameData.isEmpty()){
                    name.setError("Name is required");
                    send.setEnabled(false);
                }else{
                    Toast.makeText(FeedbackActivity.this, "a", Toast.LENGTH_LONG);

                    send.setEnabled(true);
                }

                Firebase child_email = firebase.child("Email");
                child_email.setValue(emailData);
                if(emailData.isEmpty()){
                    email.setError("Email is required");
                    send.setEnabled(false);
                }else{

                    send.setEnabled(true);
                }

                Firebase child_comment = firebase.child("Message");
                child_comment.setValue(commentData);
                if(commentData.isEmpty()){
                    comment.setError("Message is required");
                    send.setEnabled(false);
                }else{

                    send.setEnabled(true);
                }
                Toast.makeText(FeedbackActivity.this, "Data is sended", Toast.LENGTH_LONG).show();

                details.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new AlertDialog.Builder(FeedbackActivity.this)
                                .setTitle("details")
                                .setMessage("Name - " + nameData + "\nEmail - " + emailData + "\nMeassage - " + commentData).show();
                    }
                });


            }
        });

    }
}