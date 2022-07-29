package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.multidex.MultiDex;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        MultiDex.install(this);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(firebaseAuth.getCurrentUser().getEmail().isEmpty())
                {
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                }
                else
                {
                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));

                }
            }
        },3000);
    }
}