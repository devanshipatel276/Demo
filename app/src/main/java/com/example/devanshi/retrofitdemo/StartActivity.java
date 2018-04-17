package com.example.devanshi.retrofitdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btnRetroDemo=findViewById(R.id.btn_main_activity);
        btnRetroDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StartActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        Button btnPostRetro=findViewById(R.id.btn_post_retrofit);
        btnPostRetro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StartActivity.this,PostretRofitActivity.class);
                startActivity(i);
            }
        });

        Button btnPostDemo=findViewById(R.id.btn_post_demo);
        btnPostDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StartActivity.this,PostDemoActivity.class);
                startActivity(i);
            }
        });

        Button btnretroPost=findViewById(R.id.btn_retro_post_demo);
        btnretroPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StartActivity.this,RetrofitDemoActivity.class);
                startActivity(i);
            }
        });

        Button btnsplash=findViewById(R.id.btn_spash_activity);
        btnsplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StartActivity.this, SplashActivity.class);
                startActivity(i);
            }
        });

        Button btnTabs=findViewById(R.id.btn_tabs_activity);
        btnTabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StartActivity.this,TabsUsingViewPager.class);
                startActivity(i);
            }
        });

    }
}
