package com.example.android.notes.models;

public class User {

    private String name;
    private String password;
    private String email;
    private String c_password;

    public void setName(String name) {this.name =name;}

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCPassword(String c_password) {
        this.c_password= c_password;
    }

    public String getName() {return name;}

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCPassword() {
        return c_password;
    }

}