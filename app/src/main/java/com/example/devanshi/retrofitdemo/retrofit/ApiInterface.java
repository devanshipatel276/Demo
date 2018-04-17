package com.example.devanshi.retrofitdemo.retrofit;

import com.example.devanshi.retrofitdemo.model.Comment;
import com.example.devanshi.retrofitdemo.model.Post;
import com.example.devanshi.retrofitdemo.model.PostResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Devanshi on 28-02-2018.
 */

public interface ApiInterface
{
    @GET("posts")
    Call<List<PostResponse>> getpost();

    @GET("comments")
    Call<List<Comment>> getComment(@Query("postId") int postId);
    @GET("posts")
    Call<List<PostResponse>> getpost(@Query("userId") int userId);

    @POST("posts")
    @FormUrlEncoded
    Call<PostResponse> setpost(@Field("id") int i1, @Field("userId") int i, @Field("title") String stitle, @Field("body") String sbody);

    @POST("webservice")
    Call<Post> setpost(@QueryMap Map<String,String> data );

    //@Headers("YWRtaW4udXNlckBwcm90ZWVuLmNvbTokMnkkMTAkWWlqUTNNR2owOEtuTEhtdS9JS3E4dU55dFFMajBwMHV4VVhBUjZ5eHNjSDlrMUxIVzZBdDI")
    @POST("api/getAllBasktes")
    @FormUrlEncoded
    Call<Post> getData(@Header("Authorization") String authorization, @Field("Id") int userId, @Field("login") String loginToken );
    @POST("5a9d201f3100004a1dab5265")
    Call<Post> getdata();
}
