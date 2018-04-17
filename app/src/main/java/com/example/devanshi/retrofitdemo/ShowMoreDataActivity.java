package com.example.devanshi.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowMoreDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_more_data);

        Bundle bundle=getIntent().getExtras();
        String title=bundle.getString("title");
        String info=bundle.getString("Info");

        TextView Title=findViewById(R.id.show_more_title);
        TextView Info=findViewById(R.id.show_more_info);

        Title.setText(title);
        Info.setText(info);
    }
}
