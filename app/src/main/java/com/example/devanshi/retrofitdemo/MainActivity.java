package com.example.devanshi.retrofitdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.devanshi.retrofitdemo.adapter.RetroRecyclerAdapter;
import com.example.devanshi.retrofitdemo.model.PostResponse;
import com.example.devanshi.retrofitdemo.retrofit.ApiInterface;
import com.example.devanshi.retrofitdemo.util.CustomItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RetroRecyclerAdapter retroRecyclerAdapter;
    private List<PostResponse> list;
    RecyclerView recyclerView;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerRetro);

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        apiInterface = retrofit.create(ApiInterface.class);
        fetchnews();
    }

    private void fetchnews()
    {

        Call<List<PostResponse>> call = apiInterface.getpost();
        call.enqueue(new Callback<List<PostResponse>>()
        {
            @Override
            public void onResponse(Call<List<PostResponse>> call, Response<List<PostResponse>> response)
            {
                List<PostResponse> body = response.body();
                list = body;
                retroRecyclerAdapter = new RetroRecyclerAdapter(list);
                retroRecyclerAdapter = new RetroRecyclerAdapter(getApplicationContext(), list, new CustomItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position)
                    {
                    int value=list.get(position).getUserId();
                        Intent i = new Intent(MainActivity.this, CommentsActivity.class);
                        i.putExtra("UserId", value);
                        startActivity(i);
                    }

                });

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setAdapter(retroRecyclerAdapter);
                recyclerView.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Call<List<PostResponse>> call, Throwable t) {

            }
        });
    }

}
