package com.example.devanshi.retrofitdemo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.devanshi.retrofitdemo.db_handler.DataBaseHandler;
import com.example.devanshi.retrofitdemo.fragment.HomeFragment;
import com.example.devanshi.retrofitdemo.fragment.TaskFragment;
import com.example.devanshi.retrofitdemo.fragment.UpdateFragment;
import com.example.devanshi.retrofitdemo.model.Task;
import  com.example.devanshi.retrofitdemo.R;
import com.example.devanshi.retrofitdemo.util.Mypref;

import static com.example.devanshi.retrofitdemo.util.Mypref.Email;
import static com.example.devanshi.retrofitdemo.util.Mypref.Name;
import static com.example.devanshi.retrofitdemo.util.Mypref.Photo;


public class HomePageActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    private static final String TAG = "HomePageActivity";
    private TextView name,email,header_name;
   private ImageView image;
  private   TaskFragment taskFragment;
   private EditText et_task;
   private Toolbar toolbar;
private Task task;
private Mypref mypref=new Mypref();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        email=navigationView.getHeaderView(0).findViewById(R.id.textView);
        header_name=navigationView.getHeaderView(0).findViewById(R.id.header_name);
        image=navigationView.getHeaderView(0).findViewById(R.id.imageView);
        mypref.SharedPreferenceUtils(HomePageActivity.this);

        header_name.setText(mypref.getStringValue(Name,""));
        email.setText(mypref.getStringValue(Email,""));


        String value =mypref.getStringValue(Photo,"");
        mypref.Glide(value,HomePageActivity.this,image);

        DataBaseHandler db = new DataBaseHandler(HomePageActivity.this);


        android.support.v4.app.FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container_1,new HomeFragment());
        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }


    @Override
    public void onBackPressed()
        {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.todo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.add_todo)
        {
            taskFragment =new TaskFragment();
            task = new Task();
            View v = getLayoutInflater().inflate(R.layout.custom, null);
            this.et_task = v.findViewById(R.id.et_custom);
            AlertBox(v);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void AlertBox(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(HomePageActivity.this);
        builder.setView(v);
        builder.setTitle("Add Task");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String edittext = HomePageActivity.this.et_task.getText().toString().trim();
                task.task = edittext;
                DataBaseHandler db = new DataBaseHandler(HomePageActivity.this);
                task.task_name=mypref.getStringValue(Name,"");
                db.addTODO(task);
                android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                ft.replace(R.id.container_1, taskFragment);


                ft.commit();
            }
        });
        builder.show();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_home)
        {
            android.support.v4.app.FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container_1,new HomeFragment());
            ft.commit();
        }
        else if (id == R.id.nav_logout)
        {
            mypref.SharedPreferenceUtils(HomePageActivity.this);
            mypref.clear();
            Intent i=new Intent(HomePageActivity.this,SignInActivity.class);
            startActivity(i);
            finish();
        }
        else if (id == R.id.nav_update )
        {
            android.support.v4.app.FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container_1,new UpdateFragment());
            ft.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
