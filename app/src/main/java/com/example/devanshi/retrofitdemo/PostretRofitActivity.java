package com.example.devanshi.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.devanshi.retrofitdemo.model.PostResponse;
import com.example.devanshi.retrofitdemo.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostretRofitActivity extends AppCompatActivity {
    EditText title, body;
    Button submit;
    String Stitle, Sbody;
    private static final String TAG = "HEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_retrofit);

        title = findViewById(R.id.etTitle);
        body = findViewById(R.id.etBody);
        submit = findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stitle = title.getText().toString();
                Sbody = body.getText().toString();
                //  send(Stitle, Sbody);
                Retrofit.Builder builder = new Retrofit.Builder();
                builder.baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create());
                Retrofit retrofit = builder.build();
                ApiInterface apiInterface_post = retrofit.create(ApiInterface.class);
                Call<PostResponse> call = apiInterface_post.setpost(1,1, Stitle, Sbody);

//                Gson gson = new Gson();
//                PostResponse postResponse = new PostResponse();
//                String json = gson.toJson(postResponse);
//                PostResponse lcs = gson.fromJson(json, PostResponse.class);
                // Toast.makeText(PostretRofitActivity.this, "Sucessful", Toast.LENGTH_SHORT).show();

                //  Type collectionType = new TypeToken<Collection<PostResponse>>(){}.getType();
                //Collection<PostResponse> enums = gson.fromJson(json, collectionType);
                call.enqueue(new Callback<PostResponse>() {
                    @Override
                    public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                        //   Log.i(TAG, "post submitted to ApiInterface." + response.body().toString());
                        //Log.i(TAG, "onResponse: " +
                        if (response.code() == 200) {
                            Log.d(TAG, "onResponse: .........Success");
                        } else {
                            Log.d(TAG, "onResponse: ........" + response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<PostResponse> call, Throwable t) {

                    }
                });

            }
        });

    }
}
