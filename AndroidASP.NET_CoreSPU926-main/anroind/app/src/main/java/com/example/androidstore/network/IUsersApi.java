package com.example.androidstore.network;

import com.example.androidstore.dto.UserDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IUsersApi {
    @POST("/api/Account/register")
    Call<UserDTO> createUser(@Body UserDTO user);
}
