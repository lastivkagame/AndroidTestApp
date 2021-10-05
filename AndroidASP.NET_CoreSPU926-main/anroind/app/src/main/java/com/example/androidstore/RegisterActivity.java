package com.example.androidstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.androidstore.application.HomeApplication;
import com.example.androidstore.dto.UserDTO;
import com.example.androidstore.network.services.UserService;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch(item.getItemId()) {
            case R.id.mhome:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.mregister:
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                return true;
            case R.id.mproducts:
                intent = new Intent(this, ProductActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void OnClickButtonRegister(View view)
    {
        final TextInputEditText email = findViewById(R.id.textInputEmail);
        final TextInputLayout emailLayout = findViewById(R.id.textFieldEmail);

        final TextInputEditText phone = findViewById(R.id.textInputPhone);
        final TextInputLayout phoneLayout = findViewById(R.id.textFieldPhone);

        final TextInputEditText passwd = findViewById(R.id.textInputPassword);
        final TextInputLayout pswdLayout = findViewById(R.id.textFieldPassword);

        if(phone.getText().toString().isEmpty())
        {
            phoneLayout.setError("Не вказали телефон");
        }
        else {
            phoneLayout.setError(null);
        }

        if(email.getText().toString().isEmpty()){
            emailLayout.setError("Не вказали email");
        }
        else {
            emailLayout.setError(null);
        }

        if(passwd.getText().toString().isEmpty()){
            pswdLayout.setError("Не вказали password");
        }
        else {
            pswdLayout.setError(null);
        }


        UserDTO user = new UserDTO(email.getText().toString(), phone.getText().toString(),passwd.getText().toString() );
        //progressBar.setVisibility(View.VISIBLE);
        UserService.getInstance().createUser(user, new Callback<UserDTO>() {
                    @Override
                    public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
                        //progressBar.setVisibility(View.GONE);
                        UserDTO responseUser = response.body();
                        if (response.isSuccessful() && responseUser != null) {
                     /* Toast.makeText(MainActivity.this,
                            String.format("User %s with job %s was created at %s with id %s",
                                    responseUser.getName(),
                                    responseUser.getJob(),
                                    responseUser.getCreatedAt(),
                                    responseUser.getId()),
                            Toast.LENGTH_LONG)
                            .show();*/
                        } else {
                    /*Toast.makeText(MainActivity.this,
                            String.format("Response is %s", String.valueOf(response.code()))
                            , Toast.LENGTH_LONG).show();*/
                        }
                    }

                    @Override
                    public void onFailure(Call<UserDTO> call, Throwable t) {
                        //progressBar.setVisibility(View.GONE);
                /*Toast.makeText(UserService.getInstance(),
                        "Error is " + t.getMessage()
                        , Toast.LENGTH_LONG).show();*/
                    }

                });
        //Log.d("btnRegInfo", email.getText().toString());
    }



    public void OnClickProductsActivity(View view) {
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);
    }
}