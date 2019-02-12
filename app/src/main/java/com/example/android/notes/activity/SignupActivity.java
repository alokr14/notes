package com.example.android.notes.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.notes.R;
import com.example.android.notes.api.ApiClient;
import com.example.android.notes.httpHandler.HttpService;
import com.example.android.notes.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonSignUp;
    private TextView logintext;
    private EditText editTextName, editTextEmail, editTextPassword,editTextCPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        logintext = (TextView) findViewById(R.id.logintext);
        buttonSignUp = (Button) findViewById(R.id.buttonRegister);

        editTextName = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextCPassword = (EditText) findViewById(R.id.editTextCPassword);

        logintext.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);
    }

    private void userSignUp(){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up....");
        progressDialog.show();

        ApiClient service = HttpService.getClient().create(ApiClient.class);

        User user = new User();

        user.setName( editTextName.getText().toString().trim());
        user.setPassword( editTextPassword.getText().toString().trim());
        user.setEmail(editTextEmail.getText().toString().trim());
        user.setCPassword(editTextCPassword.getText().toString().trim());

        Call<User> call = service.createUser(user);



        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse( Call<User> call, Response<User> userResponse) {
                progressDialog.dismiss();

                userResponse.code();

                Toast.makeText(getApplicationContext(), "successful", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure( Call<User> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Fill Correct Credentials", Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    public void onClick(View view) {
        if (view == buttonSignUp) {
            userSignUp();
        }

        if(view == logintext) {
            Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
            startActivity(intent);
        }
    }
    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
