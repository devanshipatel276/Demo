package com.example.devanshi.retrofitdemo;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.Toolbar;

import com.example.devanshi.retrofitdemo.fragment.TabFragment;

public class Tabs extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    String name, tabs;
    Toolbar toolbar;
    private MyPagerAdapter myPagerAdapter;

    public static final String TAG = "Tabs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        viewPager = findViewById(R.id.viewPage);
        tabLayout = findViewById(R.id.tabName);

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("Value1");
        tabs = bundle.getString("Value2");
        toolbar = findViewById(R.id.toolbarTabs);
       setSupportActionBar(toolbar);
        myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager());

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle(name);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tabs.this, TabsUsingViewPager.class);
                startActivity(intent);
                finish();
            }
        });

        viewPager.setAdapter(myPagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {
        private Context mcontext;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }



        @Override
        public Fragment getItem(int position) {
            TabFragment tabFragment = new TabFragment();
            Bundle bundle = new Bundle();
                bundle.putString("TAB", String.valueOf(position + 1));
                tabFragment.setArguments(bundle);

            return tabFragment;
        }


        @Override
        public int getCount() {
            return Integer.parseInt(tabs);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = null;

                    int val = position+ 1;
                    title = "TAB " + val;

            return title;
        }
    }
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(Tabs.this, TabsUsingViewPager.class);
        startActivity(intent);
        finish();

    }

}
