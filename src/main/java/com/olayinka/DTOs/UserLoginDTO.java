package com.olayinka.DTOs;

public class UserLoginDTO {
    private String email;
    private String password;

    public String getEmail() {
        return email ;

    }

    public void setUsername(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "username='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
