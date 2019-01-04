package com.example.android.notes.api;

import com.example.android.notes.models.User;
import com.example.android.notes.models.Result;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

    public interface ApiClient {

        @POST("auth/register/")
        Call<User> createUser(@Body User user);

        @POST("auth/login/")
        Call<Result> createUser(@Body Result result);

    }

