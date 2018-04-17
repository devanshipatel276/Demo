package com.example.devanshi.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.devanshi.retrofitdemo.adapter.PostAdapter;
import com.example.devanshi.retrofitdemo.model.Post;
import com.example.devanshi.retrofitdemo.retrofit.ApiInterface;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDemoActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    ApiInterface apiInterface;
    List<Post.DataBean.BasketsBean> list;
    PostAdapter postAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit__demo_);

        recyclerView = findViewById(R.id.retrofit_demo_recyclerView);
        layoutManager = new LinearLayoutManager(RetrofitDemoActivity.this);


        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100,TimeUnit.SECONDS).build();

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("http://www.mocky.io/v2/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        apiInterface = retrofit.create(ApiInterface.class);
      //
        // Call<Post> call = apiInterface.getData("YWRtaW4udXNlckBwcm90ZWVuLmNvbTokMnkkMTAkWWlqUTNNR2owOEtuTEhtdS9JS3E4dU55dFFMajBwMHV4VVhBUjZ5eHNjSDlrMUxIVzZBdDI",4,"cm9uYWsuaW5leHR1cmVAZ21haWwuY29tOjU4NTNjZWMzMjlhNmMxLjE3NDA2MTM5");
       Call<Post> call= apiInterface.getdata();
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response)
            {
                Log.d("hey","response="+response.body());
                Log.d("Hey","response code="+ response.code());

                final List<Post.DataBean.BasketsBean> baskets = response.body().getData().getBaskets();
                list=baskets;
                postAdapter = new PostAdapter(getApplicationContext(),list);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RetrofitDemoActivity.this);
                recyclerView.setAdapter(postAdapter);
                recyclerView.setLayoutManager(layoutManager);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
            Log.d("Error",""+t);
            }
        });



    }
}
