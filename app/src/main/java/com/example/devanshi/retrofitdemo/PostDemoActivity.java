package com.example.devanshi.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.devanshi.retrofitdemo.model.Post;
import com.example.devanshi.retrofitdemo.retrofit.ApiInterface;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post__demo_);

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("http://34.193.110.127:82").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        ApiInterface apiInterface_post = retrofit.create(ApiInterface.class);
        Map<String, String> data = new HashMap<>();
        data.put("message", "Marcus");
        data.put("status", String.valueOf(2));
        Call<Post> call = apiInterface_post.setpost(data);

    call.enqueue(new Callback<Post>() {
        @Override
        public void onResponse(Call<Post> call, Response<Post> response)
        {
            if(response.code()==200) {
                Log.d("HEY", "Sucess:");
            }
            else
            {
                Log.d("response...",""+response.code());
            }
        }

        @Override
        public void onFailure(Call<Post> call, Throwable t) {
            Log.d("error",""+t);
        }
    });

    }
}
