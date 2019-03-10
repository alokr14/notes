package com.example.android.notes.api;

import com.example.android.notes.beans.Post;
import com.example.android.notes.beans.PostList;
import com.example.android.notes.models.Auth;
import com.example.android.notes.models.MyResponse;
import com.example.android.notes.models.Profile;
import com.example.android.notes.models.User;
import com.example.android.notes.models.Result;


import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiClient {

        @POST("api/register")
        Call<User> createUser(@Body User user);

        @POST("api/login")
        Call<Result> createUser(@Body Result result);


        @GET("api/details")
        Call<Profile> viewProfile(@Header("Authorization") String authToken);


//        @GET("logout/")
//        Call<ResponseBody> logOut(@Header("Authorzation") String authtoken);

//        @GET("api/post/create")
//        Call<User> createPost(@Body User user);

//        @GET("api/post")
//        Call<User> showPost(@Body User user);


        @GET("api/showall/1")
        Call<PostList> getMyJSON();


        @Multipart
        @POST("api/store/1")
        Call<MyResponse> uploadImage(@Part("file\"; filename=\"myfile.jpg\" ") RequestBody file, @Part("desc") RequestBody desc);

    }

