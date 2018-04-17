package com.example.devanshi.retrofitdemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


                Intent i=new Intent(SplashActivity.this, SignInActivity.class);
                startActivity(i);
                finish();

    }
}
