package com.example.android.notes.api;

import com.example.android.notes.models.Auth;
import com.example.android.notes.models.MyResponse;
import com.example.android.notes.models.User;
import com.example.android.notes.models.Result;


import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiClient {

        @POST("api/register")
        Call<User> createUser(@Body User user);

        @POST("api/login")
        Call<Result> createUser(@Body Result result);

        @GET("user/classroom/")
        Call<ResponseBody> getAuth(@Header("Authorization") String authToken);

//        @GET("api/post/create")
//        Call<User> createPost(@Body User user);

//        @GET("api/post")
//        Call<User> showPost(@Body User user);

//        @GET("api/details")
//        Call<User> details(@Body User user);

        String BASE_URL = "ENTER BASE URL FOR FILE UPLOAD";

        //this is our multipart request
        //we have two parameters on is name and other one is description
        @Multipart
        @POST("REMAINING PART OF URL")
        Call<MyResponse> uploadImage(@Part("image\"; filename=\"myfile.jpg\" ") RequestBody file, @Part("desc") RequestBody desc);

    }

