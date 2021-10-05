package com.example.androidstore.dto;

import lombok.Data;

@Data
public class UserDTO {
    public String Email;
    public String Phone;
    public String Password;

    public UserDTO(String email, String phone, String password) {
        Email = email;
        Phone = phone;
        Password = password;
    }

    public UserDTO() {
    }
}
