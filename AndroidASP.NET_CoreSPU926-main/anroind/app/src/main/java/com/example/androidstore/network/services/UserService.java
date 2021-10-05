package com.example.androidstore.network.services;

import com.example.androidstore.constans.Urls;
import com.example.androidstore.dto.UserDTO;
import com.example.androidstore.network.IUsersApi;
import com.example.androidstore.network.ProductApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserService {
    private static IUsersApi service;
    //private static ApiManager apiManager;

    private static UserService mInstance;
    private static final String BASE_URL = Urls.BASE;
    private Retrofit mRetrofit;

    private UserService() {

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static UserService getInstance() {
        if (mInstance == null) {
            mInstance = new UserService();
        }
        return mInstance;
    }
    public void createUser(UserDTO user, Callback<UserDTO> callback) {
        Call<UserDTO> userCall = service.createUser(user);
        userCall.enqueue(callback);
    }

   /* public IUsersApi getUsersApi() {
        return mRetrofit.create(ProductApi.class);
    }*/
}
