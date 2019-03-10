package com.example.android.notes.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Post {
    @SerializedName("id")
    @Expose
    private Integer employeeId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("size")
    @Expose
    private String dob;
    @SerializedName("user_id")
    @Expose
    private String designation;
    @SerializedName("created_at")
    @Expose
    private String contactNumber;
    @SerializedName("updated_at")
    @Expose
    private String email;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}