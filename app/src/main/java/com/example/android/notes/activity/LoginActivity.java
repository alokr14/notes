package com.example.android.notes.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.notes.R;
import com.example.android.notes.api.ApiClient;
import com.example.android.notes.httpHandler.HttpService;
import com.example.android.notes.models.Auth;
import com.example.android.notes.models.Result;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonLogIn;
    private EditText email,password;
    public static String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogIn = (Button) findViewById(R.id.buttonLogin);
        email = (EditText) findViewById(R.id.editTextEmailLogin);
        password = (EditText) findViewById(R.id.editTextPasswordLogin);
        buttonLogIn.setOnClickListener(this);
    }

    private void userLogIn(){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        ApiClient service = HttpService.getClient().create(ApiClient.class);

        Result result = new Result();
        result.setEmail( email.getText().toString().trim());
        result.setPassword( password.getText().toString().trim());

        Call<Result> call = service.createUser(result);



        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse( Call<Result> call, Response<Result> userResponse) {
                progressDialog.dismiss();

                if(userResponse.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "successfull", Toast.LENGTH_LONG).show();
                  token = userResponse.body().getToken();
//                    Log.e("value",token);

                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
//                    getAuth();
                }
                else{
                    Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure( Call<Result> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
    public static String get_Token() {
        return token;
    }

//    public void getAuth(){
//
//        ApiClient service = HttpService.getClient().create(ApiClient.class);
//
//        Call<ResponseBody> call = service.getAuth("JWT " +token);
//
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.isSuccessful()){
//                    Toast.makeText(getApplicationContext(), "authentication successfull", Toast.LENGTH_LONG).show();
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "token is not correct", Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
//            }
//        });
//    }


    @Override
    public void onClick(View view) {
        if (view == buttonLogIn) {
            userLogIn();
        }

    }
    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
