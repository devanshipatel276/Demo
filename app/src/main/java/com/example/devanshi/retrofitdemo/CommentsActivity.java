package com.example.devanshi.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.devanshi.retrofitdemo.adapter.CommentAdapter;
import com.example.devanshi.retrofitdemo.model.Comment;
import com.example.devanshi.retrofitdemo.retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommentsActivity extends AppCompatActivity {

    RecyclerView rv;
    ApiInterface apiInterface;
    private CommentAdapter commentAdapter;
    private List<Comment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        rv=findViewById(R.id.recyclerComment);

        Bundle extras = getIntent().getExtras();
        int value1 = extras.getInt("UserId");
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();
        apiInterface =retrofit.create(ApiInterface.class);

        Call<List<Comment>> call= apiInterface.getComment(value1);
        call.enqueue(new Callback<List<Comment>>()
        {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response)
            {
                List<Comment> body=response.body();
                list=body;
                commentAdapter = new CommentAdapter(list);
                RecyclerView.LayoutManager  layoutManager=new LinearLayoutManager(CommentsActivity.this);
                rv.setAdapter(commentAdapter);
                rv.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t)
            {

            }
        });

    }
}
