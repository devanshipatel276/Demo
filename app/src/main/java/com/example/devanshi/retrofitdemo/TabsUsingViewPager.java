package com.example.devanshi.retrofitdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TabsUsingViewPager extends AppCompatActivity
{
    Button submit;
    String NAME,TABS;
    EditText name,tabs;
    private static final String TAG="TabsUsingViewPAger";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_using_view_pager);

       name=findViewById(R.id.etName);
        tabs=findViewById(R.id.etTabs);

        submit=findViewById(R.id.submitTabs);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                NAME=name.getText().toString().trim();
                TABS=tabs.getText().toString().trim();
                Intent i=new Intent(TabsUsingViewPager.this,Tabs.class);
                i.putExtra("Value1",NAME);
                i.putExtra("Value2",TABS);
                startActivity(i);
                finish();

            }
        });

    }
    @Override
    public void onBackPressed()
    {
        finish();

    }

}
