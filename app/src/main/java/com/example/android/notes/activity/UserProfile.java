package com.example.android.notes.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.android.notes.R;
import com.example.android.notes.api.ApiClient;
import com.example.android.notes.httpHandler.HttpService;
import com.example.android.notes.models.Profile;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfile  extends AppCompatActivity {

        private TextView userEmail,userName;
        private Context mContext;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile);

            userName = (TextView) findViewById(R.id.profile_name);
            userEmail = (TextView) findViewById(R.id.profile_email);


            viewProfile();
        }

        private void viewProfile() {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Profile");
            progressDialog.show();


            ApiClient service = HttpService.getClient().create(ApiClient.class);
            Call<Profile> call = service.viewProfile("JWT " +LoginActivity.token);

            mContext = getApplicationContext();

            call.enqueue(new Callback<Profile>() {
                @Override
                public void onResponse( Call<Profile> call, Response<Profile> userResponse) {
                    progressDialog.dismiss();

                    if(userResponse.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "success1", Toast.LENGTH_LONG).show();
                        String user_name = userResponse.body().getName();
                        userName.setText("Name: " +user_name);
                        String user_email = userResponse.body().getEmail();
                        userEmail.setText("Email: "+user_email);

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "profile not created", Toast.LENGTH_LONG).show();
                    }

                }


                @Override
                public void onFailure( Call<Profile> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                }
            });

        }

        @Override
        public void onBackPressed()
        {
            super.onBackPressed();
            startActivity(new Intent(UserProfile.this,MainActivity.class));
            finish();

        }
    }


