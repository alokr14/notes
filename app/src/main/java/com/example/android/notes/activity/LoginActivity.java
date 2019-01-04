package com.example.android.notes.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.notes.R;
import com.example.android.notes.api.ApiClient;
import com.example.android.notes.httpHandler.HttpService;
import com.example.android.notes.models.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonLogIn;
    private EditText userName,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogIn = (Button) findViewById(R.id.buttonLogin);

        userName = (EditText) findViewById(R.id.editTextUsernameLogin);
        password = (EditText) findViewById(R.id.editTextPasswordLogin);
        buttonLogIn.setOnClickListener(this);
    }

    private void userLogIn(){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        ApiClient service = HttpService.getClient().create(ApiClient.class);

        Result result = new Result();

        result.setUsername( userName.getText().toString().trim());
        result.setPassword( password.getText().toString().trim());

        Call<Result> call = service.createUser(result);



        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse( Call<Result> call, Response<Result> userResponse) {
                //hiding progress dialog
                progressDialog.dismiss();

                userResponse.code();
                //displaying the message from the response as toast
                Toast.makeText(getApplicationContext(), "successful", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure( Call<Result> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    public void onClick(View v) {
        if (v == buttonLogIn) {
            userLogIn();
        }

    }
}
